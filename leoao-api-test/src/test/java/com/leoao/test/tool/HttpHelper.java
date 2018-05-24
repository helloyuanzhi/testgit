package com.leoao.test.tool;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpHelper {
	public static void setCommonHeaders(HttpRequest httpMethod, boolean isPost) {
		httpMethod.addHeader("x-appkey", "201456888");
		httpMethod.addHeader("x-rtType", "json_orig_result");
		httpMethod.addHeader("x-debug", "true");
		httpMethod.addHeader("x-appv", "2.2.0.85");
		httpMethod.addHeader("x-pv", "2.0");
		httpMethod.addHeader("x-devid", "867068025328070");
		httpMethod.addHeader("x-location", "120.089076,30.289686");
		httpMethod.addHeader("User-Agent",
				"APISDK/1.1.0 (Android;5.0.2;phone;Xiaomi;MI NOTE Pro;xxhdpi;878882816,45484863488)");
		if (isPost) {
			httpMethod.addHeader("Content-Type", "application/json");
		}
		
		for (Header header : httpMethod.getAllHeaders()) {
			System.out.println(header.getName() + ":" + header.getValue());
		}
	}
	
	public static String sendPostRequest(CloseableHttpClient client, HttpPost httpPost, String Json)
			throws IOException, ClientProtocolException {
		System.out.println(Json);

		StringEntity entity = new StringEntity(Json, "utf-8");
		httpPost.setEntity(entity);

		HttpResponse httpResponse = client.execute(httpPost);
		System.out.println(httpResponse.getStatusLine());
		HttpEntity httpEntity = httpResponse.getEntity();
		String contentStr = EntityUtils.toString(httpEntity);

		String result = "[{\"status\":\"" + String.valueOf(httpResponse.getStatusLine().getStatusCode()) + "\"},"
				+ contentStr + "]";
		return result;
	}
	
	public static String sendGetRequest(CloseableHttpClient client, HttpGet httpGet)
			throws IOException, ClientProtocolException {
		HttpResponse httpResponse = client.execute(httpGet);
		System.out.println(httpResponse.getStatusLine());
		HttpEntity httpEntity = httpResponse.getEntity();
		String contentStr = EntityUtils.toString(httpEntity);

		String result = "[{\"status\":\"" + String.valueOf(httpResponse.getStatusLine().getStatusCode()) + "\"},"
				+ contentStr + "]";
		return result;
	}
}
