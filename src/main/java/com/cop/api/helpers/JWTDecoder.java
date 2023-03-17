package com.cop.api.helpers;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JWTDecoder {

	public static Map<Object,String> decodeJwt(String token) {
		String[] chunks = token.split("\\.");
		HashMap <Object,String> h=new HashMap<>();
		Base64.Decoder decoder = Base64.getUrlDecoder();
		String header = new String(decoder.decode(chunks[0]));
		String payload = new String(decoder.decode(chunks[1]));
		h.put("header",header);
		h.put("payload",payload);
		
		return h;
	}
}
