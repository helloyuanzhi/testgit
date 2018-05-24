package com.leoao.test.field;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
//import org.json.JSONArray;
//import org.json.JSONObject;
import net.sf.json.JSONArray;  
import net.sf.json.JSONObject; 
import org.testng.annotations.Test;

import com.leoao.test.common.ConfigModel;
import com.leoao.test.common.TestBase;
import com.leoao.test.tool.SignUntil;
import com.leoao.test.tool.SystemLogger;

public class bissness_field_ground_operate extends TestBase{
	
	SystemLogger log = SystemLogger.getLogger(bissness_field_ground_operate.class);
	static String AccountKey ="1103";
	static String secretKey ="9f8a6125c04aec7ae781d22894d3b745";
	static String random = "cs123456";
@Test(description = "T1,创建经营场所下的场地基本信息", priority = 0)
public  static String  create_ground_base_info(CloseableHttpClient client,String utcTimestamp,String  store_id,String  ground_name,String  usable_area,String  area_type,String  is_public_area) throws Exception
    //area_type的参数，可通过public_platform.ground_sys.base_info.pub_attr.GET_PROP_ITEM_MULT接口拉取
{
	String url = ConfigModel.devhost;
	 JSONObject params = new JSONObject();

	 params.put("package", "public_platform.ground_sys.base_info.ground_operate");
	 params.put("class", "CREATE_GROUNDE_BASE_INFO");
	 params.put("store_id",store_id);
	 params.put("ground_name",ground_name);
	 params.put("usable_area",usable_area);
	 params.put("area_type",area_type);
	 params.put("is_public_area",is_public_area);
	 
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
@Test(description = "T1,设置场地绑定的课程业务类型", priority = 0)
public  static String  set_ground_class_type_rel(CloseableHttpClient client,String utcTimestamp,String  ground_id,String list) throws Exception
    //class_type 为 课程业务类型：内容从课程系统读取过来，内容为 团操，私教，小团体等等，需要把id与name都传过来；不传则清除配置
{
	String url = ConfigModel.devhost;
	 JSONObject params = new JSONObject();

	 params.put("package", "public_platform.ground_sys.base_info.ground_operate");
	 params.put("class", "SET_GROUND_CLASS_TYPE_REL");
	 params.put("ground_id",ground_id); 
	 params.put("class_type", JSONArray.fromObject(list)); 
	 
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
@Test(description = "T1,设置经营场所的主题类型", priority = 0)
public  static String  set_ground_theme(CloseableHttpClient client,String utcTimestamp,String  store_ground_id,String  list) throws Exception
    //【注意】主题类型从课程业务系统的接口读取 每次设置时会覆盖场地原始的主题绑定关系
{
	String url = ConfigModel.devhost;
	 JSONObject params = new JSONObject();

	 params.put("package", "public_platform.ground_sys.base_info.ground_operate");
	 params.put("class", "SET_GROUND_THEME");
	 params.put("store_ground_id",store_ground_id);

	 params.put("theme", JSONArray.fromObject(list)); 
	 
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


@Test(description = "T1,修改场地基本信息", priority = 0)
public  static String  update_ground_base_info(CloseableHttpClient client,String utcTimestamp,String  ground_id,String  ground_name,String  usable_area,String  is_public_area,String area_type) throws Exception
    //update_field 为需要跟新的字段，如为空或者不提供key，则表示不修改
{
	String url = ConfigModel.devhost;
	 JSONObject params = new JSONObject();

	 params.put("package", "public_platform.ground_sys.base_info.ground_operate");
	 params.put("class", "UPDATE_GROUNDE_BASE_INFO");
	 params.put("ground_id",ground_id);
	
	 JSONObject inJsonObject = new JSONObject();
	
	 inJsonObject.put("ground_name", ground_name);
	 inJsonObject.put("usable_area", usable_area);
	 inJsonObject.put("is_public_area", is_public_area);
	 inJsonObject.put("area_type", area_type);

	 
	
	 params.put("update_field", inJsonObject); 
	 
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

@Test(description = "T1,删除一个场地", priority = 0)
public  static String  remove_ground(CloseableHttpClient client,String utcTimestamp,String  ground_id) throws Exception
    //无
{
	String url = ConfigModel.devhost;
	 JSONObject params = new JSONObject();

	 params.put("package", "public_platform.ground_sys.base_info.ground_operate");
	 params.put("class", "REMOVE_GROUND");
	 params.put("ground_id",ground_id);
	 
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


	
	@Test
	public void dell_test_all() throws Exception{
	    //调试
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
       // String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "1", "维多利亚多亚", "150", "1", "0");
		String result1 =bissness_field_ground_operate.set_ground_class_type_rel(client, utcstr, "1","[{\"id\":\"8\",\"name\":\"私教团课\"},{\"id\":\"9\",\"name\":\"私教团课001\"}]" );
		//String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "1", "维多利亚多亚001", "180", "0");
	//	String result1 =bissness_field_ground_operate.remove_ground(client, utcstr, "7");
	//	String result1 =bissness_field_ground_operate.set_ground_theme(client, utcstr, "1", "[{\"id\":\"8\",\"name\":\"私教团课\"},{\"id\":\"9\",\"name\":\"私教团课001\"}]");
				
		System.out.println(result1);
	}
	
	
	
	
	

}
