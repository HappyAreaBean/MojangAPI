package cc.happyareabean.mojangapi.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Textures {

	@SerializedName("slim")
	@Expose
	private Boolean slim;
	@SerializedName("custom")
	@Expose
	private Boolean custom;
	@SerializedName("skin")
	@Expose
	private Skin skin;
	@SerializedName("cape")
	@Expose
	private Cape cape;
	@SerializedName("raw")
	@Expose
	private Raw raw;

	public Boolean getSlim() {
		return slim;
	}

	public void setSlim(Boolean slim) {
		this.slim = slim;
	}

	public Boolean getCustom() {
		return custom;
	}

	public void setCustom(Boolean custom) {
		this.custom = custom;
	}

	public Skin getSkin() {
		return skin;
	}

	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	public Cape getCape() {
		return cape;
	}

	public void setCape(Cape cape) {
		this.cape = cape;
	}

	public Raw getRaw() {
		return raw;
	}

	public void setRaw(Raw raw) {
		this.raw = raw;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Textures.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("slim");
		sb.append('=');
		sb.append(((this.slim == null) ? "<null>" : this.slim));
		sb.append(',');
		sb.append("custom");
		sb.append('=');
		sb.append(((this.custom == null) ? "<null>" : this.custom));
		sb.append(',');
		sb.append("skin");
		sb.append('=');
		sb.append(((this.skin == null) ? "<null>" : this.skin));
		sb.append(',');
		sb.append("cape");
		sb.append('=');
		sb.append(((this.cape == null) ? "<null>" : this.cape));
		sb.append(',');
		sb.append("raw");
		sb.append('=');
		sb.append(((this.raw == null) ? "<null>" : this.raw));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
