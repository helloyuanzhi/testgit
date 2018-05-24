package com.leoao.test.field;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.leoao.test.common.ConfigModel;
import com.leoao.test.common.TestBase;
import com.leoao.test.tool.SignUntil;
import com.leoao.test.tool.SystemLogger;
/**
 * 
 * @author jinhua        2017-6-19
 *
 */
public class bissness_city_operate extends TestBase{
	SystemLogger log = SystemLogger.getLogger(bissness_city_operate.class);
	static String AccountKey ="1103";
	static String secretKey ="9f8a6125c04aec7ae781d22894d3b745";
	static String random = "cs123456";

@Test(description = "T1,创建经营场所下的场地基本信息", priority = 0)
public  static String  remove_city(CloseableHttpClient client,String utcTimestamp,String  city_id) throws Exception
	    //无
	{
		 String url = ConfigModel.devhost;
		 JSONObject params = new JSONObject();

		 params.put("package", "public_platform.ground_sys.open_city");
		 params.put("class", "REMOVE_CITY");
		 params.put("city_id",city_id);
		 
		 HttpPost httpPost = new HttpPost(url);
		 httpPost.addHeader("content-type", "application/json");
		 httpPost.addHeader("Account-Key", AccountKey);
		 httpPost.addHeader("Random", random);
		 httpPost.addHeader("UTC-Timestamp", utcTimestamp);
		 httpPost.addHeader("User-Agent", "APISDK/1.1.0 (Android;4.4.4;phone;YuLong;Coolpad Y80D;hdpi;214413312,2157502464)");
		 //System.out.println(url);	

		 String body =params.toString();	
		 String str =body+utcTimestamp+random+ secretKey;
		 System.out.println(str);
		 String str1 =SignUntil.sign1( str);
		 httpPost.addHeader("Signature", str1);	
		 StringEntity entity = new StringEntity(body,"utf-8");
		 httpPost.setEntity(entity);	 
		 HttpResponse httpResponse = client.execute(httpPost);
		 HttpEntity httpEntity = httpResponse.getEntity();
		 String contentStr = EntityUtils.toString(httpEntity);

		String result ="[{\"status\":\"" + String.valueOf(httpResponse.getStatusLine().getStatusCode()) + "\"},"	+ contentStr + "]";
		return result;
		
	}

@Test(description = "T1,新增一个业务开放城市", priority = 0)
public  static String  create_open_city(CloseableHttpClient client,String utcTimestamp,String  city_id) throws Exception
	    //不能创建重复的城市
	{
		String url = ConfigModel.devhost;
		 JSONObject params = new JSONObject();

		 params.put("package", "public_platform.ground_sys.open_city");
		 params.put("class", "CREATE_OPEN_CITY");
		 params.put("city_id",city_id);
		 
		 HttpPost httpPost = new HttpPost(url);
		 httpPost.addHeader("content-type", "application/json");
		 httpPost.addHeader("Account-Key", AccountKey);
		 httpPost.addHeader("Random", random);
		 httpPost.addHeader("UTC-Timestamp", utcTimestamp);
		 httpPost.addHeader("User-Agent", "APISDK/1.1.0 (Android;4.4.4;phone;YuLong;Coolpad Y80D;hdpi;214413312,2157502464)");
		 //System.out.println(url);	

		 String body =params.toString();	
		 String str =body+utcTimestamp+random+ secretKey;
		 System.out.println(str);
		 String str1 =SignUntil.sign1(str);
		 httpPost.addHeader("Signature", str1);	
		 StringEntity entity = new StringEntity(body,"utf-8");
		 httpPost.setEntity(entity);	 
		 HttpResponse httpResponse = client.execute(httpPost);
		 HttpEntity httpEntity = httpResponse.getEntity();
		 String contentStr = EntityUtils.toString(httpEntity);

		String result ="[{\"status\":\"" + String.valueOf(httpResponse.getStatusLine().getStatusCode()) + "\"},"	+ contentStr + "]";
		return result;
		
	}

@Test(description = "T1,获取开通城市列表", priority = 0)
public  static String  get_open_city_list(CloseableHttpClient client,String utcTimestamp) throws Exception
	    //不能创建重复的城市
	{
		String url = ConfigModel.devhost;
		 JSONObject params = new JSONObject();

		 params.put("package", "public_platform.ground_sys.open_city");
		 params.put("class", "GET_OPEN_CITY_LIST");
		 
		 HttpPost httpPost = new HttpPost(url);
		 httpPost.addHeader("content-type", "application/json");
		 httpPost.addHeader("Account-Key", AccountKey);
		 httpPost.addHeader("Random", random);
		 httpPost.addHeader("UTC-Timestamp", utcTimestamp);
		 httpPost.addHeader("User-Agent", "APISDK/1.1.0 (Android;4.4.4;phone;YuLong;Coolpad Y80D;hdpi;214413312,2157502464)");
		 //System.out.println(url);	

		 String body =params.toString();	
		 String str =body+utcTimestamp+random+ secretKey;
		 System.out.println(str);
		 String str1 =SignUntil.sign1( str);
		 httpPost.addHeader("Signature", str1);	
		 StringEntity entity = new StringEntity(body,"utf-8");
		 httpPost.setEntity(entity);	 
		 HttpResponse httpResponse = client.execute(httpPost);
		 HttpEntity httpEntity = httpResponse.getEntity();
		 String contentStr = EntityUtils.toString(httpEntity);

		String result ="[{\"status\":\"" + String.valueOf(httpResponse.getStatusLine().getStatusCode()) + "\"},"	+ contentStr + "]";
		return result;
		
	}

@Test(description = "T1,从经营场所重建开放城市列表", priority = 0)
public  static String  rebuild_open_city(CloseableHttpClient client,String utcTimestamp) throws Exception
	    //
	{
		String url = ConfigModel.devhost;
		 JSONObject params = new JSONObject();

		 params.put("package", "public_platform.ground_sys.open_city");
		 params.put("class", "REBUILD_OPEN_CITY");
		 
		 HttpPost httpPost = new HttpPost(url);
		 httpPost.addHeader("content-type", "application/json");
		 httpPost.addHeader("Account-Key", AccountKey);
		 httpPost.addHeader("Random", random);
		 httpPost.addHeader("UTC-Timestamp", utcTimestamp);
		 httpPost.addHeader("User-Agent", "APISDK/1.1.0 (Android;4.4.4;phone;YuLong;Coolpad Y80D;hdpi;214413312,2157502464)");
		 //System.out.println(url);	

		 String body =params.toString();	
		 String str =body+utcTimestamp+random+ secretKey;
		 System.out.println(str);
		 String str1 =SignUntil.sign1( str);
		 httpPost.addHeader("Signature", str1);	
		 StringEntity entity = new StringEntity(body,"utf-8");
		 httpPost.setEntity(entity);	 
		 HttpResponse httpResponse = client.execute(httpPost);
		 HttpEntity httpEntity = httpResponse.getEntity();
		 String contentStr = EntityUtils.toString(httpEntity);

		String result ="[{\"status\":\"" + String.valueOf(httpResponse.getStatusLine().getStatusCode()) + "\"},"	+ contentStr + "]";
		return result;
		
	}

@Test(description = "T1,搜索开放城市的列表", priority = 0)
public  static String  search_list(CloseableHttpClient client,String utcTimestamp,String prov_id,String city_id,String page,String pagesize) throws Exception
	    //filter这个key不传则返回所有
	{
		String url = ConfigModel.devhost;
		 JSONObject params = new JSONObject();

		 params.put("package", "public_platform.ground_sys.open_city");
		 params.put("class", "SEARCH_LIST");
		 JSONObject inJsonObject = new JSONObject();
		 inJsonObject.put("prov_id", prov_id);
		 inJsonObject.put("city_id", city_id);
		 
		 params.put("page", page);
		 params.put("pagesize", pagesize);
		 params.put("filter", inJsonObject);
		 
		 HttpPost httpPost = new HttpPost(url);
		 httpPost.addHeader("content-type", "application/json");
		 httpPost.addHeader("Account-Key", AccountKey);
		 httpPost.addHeader("Random", random);
		 httpPost.addHeader("UTC-Timestamp", utcTimestamp);
		 httpPost.addHeader("User-Agent", "APISDK/1.1.0 (Android;4.4.4;phone;YuLong;Coolpad Y80D;hdpi;214413312,2157502464)");
		 //System.out.println(url);	

		 String body =params.toString();	
		 String str =body+utcTimestamp+random+ secretKey;
		 System.out.println(str);
		 String str1 =SignUntil.sign1( str);
		 httpPost.addHeader("Signature", str1);	
		 StringEntity entity = new StringEntity(body,"utf-8");
		 httpPost.setEntity(entity);	 
		 HttpResponse httpResponse = client.execute(httpPost);
		 HttpEntity httpEntity = httpResponse.getEntity();
		 String contentStr = EntityUtils.toString(httpEntity);

		String result ="[{\"status\":\"" + String.valueOf(httpResponse.getStatusLine().getStatusCode()) + "\"},"	+ contentStr + "]";
		return result;
		
	}






@Test
public void dell_test_all() throws Exception{
    //调试
	
	CloseableHttpClient client = HttpClients.createDefault();
	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	//String result1 =bissness_city_operate.remove_city(client, utcstr, "12598");
//	String result1 =bissness_city_operate.create_open_city(client, utcstr, "13437");
//	String result1 =bissness_city_operate.get_open_city_list(client, utcstr);
//	String result1 =bissness_city_operate.rebuild_open_city(client, utcstr);
	String result1 =bissness_city_operate.search_list(client, utcstr, "12596", "", "1", "10");
	
	System.out.println(result1);
}


	
	
	
	

}
