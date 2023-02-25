package cc.happyareabean.mojangapi.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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

}
