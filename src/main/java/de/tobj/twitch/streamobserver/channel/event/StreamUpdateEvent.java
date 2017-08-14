package de.tobj.twitch.streamobserver.channel.event;

import de.tobj.twitch.streamobserver.channel.result.Stream;

/**
 * Stream Update Event
 */
public class StreamUpdateEvent {

	private String channelName;
	private Stream streamData;

	/**
	 * Constructor
	 * 
	 * @param channelName
	 * @param streamData
	 */
	public StreamUpdateEvent(String channelName, Stream streamData) {
		this.channelName = channelName;
		this.streamData = streamData;
	}

	/**
	 * get channel name
	 * 
	 * @return
	 */
	public String getChannelName() {
		return channelName;
	}

	/**
	 * get stream data
	 * 
	 * @return
	 */
	public Stream getStreamData() {
		return streamData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StreamUpdateEvent [channelName=" + channelName + ", streamData=" + streamData + "]";
	}
}