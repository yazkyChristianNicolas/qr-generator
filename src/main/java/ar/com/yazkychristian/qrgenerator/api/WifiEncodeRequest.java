package ar.com.yazkychristian.qrgenerator.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
@NoArgsConstructor()
@EqualsAndHashCode(callSuper=false)
public class WifiEncodeRequest extends BaseQrRequest{
	
	@JsonProperty("ssid")
	private String ssid;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("encryption")
	private String encryption;
	
	@JsonProperty("hidden")
	private boolean hidden;
	
}
