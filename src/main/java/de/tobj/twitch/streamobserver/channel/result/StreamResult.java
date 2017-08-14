package de.tobj.twitch.streamobserver.channel.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import de.tobj.http.simplerequest.Result;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "_links" })
public class StreamResult extends Result {

	@JsonProperty("stream")
	private Stream stream;

	@JsonProperty("stream")
	public Stream getStreamData() {
		return stream;
	}

	public boolean isOnline() {
		return getStreamData() != null;
	}

	@Override
	public String toString() {
		return "StreamResult [isOnline()=" + isOnline() + ", stream=" + stream + "]";
	}
}