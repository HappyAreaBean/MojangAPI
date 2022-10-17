package cc.happyareabean.mojangapi.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Profile {

	@SerializedName("code")
	@Expose
	private int code;
	@SerializedName("uuid")
	@Expose
	private String uuid;
	@SerializedName("username")
	@Expose
	private String username;
	@SerializedName("username_history")
	@Expose
	private List<UsernameHistory> usernameHistory = null;
	@SerializedName("textures")
	@Expose
	private Textures textures;
	@SerializedName("legacy")
	@Expose
	private Boolean legacy;
	@SerializedName("demo")
	@Expose
	private Boolean demo;
	@SerializedName("created_at")
	@Expose
	private String createdAt;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UsernameHistory> getUsernameHistory() {
		return usernameHistory;
	}

	public void setUsernameHistory(List<UsernameHistory> usernameHistory) {
		this.usernameHistory = usernameHistory;
	}

	public Textures getTextures() {
		return textures;
	}

	public void setTextures(Textures textures) {
		this.textures = textures;
	}

	public Boolean getLegacy() {
		return legacy;
	}

	public void setLegacy(Boolean legacy) {
		this.legacy = legacy;
	}

	public Boolean getDemo() {
		return demo;
	}

	public void setDemo(Boolean demo) {
		this.demo = demo;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Profile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("uuid");
		sb.append('=');
		sb.append(((this.uuid == null) ? "<null>" : this.uuid));
		sb.append(',');
		sb.append("username");
		sb.append('=');
		sb.append(((this.username == null) ? "<null>" : this.username));
		sb.append(',');
		sb.append("usernameHistory");
		sb.append('=');
		sb.append(((this.usernameHistory == null) ? "<null>" : this.usernameHistory));
		sb.append(',');
		sb.append("textures");
		sb.append('=');
		sb.append(((this.textures == null) ? "<null>" : this.textures));
		sb.append(',');
		sb.append("legacy");
		sb.append('=');
		sb.append(((this.legacy == null) ? "<null>" : this.legacy));
		sb.append(',');
		sb.append("demo");
		sb.append('=');
		sb.append(((this.demo == null) ? "<null>" : this.demo));
		sb.append(',');
		sb.append("createdAt");
		sb.append('=');
		sb.append(((this.createdAt == null) ? "<null>" : this.createdAt));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
