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
public class StringEncodeRequest extends BaseQrRequest {
	
		@JsonProperty("data")
		private String data;
		
		@JsonProperty("url")
		private boolean url;
}
