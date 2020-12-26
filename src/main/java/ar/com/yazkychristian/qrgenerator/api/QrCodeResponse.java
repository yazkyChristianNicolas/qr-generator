package ar.com.yazkychristian.qrgenerator.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QrCodeResponse {
	@JsonProperty("encodeData")
	private String encodeData;
}
