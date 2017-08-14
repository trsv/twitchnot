package de.tobj.twitch.streamobserver.channel;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.tobj.twitch.streamobserver.channel.event.StreamUpdateEvent;
import de.tobj.twitch.streamobserver.channel.listener.StreamListener;

/**
 * Notify all listeners about a stream update
 */
public class NotifyStreamUpdateRunner extends Thread {
	private static final Logger logger = LogManager.getLogger(NotifyStreamUpdateRunner.class);
	private List<StreamListener> streamListeners;
	private StreamUpdateEvent event;

	/**
	 * Constructor
	 * 
	 * @param streamListeners
	 * @param event
	 */
	public NotifyStreamUpdateRunner(List<StreamListener> streamListeners, StreamUpdateEvent event) {
		this.streamListeners = streamListeners;
		this.event = event;
	}

	/**
	 * start notify all listeners
	 */
	@Override
	public void run() {
		logger.debug("notify listener about stream update...");
		for (final StreamListener listener : streamListeners) {
			try {
				(new Runnable() {
					@Override
					public void run() {
						listener.streamUpdate(event);
					}
				}).run();
			} catch (Exception e) {
				logger.info("exception at notify listener about stream update", e);
			}
		}
		logger.debug("notify listener about stream update... done!");
	}
}