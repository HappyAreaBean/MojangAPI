package cc.happyareabean.mojangapi.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UsernameHistory {

	@SerializedName("username")
	@Expose
	private String username;
	@SerializedName("changed_at")
	@Expose
	private String changedAt;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getChangedAt() {
		return changedAt;
	}

	public void setChangedAt(String changedAt) {
		this.changedAt = changedAt;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(UsernameHistory.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("username");
		sb.append('=');
		sb.append(((this.username == null) ? "<null>" : this.username));
		sb.append(',');
		sb.append("changedAt");
		sb.append('=');
		sb.append(((this.changedAt == null) ? "<null>" : this.changedAt));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
