package de.tobj.twitch.streamobserver;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.tobj.http.simplerequest.HTTPRequestJSON;
import de.tobj.http.simplerequest.exception.ConnectorException;
import de.tobj.http.simplerequest.exception.ParserException;
import de.tobj.http.simplerequest.exception.StatusCodeException;
import de.tobj.twitch.streamobserver.channel.Channel;
import de.tobj.twitch.streamobserver.channel.NotifyStatusUpdateRunner;
import de.tobj.twitch.streamobserver.channel.NotifyStreamUpdateRunner;
import de.tobj.twitch.streamobserver.channel.event.StreamStatusEvent;
import de.tobj.twitch.streamobserver.channel.event.StreamUpdateEvent;
import de.tobj.twitch.streamobserver.channel.listener.StreamListener;
import de.tobj.twitch.streamobserver.channel.request.StreamRequest;
import de.tobj.twitch.streamobserver.channel.result.StreamResult;

public class TwitchStreamObserver extends Thread {
	private static final Logger logger = LogManager.getLogger(TwitchStreamObserver.class);

	private HTTPRequestJSON twitchClient = null;
	private List<Channel> channels = Collections.synchronizedList(new LinkedList<Channel>());
	private List<StreamListener> streamListeners = Collections.synchronizedList(new LinkedList<StreamListener>());
	private static String defaultBaseUrl = "https://api.twitch.tv/kraken/";
	private static long defaultTimeout = TimeUnit.MINUTES.toSeconds(1);
	private long timeout = 0;
	private String clientId;

	/**
	 * Constructor
	 * 
	 * @param baseUrl
	 * @param timeout
	 */
	public TwitchStreamObserver(String clientId, String baseUrl, long timeout) {
		this.twitchClient = new HTTPRequestJSON(baseUrl);
		this.timeout = timeout;
		this.clientId = clientId;
	}

	/**
	 * Constructor with defaultTimeout
	 * 
	 * @param baseUrl
	 */
	public TwitchStreamObserver(String clientId, String baseUrl) {
		this(clientId, baseUrl, defaultTimeout);
	}

	/**
	 * Constructor with defaultBaseUrl
	 * 
	 * @param timout
	 */
	public TwitchStreamObserver(String clientId, long timout) {
		this(clientId, defaultBaseUrl, timout);
	}

	/**
	 * Constructor with defaultBaseUrl and defaultTimeout
	 */
	public TwitchStreamObserver(String clientId) {
		this(clientId, defaultBaseUrl, defaultTimeout);
	}

	/**
	 * start checkin streams periodically
	 */
	@Override
	public void run() {
		logger.debug("run()...");
		while (true) {
			logger.debug("checkStreams...");
			checkStreams();
			logger.debug("checkStreams... done!");

			try {
				logger.debug("sleep for {} seconds, or {} millis...", timeout, TimeUnit.SECONDS.toMillis(timeout));
				Thread.sleep(TimeUnit.SECONDS.toMillis(timeout));
			} catch (InterruptedException e) {
				logger.info(e);
			}
		}
	}

	/**
	 * check all streams
	 */
	private void checkStreams() {
		synchronized (channels) {
			for (Channel channel : channels) {
				checkStream(channel);
			}
		}
	}

	/**
	 * check a single stream
	 * 
	 * @param channel
	 */
	private void checkStream(Channel channel) {
		try {
			StreamResult stream = twitchClient.request(new StreamRequest(channel, clientId), new StreamResult());
			if (channel.isOnline() != stream.isOnline()) {
				Date lastStatusChange = channel.getLastStatusChange();
				Date currentStatusChangeDate = new Date();

				StreamStatusEvent event = new StreamStatusEvent(channel.getChannelName(), stream.getStreamData(),
						stream.isOnline(), lastStatusChange, currentStatusChangeDate);
				logger.info("new streamStatusEvent: {}", event.toString());
				new NotifyStatusUpdateRunner(streamListeners, event).start();

				channel.setOnline(stream.isOnline());
				channel.setLastStatusChange(currentStatusChangeDate);
			}
			if (stream.isOnline()) {
				StreamUpdateEvent event = new StreamUpdateEvent(channel.getChannelName(), stream.getStreamData());
				logger.info("new streamUpdateEvent: {}", event.toString());
				new NotifyStreamUpdateRunner(streamListeners, event).start();
			}
		} catch (ConnectorException | ParserException | StatusCodeException e) {
			logger.error("error at checking stream: {}", channel.getChannelName());
			logger.error(e);
		}
	}

	/**
	 * add channel for checking
	 * 
	 * @param channelName
	 */
	public void addChannel(String channelName) {
		if (containsChannel(channelName))
			return;
		synchronized (channels) {
			this.channels.add(new Channel(channelName));
		}
	}

	/**
	 * remove channel
	 * 
	 * @param channelName
	 */
	public void removeChannel(String channelName) {
		for (Channel channel : channels) {
			if (channel.getChannelName().equalsIgnoreCase(channelName)) {
				synchronized (channels) {
					channels.remove(channel);
					return;
				}
			}
		}
	}

	/**
	 * checks if channel is already added
	 * 
	 * @param channelName
	 * @return
	 */
	public boolean containsChannel(String channelName) {
		for (Channel channel : channels) {
			if (channel.getChannelName().equalsIgnoreCase(channelName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * add listener
	 * 
	 * @param listener
	 */
	public void addListener(StreamListener listener) {
		synchronized (streamListeners) {
			this.streamListeners.add(listener);
		}
	}

	/**
	 * remove listener
	 * 
	 * @param listener
	 */
	public void removeListener(StreamListener listener) {
		synchronized (streamListeners) {
			this.streamListeners.remove(listener);
		}
	}
}