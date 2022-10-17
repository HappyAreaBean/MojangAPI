package cc.happyareabean.mojangapi.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Cape {

	@SerializedName("url")
	@Expose
	private String url;
	@SerializedName("data")
	@Expose
	private String data;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Cape.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("url");
		sb.append('=');
		sb.append(((this.url == null) ? "<null>" : this.url));
		sb.append(',');
		sb.append("data");
		sb.append('=');
		sb.append(((this.data == null) ? "<null>" : this.data));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

}
