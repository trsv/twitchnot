package de.tobj.twitch.streamobserver.channel.event;

import java.util.Date;

import de.tobj.twitch.streamobserver.channel.result.Stream;

/**
 * Stream Status Event
 */
public class StreamStatusEvent {

	private String channelName;
	private Stream streamData;
	private boolean isOnline;
	private Date lastStatusChange;
	private Date currentStatusChangeDate;

	/**
	 * Constructor
	 * 
	 * @param channelName
	 * @param streamData
	 * @param isOnline
	 * @param lastStatusChange
	 * @param currentStatusChangeDate
	 */
	public StreamStatusEvent(String channelName, Stream streamData, boolean isOnline, Date lastStatusChange,
			Date currentStatusChangeDate) {
		this.channelName = channelName;
		this.streamData = streamData;
		this.isOnline = isOnline;
		this.lastStatusChange = lastStatusChange;
		this.currentStatusChangeDate = currentStatusChangeDate;
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
	 * get stream data (response from twitch)
	 * 
	 * @return
	 */
	public Stream getStreamData() {
		return streamData;
	}

	/**
	 * is stream online?
	 * 
	 * @return
	 */
	public boolean isOnline() {
		return isOnline;
	}

	/**
	 * get current status change date
	 * 
	 * @return
	 */
	public Date getCurrentStatusChangeDate() {
		return currentStatusChangeDate;
	}

	/**
	 * get last status change date
	 * 
	 * @return
	 */
	public Date getLastStatusChange() {
		return lastStatusChange;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StreamStatusEvent [channelName=" + channelName + ", isOnline=" + isOnline + ", streamData="
				+ streamData + ", lastStatusChange=" + lastStatusChange + ", currentStatusChangeDate="
				+ currentStatusChangeDate + "]";
	}
}