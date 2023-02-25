package cc.happyareabean.mojangapi.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;


@Getter
@Setter
@ToString
public class Profile {

	@SerializedName("code")
	@Expose
	private int code;
	@SerializedName("uuid")
	@Expose
	private UUID uniqueId;
	@SerializedName("username")
	@Expose
	private String username;
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

}
