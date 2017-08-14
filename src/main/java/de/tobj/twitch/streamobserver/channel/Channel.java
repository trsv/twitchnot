package de.tobj.twitch.streamobserver.channel;

import java.util.Date;

/**
 * Channel
 */
public class Channel {

	private boolean isOnline = false;
	private String channel;
	private Date lastStatusChange;

	/**
	 * Constructor
	 * 
	 * @param channel
	 */
	public Channel(String channel) {
		super();
		this.channel = channel;
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
	 * set stream online status
	 * 
	 * @param isOnline
	 */
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}

	/**
	 * get channel name
	 * 
	 * @return
	 */
	public String getChannelName() {
		return channel;
	}

	/**
	 * set last status change date
	 * 
	 * @param lastStatusChange
	 */
	public void setLastStatusChange(Date lastStatusChange) {
		this.lastStatusChange = lastStatusChange;
	}

	/**
	 * get last status change date
	 * 
	 * @return
	 */
	public Date getLastStatusChange() {
		return lastStatusChange;
	}
}