package cc.happyareabean.mojangapi.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Raw {

	@SerializedName("value")
	@Expose
	private String value;
	@SerializedName("signature")
	@Expose
	private String signature;

}
