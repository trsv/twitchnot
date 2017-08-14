package de.tobj.twitch.streamobserver.channel.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "_links", "is_playlist" })
public class Stream {
	@JsonProperty("game")
	private String game;
	@JsonProperty("viewers")
	private Long viewers;
	@JsonProperty("average_fps")
	private Double averageFps;
	@JsonProperty("video_height")
	private Integer videoHeight;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("_id")
	private Long id;
	@JsonProperty("channel")
	private Channel channel;
	@JsonProperty("preview")
	private Preview preview;
	@JsonProperty("delay")
	private int delay;
    @JsonProperty("stream_type")
    private String streamType;

	@JsonProperty("game")
	public String getGame() {
		return game;
	}

	@JsonProperty("game")
	public void setGame(String game) {
		this.game = game;
	}

	@JsonProperty("viewers")
	public Long getViewers() {
		return viewers;
	}

	@JsonProperty("viewers")
	public void setViewers(Long viewers) {
		this.viewers = viewers;
	}

	@JsonProperty("average_fps")
	public Double getAverageFps() {
		return averageFps;
	}

	@JsonProperty("average_fps")
	public void setAverageFps(Double averageFps) {
		this.averageFps = averageFps;
	}

	@JsonProperty("video_height")
	public Integer getVideoHeight() {
		return videoHeight;
	}

	@JsonProperty("video_height")
	public void setVideoHeight(Integer videoHeight) {
		this.videoHeight = videoHeight;
	}

	@JsonProperty("created_at")
	public String getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@JsonProperty("_id")
	public Long getId() {
		return id;
	}

	@JsonProperty("_id")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("channel")
	public Channel getChannel() {
		return channel;
	}

	@JsonProperty("channel")
	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@JsonProperty("preview")
	public Preview getPreview() {
		return preview;
	}

	@JsonProperty("preview")
	public void setPreview(Preview preview) {
		this.preview = preview;
	}

	@JsonProperty("delay")
	public int getDelay() { return delay; }

	@JsonProperty("delay")
	public void setDelay(int delay) { this.delay = delay; }

    @JsonProperty("stream_type")
    public String getStreamType() { return streamType; }

    @JsonProperty("stream_type")
    public void setStreamType(String streamType) { this.streamType = streamType; }
}