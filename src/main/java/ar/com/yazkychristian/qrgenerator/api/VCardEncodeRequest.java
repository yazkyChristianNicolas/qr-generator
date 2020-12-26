package ar.com.yazkychristian.qrgenerator.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
@NoArgsConstructor()
@EqualsAndHashCode(callSuper=false)
public class VCardEncodeRequest extends BaseQrRequest {
	private String name;
	private String company;
	private String title;
	private String phoneNumber;
	private String email;
	private String address;
	private String website;
	private String note;
}
