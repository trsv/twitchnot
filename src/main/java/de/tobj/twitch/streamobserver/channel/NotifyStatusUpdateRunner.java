package de.tobj.twitch.streamobserver.channel;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.tobj.twitch.streamobserver.channel.event.StreamStatusEvent;
import de.tobj.twitch.streamobserver.channel.listener.StreamListener;

/**
 * notify all listeners about a status update
 */
public class NotifyStatusUpdateRunner extends Thread {
	private static final Logger logger = LogManager.getLogger(NotifyStatusUpdateRunner.class);
	private List<StreamListener> streamListeners;
	private StreamStatusEvent event;

	/**
	 * Constructor
	 * 
	 * @param streamListeners
	 * @param event
	 */
	public NotifyStatusUpdateRunner(List<StreamListener> streamListeners, StreamStatusEvent event) {
		this.streamListeners = streamListeners;
		this.event = event;
	}

	/**
	 * start notify all listeners
	 */
	@Override
	public void run() {
		logger.debug("notify listener about status update...");
		for (final StreamListener listener : streamListeners) {
			try {
				(new Runnable() {
					@Override
					public void run() {
						if (event.isOnline())
							listener.streamIsOnline(event);
						else
							listener.streamIsOffline(event);
					}
				}).run();
			} catch (Exception e) {
				logger.info("exception at notify listener about status update", e);
			}
		}
		logger.debug("notify listener about status update... done!");
	}
}