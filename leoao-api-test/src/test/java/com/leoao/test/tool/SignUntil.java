package com.leoao.test.tool;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;



public class SignUntil {

	public  String sign(String apiName, String httpBody, String secretKey)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {

		// originStr example:
		// /mishi.configCenter.lunch.get/1.0&p-appkey=201456888&p-appv=0.5.0.8&p-pv=2.0

		Map<String, String> protocolParameters = new HashMap<String, String>();
		protocolParameters.put("p-appkey", "201456888");
		protocolParameters.put("p-appv", "0.5.0.8");
		protocolParameters.put("p-pv", "2.0");
       
		return SignUntil.sign(apiName, "1.0", protocolParameters, httpBody, secretKey);
	}

	public static String sign(String apiName, String apiVersion, Map<String, String> protocolParameters, String httpBody,
			String secret) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
		TreeMap<String, String> tmap = new TreeMap<String, String>();
		tmap.putAll(protocolParameters);

		StringBuilder originStr = new StringBuilder(128);
		originStr.append("/" + apiName + "/" + apiVersion);

		for (Map.Entry<String, String> e : tmap.entrySet()) {
			originStr.append("&");
			originStr.append(e.getKey());
			originStr.append("=");
			originStr.append(e.getValue());
		}

		if (httpBody != null && !httpBody.isEmpty()) {
			originStr.append("&" + httpBody);
		}

		Mac mac = Mac.getInstance("HmacSHA1");
		SecretKey secretKey = new SecretKeySpec(secret.getBytes("utf-8"), "HmacSHA1");
		mac.init(secretKey);
		char[] outputChars = Hex.encodeHex(mac.doFinal(originStr.toString().getBytes("utf-8")));

		StringBuilder newSB = new StringBuilder(128);
		for (char outputChar : outputChars) {
			newSB.append(outputChar);
		}

		return newSB.toString().toUpperCase();
		
		
		
	}
	
	public static String sign1(String httpstr) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
	
		//System.out.println(httpstr);
		
		
		try{
		 MessageDigest sha1;
		 sha1 = MessageDigest.getInstance("SHA1");
		 sha1.update(httpstr.getBytes("UTF-8"));
		 byte messageDigest[] = sha1.digest();
		 StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
		
		
		return hexString.toString().toLowerCase();
		
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	return "";
		
	}
	
	
}
