package de.tobj.twitch.streamobserver.channel.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = { "_links" })
public class Channel {
	@JsonProperty("mature")
	private Boolean mature;
	@JsonProperty("status")
	private String status;
	@JsonProperty("broadcaster_language")
	private String broadcasterLanguage;
	@JsonProperty("display_name")
	private String displayName;
	@JsonProperty("game")
	private String game;
	@JsonProperty("delay")
	private Long delay;
	@JsonProperty("language")
	private String language;
	@JsonProperty("_id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("logo")
	private String logo;
	@JsonProperty("banner")
	private String banner;
	@JsonProperty("video_banner")
	private String videoBanner;
	@JsonProperty("background")
	private Object background;
	@JsonProperty("profile_banner")
	private String profileBanner;
	@JsonProperty("profile_banner_background_color")
	private String profileBannerBackgroundColor;
	@JsonProperty("partner")
	private Boolean partner;
	@JsonProperty("url")
	private String url;
	@JsonProperty("views")
	private Long views;
	@JsonProperty("followers")
	private Long followers;
	@JsonProperty("bio")
	private String bio;
	@JsonProperty("type")
	private String type;

	@JsonProperty("mature")
	public Boolean getMature() {
		return mature;
	}

	@JsonProperty("mature")
	public void setMature(Boolean mature) {
		this.mature = mature;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	@JsonProperty("broadcaster_language")
	public String getBroadcasterLanguage() {
		return broadcasterLanguage;
	}

	@JsonProperty("broadcaster_language")
	public void setBroadcasterLanguage(String broadcasterLanguage) {
		this.broadcasterLanguage = broadcasterLanguage;
	}

	@JsonProperty("display_name")
	public String getDisplayName() {
		return displayName;
	}

	@JsonProperty("display_name")
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@JsonProperty("game")
	public String getGame() {
		return game;
	}

	@JsonProperty("game")
	public void setGame(String game) {
		this.game = game;
	}

	@JsonProperty("delay")
	public Long getDelay() {
		return delay;
	}

	@JsonProperty("delay")
	public void setDelay(Long delay) {
		this.delay = delay;
	}

	@JsonProperty("language")
	public String getLanguage() {
		return language;
	}

	@JsonProperty("language")
	public void setLanguage(String language) {
		this.language = language;
	}

	@JsonProperty("_id")
	public Long getId() {
		return id;
	}

	@JsonProperty("_id")
	public void setId(Long id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("created_at")
	public String getCreatedAt() {
		return createdAt;
	}

	@JsonProperty("created_at")
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@JsonProperty("updated_at")
	public String getUpdatedAt() {
		return updatedAt;
	}

	@JsonProperty("updated_at")
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@JsonProperty("logo")
	public String getLogo() {
		return logo;
	}

	@JsonProperty("logo")
	public void setLogo(String logo) {
		this.logo = logo;
	}

	@JsonProperty("banner")
	public String getBanner() {
		return banner;
	}

	@JsonProperty("banner")
	public void setBanner(String banner) {
		this.banner = banner;
	}

	@JsonProperty("video_banner")
	public String getVideoBanner() {
		return videoBanner;
	}

	@JsonProperty("video_banner")
	public void setVideoBanner(String videoBanner) {
		this.videoBanner = videoBanner;
	}

	@JsonProperty("background")
	public Object getBackground() {
		return background;
	}

	@JsonProperty("background")
	public void setBackground(Object background) {
		this.background = background;
	}

	@JsonProperty("profile_banner")
	public String getProfileBanner() {
		return profileBanner;
	}

	@JsonProperty("profile_banner")
	public void setProfileBanner(String profileBanner) {
		this.profileBanner = profileBanner;
	}

	@JsonProperty("profile_banner_background_color")
	public String getProfileBannerBackgroundColor() {
		return profileBannerBackgroundColor;
	}

	@JsonProperty("profile_banner_background_color")
	public void setProfileBannerBackgroundColor(String profileBannerBackgroundColor) {
		this.profileBannerBackgroundColor = profileBannerBackgroundColor;
	}

	@JsonProperty("partner")
	public Boolean getPartner() {
		return partner;
	}

	@JsonProperty("partner")
	public void setPartner(Boolean partner) {
		this.partner = partner;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("views")
	public Long getViews() {
		return views;
	}

	@JsonProperty("views")
	public void setViews(Long views) {
		this.views = views;
	}

	@JsonProperty("followers")
	public Long getFollowers() {
		return followers;
	}

	@JsonProperty("followers")
	public void setFollowers(Long followers) {
		this.followers = followers;
	}

	@JsonProperty("bio")
	public String getBio() {
		return bio;
	}

	@JsonProperty("bio")
	public void setBio(String bio) {
		this.bio = bio;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}
}