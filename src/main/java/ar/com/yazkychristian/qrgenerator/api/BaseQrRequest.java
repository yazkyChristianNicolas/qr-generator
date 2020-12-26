package ar.com.yazkychristian.qrgenerator.api;

import java.awt.Color;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
@NoArgsConstructor
public class BaseQrRequest {
		
	@JsonProperty("size")
	private Integer size = 250;
	
	@JsonProperty("foregroundColor")
	private Integer foregroundColor = Color.black.getRGB();
	
	@JsonProperty("backgroundColor")
	private Integer backgroundColor  = Color.white.getRGB();
	
}
