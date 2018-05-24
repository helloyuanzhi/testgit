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

public class bissness_field_pull extends TestBase{
	SystemLogger log = SystemLogger.getLogger(bissness_field_pull.class);
	static String AccountKey ="1103";
	static String secretKey ="9f8a6125c04aec7ae781d22894d3b745";
	static String random = "cs123456";
	@Test(description = "T1,查询场地基本信息", priority = 0)
	public  static String  get_ground_base_info(CloseableHttpClient client,String utcTimestamp,String  ground_id) throws Exception
    //无
{
	String url = ConfigModel.devhost;
	 JSONObject params = new JSONObject();

	 params.put("package", "public_platform.ground_sys.base_info.pull");
	 params.put("class", "GET_GROUND_BASE_INFO");
	 params.put("ground_id",ground_id);
	 
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
	@Test(description = "T1,查询经营场所基本信息", priority = 0)
	public  static String  get_store_base_info(CloseableHttpClient client,String utcTimestamp,String  store_id) throws Exception
    //无
{
	String url = ConfigModel.devhost;
	 JSONObject params = new JSONObject();

	 params.put("package", "public_platform.ground_sys.base_info.pull");
	 params.put("class", "GET_STORE_BASE_INFO");
	 params.put("store_id",store_id);

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
	
	@Test(description = "T1,批量获取指定id的 经营场所基本信息列表", priority = 0)
	public  static String  get_store_base_info_ids(CloseableHttpClient client,String utcTimestamp,String  store_ids,String  fields) throws Exception
    //建议使用 fields 来过滤多余的项目
{
	String url = ConfigModel.devhost;
	 JSONObject params = new JSONObject();

	 params.put("package", "public_platform.ground_sys.base_info.pull");
	 params.put("class", "GET_STORE_BASE_INFO_IDS");
	 params.put("store_ids",store_ids);
	 params.put("fields",fields);

	 HttpPost httpPost = new HttpPost(url);
	 httpPost.addHeader("content-type", "application/json");
	 httpPost.addHeader("Account-Key", AccountKey);
	 httpPost.addHeader("Random", random);
	 httpPost.addHeader("UTC-Timestamp", utcTimestamp);
	 httpPost.addHeader("User-Agent", "APISDK/1.1.0 (Android;4.4.4;phone;YuLong;Coolpad Y80D;hdpi;214413312,2157502464)");
	 System.out.println(url);	

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
	@Test(description = "T1,查询经营场所最小基本信息", priority = 0)
	public  static String  get_store_small_info(CloseableHttpClient client,String utcTimestamp,String  store_id,String  fields) throws Exception
    //本接口专门针对性能进行优化 【注意】本接口带5分钟缓存
{
	String url = ConfigModel.devhost;
	 JSONObject params = new JSONObject();

	 params.put("package", "public_platform.ground_sys.base_info.pull");
	 params.put("class", "GET_STORE_SMALL_INFO");
	 params.put("store_id",store_id);
	 params.put("fields",fields);

	 HttpPost httpPost = new HttpPost(url);
	 httpPost.addHeader("content-type", "application/json");
	 httpPost.addHeader("Account-Key", AccountKey);
	 httpPost.addHeader("Random", random);
	 httpPost.addHeader("UTC-Timestamp", utcTimestamp);
	 httpPost.addHeader("User-Agent", "APISDK/1.1.0 (Android;4.4.4;phone;YuLong;Coolpad Y80D;hdpi;214413312,2157502464)");
	 System.out.println(url);	

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
public  static String  ground_search_list(CloseableHttpClient client,String utcTimestamp,String  store_id,String ground_name,String page,String pagesize) throws Exception
    //不能创建重复的城市
{
	String url = ConfigModel.devhost;
	 JSONObject params = new JSONObject();

	 params.put("package", "public_platform.ground_sys.base_info.pull");
	 params.put("class", "GROUND_SEARCH_LIST");
	 params.put("page",page);
	 params.put("pagesize",pagesize);
	 
	 JSONObject inJsonObject = new JSONObject();
	 inJsonObject.put("store_id", store_id);
	 inJsonObject.put("ground_name", ground_name);
	 params.put("filter", inJsonObject); 
	 
	 
	 HttpPost httpPost = new HttpPost(url);
	 httpPost.addHeader("content-type", "application/json");
	 httpPost.addHeader("Account-Key", AccountKey);
	 httpPost.addHeader("Random", random);
	 httpPost.addHeader("UTC-Timestamp", utcTimestamp);
	 httpPost.addHeader("User-Agent", "APISDK/1.1.0 (Android;4.4.4;phone;YuLong;Coolpad Y80D;hdpi;214413312,2157502464)");
	 //System.out.println(url);	

	 String body =params.toString();
	 System.out.println(body);
	 String str =body+utcTimestamp+random+ secretKey;
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
	
	@Test(description = "T1,搜索经营场所列表(非业务形场景使用，仅对内部管理系统使用)", priority = 0)
	public  static String  store_search_list(CloseableHttpClient client,String utcTimestamp,String  store_name,String city_id,String zone_id,String property_type,String resources_type,String cooperation_type,String active_status,String sort,String page,String pagesize) throws Exception
    //filter 中的key不提供时，表示此key的条件无约束
{
	String url = ConfigModel.devhost;
	 JSONObject params = new JSONObject();

	 params.put("package", "public_platform.ground_sys.base_info.pull");
	 params.put("class", "STORE_SEARCH_LIST");
	 params.put("sort",sort);
	 params.put("page",page);
	 params.put("pagesize",pagesize);
	 
	 JSONObject inJsonObject = new JSONObject();
	 inJsonObject.put("store_name", store_name);
	 inJsonObject.put("city_id", city_id);
	 inJsonObject.put("zone_id", zone_id);
	 inJsonObject.put("property_type", property_type);
	 inJsonObject.put("resources_type", resources_type);
	 inJsonObject.put("cooperation_type", cooperation_type);
	 inJsonObject.put("active_status", active_status);
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
       // String result1 =bissness_field_pull.get_ground_base_info(client, utcstr, "1");
     //   String result1 =bissness_field_pull.get_store_base_info(client, utcstr, "10");
	//	String result1 =bissness_field_pull.get_store_base_info_ids(client, utcstr, "[10,11]", "");
		String result1 =bissness_field_pull.get_store_base_info_ids(client, utcstr, "10", "");
      //  String result1 =bissness_field_pull.ground_search_list(client, utcstr, "1", "公共器械区", "1", "20");
	//	String result1 =bissness_field_pull.store_search_list(client, utcstr, "西溪新座X1", "12597", "12685", "1", "0", "1", "1","1", "1", "20");
		
		
		System.out.println(result1);
	}

}
