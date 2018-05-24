package com.leoao.test.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException; 
import java.security.NoSuchAlgorithmException; 
import java.security.cert.CertificateException; 
import java.security.cert.X509Certificate; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext; 
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager; 
import javax.net.ssl.X509TrustManager; 



import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.NoHttpResponseException;
import org.apache.http.util.EntityUtils;


/**
 * Created by jinhua 
 */
@SuppressWarnings("deprecation")
public class HttpUtil {

	public static String get(String url) {

		@SuppressWarnings({ "resource" })
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String contents = null;
		int httpstatus = 0;
		 X509TrustManager xtm = new X509TrustManager(){   
	            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {} 
	            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {} 
	            public X509Certificate[] getAcceptedIssuers() { return null; } 
	        }; 

		
		
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(null, new TrustManager[]{xtm}, null);
			SSLSocketFactory socketFactory = new SSLSocketFactory(ctx,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER); 
			httpclient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory)); 
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (KeyManagementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
             
          
      

		HttpConnectionParams.setConnectionTimeout(httpclient.getParams(),
				60000);
		HttpConnectionParams.setSoTimeout(httpclient.getParams(), 60000);
		HttpProtocolParams.setContentCharset(httpclient.getParams(), "UTF-8");
		// httpclient.setHttpRequestRetryHandler(new
		// DefaultHttpRequestRetryHandler(3, true));
		

		httpclient.setHttpRequestRetryHandler(new HttpRequestRetryHandler() {
			public boolean retryRequest(final IOException exception,
					int executionCount, final HttpContext context) {
				if (executionCount >= 3) {
					return false;
				}
		
				if (exception instanceof NoHttpResponseException) {
					return true;
				}
			
				if (exception instanceof SSLHandshakeException) {
					return false;
				}
				HttpRequest request = (HttpRequest) context
						.getAttribute(ExecutionContext.HTTP_REQUEST);
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
			
				if (idempotent) {
					return true;
				}
				return false;
			}
		});

		try {
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			httpstatus = response.getStatusLine().getStatusCode();

			if (entity != null) {

				BufferedReader br = new BufferedReader(new InputStreamReader(
						entity.getContent(), "UTF-8"));
				StringBuilder sb = new StringBuilder();

				String line = null;
				try {
					while ((line = br.readLine()) != null) {
						sb.append(line + "\n");
					}
			//		sb.deleteCharAt(sb.length()-1);
				} catch (IOException e) {
					e.printStackTrace();
				}
				contents = sb.toString();
			}

			EntityUtils.consume(entity);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpclient.getConnectionManager().shutdown();
		}

		return "[{\"status\":\"" + String.valueOf(httpstatus) + "\"},"	+ contents + "]";
	}

	public static String post(String url, Map<String, String> params, File file) {
		@SuppressWarnings("resource")
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String contents = null;
		int httpstatus = 0;
		
		X509TrustManager xtm = new X509TrustManager(){   
	            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {} 
	            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {} 
	            public X509Certificate[] getAcceptedIssuers() { return null; } 
	    }; 

		
		
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(null, new TrustManager[]{xtm}, null);
			//@SuppressWarnings("deprecation")
			SSLSocketFactory socketFactory = new SSLSocketFactory(ctx,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER); 
			httpclient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory)); 
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (KeyManagementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	//	HttpHost proxy = new HttpHost("127.0.0.1", 8087);  
	//	httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

		HttpConnectionParams.setConnectionTimeout(httpclient.getParams(),
				60000);
		HttpConnectionParams.setSoTimeout(httpclient.getParams(), 60000);
		HttpProtocolParams.setContentCharset(httpclient.getParams(), "UTF-8");
		// httpclient.setHttpRequestRetryHandler(new
		// DefaultHttpRequestRetryHandler(3, true));

		httpclient.setHttpRequestRetryHandler(new HttpRequestRetryHandler() {
			public boolean retryRequest(final IOException exception,
					int executionCount, final HttpContext context) {
				if (executionCount >= 3) {
					return false;
				}
		
				if (exception instanceof NoHttpResponseException) {
					return true;
				}


				if (exception instanceof SSLHandshakeException) {
					return false;
				}
				HttpRequest request = (HttpRequest) context
						.getAttribute(ExecutionContext.HTTP_REQUEST);
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
	
				if (idempotent) {
					return true;
				}
				return false;
			}
		});

		try {
			HttpPost httpost = new HttpPost(url);

			MultipartEntity mpEntity = new MultipartEntity();

	
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			if (file != null && file.exists()) {
				ContentBody contentBody = new FileBody(file);
				mpEntity.addPart("dp_data", contentBody);

				if (params != null && params.keySet().size() > 0) {
					Iterator<?> iterator = params.entrySet().iterator();
					while (iterator.hasNext()) {
						@SuppressWarnings("rawtypes")
						Map.Entry entry = (Entry) iterator.next();
						StringBody stringBody = new StringBody(
								String.valueOf(entry.getValue()));
						mpEntity.addPart((String) entry.getKey(), stringBody);
					//	System.out.println(stringBody);
					}
					httpost.setEntity(mpEntity);
					

				}
			} else {
				if (params != null && params.keySet().size() > 0) {
					Iterator<?> iterator2 = params.entrySet().iterator();
					while (iterator2.hasNext()) {
						@SuppressWarnings("rawtypes")
						Map.Entry entry = (Entry) iterator2.next();
						nvps.add(new BasicNameValuePair(
								(String) entry.getKey(), (String) entry
										.getValue()));
					}
				}
				httpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
			}
			// httpclient.getParams().setParameter("http.socket.timeout", new Integer(30000)); 
			 
			 
			//System.out.println( "url="+httpost.getRequestLine());
			HttpResponse response = httpclient.execute(httpost);
			HttpEntity entity = response.getEntity();
			httpstatus = response.getStatusLine().getStatusCode();
			
			if (entity != null) {

				BufferedReader br = new BufferedReader(new InputStreamReader(
						entity.getContent(), "UTF-8"));
				StringBuilder sb = new StringBuilder();

				String line = null;
				try {
					while ((line = br.readLine()) != null) {
						sb.append(line + "\n");
					}
			//	sb.deleteCharAt(sb.length()-1);
				} catch (IOException e) {
					e.printStackTrace();
				}
				contents = sb.toString();
				
			}


			EntityUtils.consume(entity);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			httpclient.getConnectionManager().shutdown();
		}
		
		return "[{\"status\":\"" + String.valueOf(httpstatus) + "\"},"	+ contents + "]";
	}

	public static String post2(String url, Map<String, String> params, File file,String filename) {
		@SuppressWarnings({ "resource" })
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String contents = null;
		int httpstatus = 0;
		
		X509TrustManager xtm = new X509TrustManager(){   
	            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {} 
	            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {} 
	            public X509Certificate[] getAcceptedIssuers() { return null; } 
	    }; 

		
		
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(null, new TrustManager[]{xtm}, null);
			SSLSocketFactory socketFactory = new SSLSocketFactory(ctx,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER); 
			httpclient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory)); 
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (KeyManagementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	//	HttpHost proxy = new HttpHost("127.0.0.1", 8087);  
	//	httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

		HttpConnectionParams.setConnectionTimeout(httpclient.getParams(),
				60000);
		HttpConnectionParams.setSoTimeout(httpclient.getParams(), 60000);
		HttpProtocolParams.setContentCharset(httpclient.getParams(), "UTF-8");
		// httpclient.setHttpRequestRetryHandler(new
		// DefaultHttpRequestRetryHandler(3, true));

		httpclient.setHttpRequestRetryHandler(new HttpRequestRetryHandler() {
			public boolean retryRequest(final IOException exception,
					int executionCount, final HttpContext context) {
				if (executionCount >= 3) {
					return false;
				}
		
				if (exception instanceof NoHttpResponseException) {
					return true;
				}


				if (exception instanceof SSLHandshakeException) {
					return false;
				}
				HttpRequest request = (HttpRequest) context
						.getAttribute(ExecutionContext.HTTP_REQUEST);
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
	
				if (idempotent) {
					return true;
				}
				return false;
			}
		});
		
		
		try {
			HttpPost httpost = new HttpPost(url);
			//HttpGet get = new HttpGet(url);
			MultipartEntity mpEntity = new MultipartEntity();

	
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			if (file != null && file.exists()) {
				ContentBody contentBody = new FileBody(file);
				mpEntity.addPart("dp_data", contentBody);

				if (params != null && params.keySet().size() > 0) {
					Iterator<?> iterator = params.entrySet().iterator();
					while (iterator.hasNext()) {
						@SuppressWarnings("rawtypes")
						Map.Entry entry = (Entry) iterator.next();
						StringBody stringBody = new StringBody(
								String.valueOf(entry.getValue()));
						mpEntity.addPart((String) entry.getKey(), stringBody);
					//	System.out.println(stringBody);
					}
					httpost.setEntity(mpEntity);
				

				}
			} else {
				if (params != null && params.keySet().size() > 0) {
					Iterator<?> iterator2 = params.entrySet().iterator();
					while (iterator2.hasNext()) {
						@SuppressWarnings("rawtypes")
						Map.Entry entry = (Entry) iterator2.next();
						nvps.add(new BasicNameValuePair(
								(String) entry.getKey(), (String) entry
										.getValue()));
					}
				}
				
				httpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
			}
			// httpclient.getParams().setParameter("http.socket.timeout", new Integer(30000)); 
			
			 
			//System.out.println( "url="+httpost.getRequestLine());
			HttpResponse response = httpclient.execute(httpost);
			HttpEntity entity = response.getEntity();
			httpstatus = response.getStatusLine().getStatusCode();

			if (entity != null) {

				BufferedReader br = new BufferedReader(new InputStreamReader(
						entity.getContent(), "UTF-8"));
				StringBuilder sb = new StringBuilder();

				String line = null;
				try {
					while ((line = br.readLine()) != null) {
						sb.append(line + "\n");
						
					}
			//		sb.deleteCharAt(sb.length()-1);
				} catch (IOException e) {
					e.printStackTrace();
				}
				contents = sb.toString();
				
			}


			EntityUtils.consume(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			httpclient.getConnectionManager().shutdown();
		}
		
		return "[{\"status\":\"" + String.valueOf(httpstatus) + "\"},"	+ contents + "]";
	}
	
	
	public static String post3(String url, Map<String, String> params, File file) {
		@SuppressWarnings({ "resource" })
		DefaultHttpClient httpclient = new DefaultHttpClient();
		String contents = null;
		int httpstatus = 0;
		
		X509TrustManager xtm = new X509TrustManager(){   
	            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {} 
	            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {} 
	            public X509Certificate[] getAcceptedIssuers() { return null; } 
	    }; 

		
		
		try {
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(null, new TrustManager[]{xtm}, null);
			SSLSocketFactory socketFactory = new SSLSocketFactory(ctx,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER); 
			httpclient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory)); 
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (KeyManagementException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	//	HttpHost proxy = new HttpHost("127.0.0.1", 8087);  
	//	httpclient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

		HttpConnectionParams.setConnectionTimeout(httpclient.getParams(),
				60000);
		HttpConnectionParams.setSoTimeout(httpclient.getParams(), 60000);
		HttpProtocolParams.setContentCharset(httpclient.getParams(), "UTF-8");
		// httpclient.setHttpRequestRetryHandler(new
		// DefaultHttpRequestRetryHandler(3, true));

		httpclient.setHttpRequestRetryHandler(new HttpRequestRetryHandler() {
			public boolean retryRequest(final IOException exception,
					int executionCount, final HttpContext context) {
				if (executionCount >= 3) {
					return false;
				}
		
				if (exception instanceof NoHttpResponseException) {
					return true;
				}


				if (exception instanceof SSLHandshakeException) {
					return false;
				}
				HttpRequest request = (HttpRequest) context
						.getAttribute(ExecutionContext.HTTP_REQUEST);
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
	
				if (idempotent) {
					return true;
				}
				return false;
			}
		});

		try {
			HttpPost httpost = new HttpPost(url);

			MultipartEntity mpEntity = new MultipartEntity();

	
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			if (file != null && file.exists()) {
				ContentBody contentBody = new FileBody(file);
				mpEntity.addPart("bin", contentBody);

				if (params != null && params.keySet().size() > 0) {
					Iterator<?> iterator = params.entrySet().iterator();
					while (iterator.hasNext()) {
						@SuppressWarnings("rawtypes")
						Map.Entry entry = (Entry) iterator.next();
						StringBody stringBody = new StringBody(
								String.valueOf(entry.getValue()));
						mpEntity.addPart((String) entry.getKey(), stringBody);
					//	System.out.println(stringBody);
					}
					httpost.setEntity(mpEntity);
					

				}
			} else {
				if (params != null && params.keySet().size() > 0) {
					Iterator<?> iterator2 = params.entrySet().iterator();
					while (iterator2.hasNext()) {
						@SuppressWarnings("rawtypes")
						Map.Entry entry = (Entry) iterator2.next();
						nvps.add(new BasicNameValuePair(
								(String) entry.getKey(), (String) entry
										.getValue()));
					}
				}
				httpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));
			}
		// httpclient.getParams().setParameter("http.socket.timeout", new Integer(300000)); 
			 
			 
		//	System.out.println( "url="+httpost.getRequestLine());
			HttpResponse response = httpclient.execute(httpost);
			HttpEntity entity = response.getEntity();
			httpstatus = response.getStatusLine().getStatusCode();

			if (entity != null) {

				BufferedReader br = new BufferedReader(new InputStreamReader(
						entity.getContent(), "UTF-8"));
				StringBuilder sb = new StringBuilder();

				String line = null;
				try {
					while ((line = br.readLine()) != null) {
						sb.append(line + "\n");
					}
				//	sb.deleteCharAt(sb.length()-1);
				} catch (IOException e) {
					e.printStackTrace();
				}
				contents = sb.toString();
			}


			EntityUtils.consume(entity);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			httpclient.getConnectionManager().shutdown();
		}

		return "[{\"status\":\"" + String.valueOf(httpstatus) + "\"},"	+ contents + "]";
	}
	
	
	

	
	
	
	
	
	
	
	
	
	public static String getFile(String url, String filepath) {
		@SuppressWarnings("unused")
		String srt2=null;
		@SuppressWarnings({ "resource" })
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		 @SuppressWarnings("unused")
		int rebk = 0 ;
		try {
			ResponseHandler<byte[]> handler = new ResponseHandler<byte[]>() {
				public byte[] handleResponse(HttpResponse response)
				
						throws ClientProtocolException, IOException {
					HttpEntity entity = response.getEntity();
					
					if (entity != null) {
						return EntityUtils.toByteArray(entity);
					} else {
						return null;
					}
				}
			};
			//response.getStatusLine().getStatusCode();
			
			byte[] charts = httpClient.execute(get, handler);
			
			FileOutputStream out = new FileOutputStream(filepath);
			out.write(charts);
			out.close();

			srt2=new String(charts,"UTF-8");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return "[{\"status\":\"" +"200"+ "\"}]";
	}
	
	
	public static String getFile1(String url, String filepath) {
		String srt2=null;
		@SuppressWarnings({ "resource" })
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		@SuppressWarnings("unused")
		final int status = 0;
		try {
			ResponseHandler<byte[]> handler = new ResponseHandler<byte[]>() {
				public byte[] handleResponse(HttpResponse response)
				
						throws ClientProtocolException, IOException {
					HttpEntity entity = response.getEntity();
				//	status = response.getStatusLine().getStatusCode();
					if (entity != null) {
						return EntityUtils.toByteArray(entity);
					} else {
						return null;
					}
				}
			};

			byte[] charts = httpClient.execute(get, handler);
			FileOutputStream out = new FileOutputStream(filepath);
			out.write(charts);
			out.close();
			srt2=new String(charts,"UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return "[{\"status\":\"" + "400" + "\"}"+srt2+"]";
	}

	public static String createURL(String destination,
			Map<String, String> params) {

		StringBuilder request = new StringBuilder();
		Iterator<String> it = params.keySet().iterator();
		while (it.hasNext()) {
			Object value;
			String key = it.next();

			if (params.get(key) == null)
				value = "";
			else
				value = params.get(key);
			request.append(key + "=" + value + "&");

		}
		return destination
				+ request.substring(0, request.length() - 1).toString();
		
		
	}
	
		
		
		public static long getContentLength(String url) {
			@SuppressWarnings({ "resource" })
			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpGet get = new HttpGet(url);
			long result= 0;
			try {
				@SuppressWarnings("unused")
				ResponseHandler<byte[]> handler = new ResponseHandler<byte[]>() {
					public byte[] handleResponse(HttpResponse response)
							throws ClientProtocolException, IOException {
						HttpEntity entity = response.getEntity();
						if (entity != null) {
							return EntityUtils.toByteArray(entity);
						} else {
							return null;
						}
					}
				};

				HttpResponse response = httpclient.execute(get);
				HttpEntity entity = response.getEntity();
				result = entity.getContentLength();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				httpclient.getConnectionManager().shutdown();
			}
			return result;

		}

		

	public static void main(String[] args) {

		 long result =
		 getContentLength("http://s1.hao123img.com/index/images/newlogo-186X68.png");
		 System.out.println(result);
/*
		String url = "http://172.17.208.59/core/v1/auth/login";
		Map<String, String> params = new HashMap<String, String>();
		params.put("email", "test001@yeah.net");
		params.put("password", "654321");
		params.put("client_id", "arcsoftcloud");
		params.put("device_name", "bravo");
		params.put("device_id", "1");
		params.put("sig", "fed6b4dcfe99d0e21b1f82f5fe8a6104");

		System.out.println(createURL(url, params));
		String result2 = post(url, params, null);
		System.out.println(result2);
		
*/

	}

}