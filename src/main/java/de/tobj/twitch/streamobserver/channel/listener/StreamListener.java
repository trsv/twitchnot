package de.tobj.twitch.streamobserver.channel.listener;

import de.tobj.twitch.streamobserver.channel.event.StreamStatusEvent;
import de.tobj.twitch.streamobserver.channel.event.StreamUpdateEvent;

/**
 * StreamListener
 */
public abstract class StreamListener {

	/**
	 * stream is online event
	 * 
	 * @param event
	 */
	public void streamIsOnline(StreamStatusEvent event) {

	}

	/**
	 * stream is offline event
	 * 
	 * @param event
	 */
	public void streamIsOffline(StreamStatusEvent event) {

	}

	/**
	 * stream update event
	 * 
	 * @param event
	 */
	public void streamUpdate(StreamUpdateEvent event) {

	}
}