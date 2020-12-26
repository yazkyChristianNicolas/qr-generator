package ar.com.yazkychristian.qrgenerator.controllers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.yazkychristian.qrgenerator.api.StringEncodeRequest;
import ar.com.yazkychristian.qrgenerator.api.VCardEncodeRequest;
import ar.com.yazkychristian.qrgenerator.api.WifiEncodeRequest;
import ar.com.yazkychristian.qrgenerator.api.QrCodeResponse;
import net.glxn.qrgen.core.scheme.Url;
import net.glxn.qrgen.core.scheme.VCard;
import net.glxn.qrgen.core.scheme.Wifi;
import net.glxn.qrgen.javase.QRCode;
import java.util.Base64;

@RestController
@RequestMapping("/qr")
public class QRController {


	@PostMapping("/string")
	public ResponseEntity<QrCodeResponse> createFromString(@RequestBody StringEncodeRequest request) throws IOException{
		System.out.println(request.toString());
		File code = null;
		code = QRCode.from(request.getData()).withSize(request.getSize(), request.getSize()).withColor(request.getForegroundColor(), request.getBackgroundColor()).withCharset("UTF-8").file();
		return ResponseEntity.ok(new QrCodeResponse(encodeQrImage(code)));
	}
	
	
	@PostMapping("/vcard")
	public ResponseEntity<QrCodeResponse> createFromVCard(@RequestBody VCardEncodeRequest request) throws IOException{
		VCard vcard = new VCard();
		vcard.setName(request.getName());
		vcard.setEmail(request.getEmail());
		vcard.setPhoneNumber(request.getPhoneNumber());
		vcard.setAddress(request.getAddress());
		vcard.setCompany(request.getCompany());
		vcard.setTitle(request.getTitle());
		vcard.setWebsite(request.getWebsite());
		vcard.setNote(request.getNote());
		
		File code = QRCode.from(vcard).withSize(request.getSize(), request.getSize()).withColor(request.getForegroundColor(), request.getBackgroundColor()).withCharset("UTF-8").file();
		return ResponseEntity.ok(new QrCodeResponse(encodeQrImage(code)));
	}
	
	
	@PostMapping("/wifi")
	public ResponseEntity<QrCodeResponse> createWifiCode(@RequestBody WifiEncodeRequest request) throws IOException{
		Wifi wifi = new Wifi();
		wifi.setSsid(request.getSsid());
		wifi.setPsk(request.getPassword());
		wifi.setHidden(request.isHidden());
		wifi.setAuthentication(request.getEncryption());
		File code = QRCode.from(wifi).withSize(request.getSize(), request.getSize()).withColor(request.getForegroundColor(), request.getBackgroundColor()).withCharset("UTF-8").file();
		return ResponseEntity.ok(new QrCodeResponse(encodeQrImage(code)));
	}
	
	private String encodeQrImage(File code) throws IOException{
		byte[] fileContent = FileUtils.readFileToByteArray(code);
		return Base64.getEncoder().encodeToString(fileContent);
	}
	
}
