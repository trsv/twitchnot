package de.tobj.twitch.streamobserver.channel.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Preview {

	@JsonProperty("small")
	private String small;
	@JsonProperty("medium")
	private String medium;
	@JsonProperty("large")
	private String large;
	@JsonProperty("template")
	private String template;

	@JsonProperty("small")
	public String getSmall() {
		return small;
	}

	@JsonProperty("small")
	public void setSmall(String small) {
		this.small = small;
	}

	@JsonProperty("medium")
	public String getMedium() {
		return medium;
	}

	@JsonProperty("medium")
	public void setMedium(String medium) {
		this.medium = medium;
	}

	@JsonProperty("large")
	public String getLarge() {
		return large;
	}

	@JsonProperty("large")
	public void setLarge(String large) {
		this.large = large;
	}

	@JsonProperty("template")
	public String getTemplate() {
		return template;
	}

	@JsonProperty("template")
	public void setTemplate(String template) {
		this.template = template;
	}
}