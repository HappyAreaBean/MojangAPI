package cc.happyareabean.mojangapi.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cape {

	@SerializedName("url")
	@Expose
	private String url;
	@SerializedName("data")
	@Expose
	private String data;

}
