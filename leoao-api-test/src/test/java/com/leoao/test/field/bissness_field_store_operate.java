package com.leoao.test.field;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.leoao.test.common.ConfigModel;
import com.leoao.test.common.TestBase;
import com.leoao.test.tool.SignUntil;
import com.leoao.test.tool.SystemLogger;


public class bissness_field_store_operate extends TestBase{
	SystemLogger log = SystemLogger.getLogger(bissness_field_store_operate.class);
	static String AccountKey ="1103";
	static String secretKey ="9f8a6125c04aec7ae781d22894d3b745";
	static String random = "cs123456";
	
	
@Test(description = "T1,设置经营场所的基本信息", priority = 0)
public  static String  create_store_base_info(CloseableHttpClient client,String utcTimestamp ,String store_name,String has_face,String addr,String store_abstract,String resources_type,String property_type,String cooperation_type,String active_status,String start_business_time,String lat,String lng,String name,String phone,String email,String pro_id,String city_id,String zone_id) throws Exception
	  //某些type字段属性名为动态值，需要从public_platform.ground_sys.base_info.pub_attr.GET_PROP_ITEM_MULT接口拉取imgs:现阶段只支持 type=1的类型，且只保存第一张图
	{
		String url = ConfigModel.devhost;
		
		// Map<String, String> params = new HashMap<String,String>();
		 JSONObject params = new JSONObject();
	
		 params.put("package", "public_platform.ground_sys.base_info.store_operate");
		 params.put("class", "CREATE_STORE_BASE_INFO");
		 params.put("store_name",store_name);
		 params.put("has_face",has_face);
		 params.put("addr",addr);
		 params.put("store_abstract",store_abstract);
		 params.put("resources_type",resources_type);
		 params.put("property_type",property_type);
		 params.put("cooperation_type",cooperation_type);
		 params.put("active_status",active_status);
		 params.put("start_business_time",start_business_time);
		 params.put("has_face",has_face);
		 
		// ObjectMapper json1 = new ObjectMapper();
		 
		 
		// JSONArray jsonArray = new JSONArray();
		 JSONObject inJsonObject = new JSONObject();
		 inJsonObject.put("lat", lat);
		 inJsonObject.put("lng", lng);
		 params.put("location", inJsonObject); 
		 //jsonArray.put(inJsonObject);
		// params.put("location", jsonArray.toString()); 
		
		 
		 JSONObject inJsonObject1 = new JSONObject();
		 inJsonObject1.put("name", name);
		 inJsonObject1.put("phone", phone);
		 inJsonObject1.put("email", email);
		 params.put("manager", inJsonObject1); 
		 
		 
		 JSONObject inJsonObject2 = new JSONObject();
		 inJsonObject2.put("pro_id", pro_id);
		 inJsonObject2.put("city_id", city_id);
		 inJsonObject2.put("zone_id", zone_id);
		 params.put("region", inJsonObject2); 
		 
		 
		 HttpPost httpPost = new HttpPost(url);
		 httpPost.addHeader("content-type", "application/json");
		 
		 httpPost.addHeader("Account-Key", AccountKey);
		 httpPost.addHeader("Random", random);
		 httpPost.addHeader("UTC-Timestamp", utcTimestamp);
		 httpPost.addHeader("User-Agent", "APISDK/1.1.0 (Android;4.4.4;phone;YuLong;Coolpad Y80D;hdpi;214413312,2157502464)");
		 System.out.println(url);	
		// ObjectMapper json = new ObjectMapper();
		
			
		// String body =json.writeValueAsString(params).replace("\\", "").replace("\"{", "{").replace("}\"", "}");
		
		// String body =json.writeValueAsString(params.toString()).replace("\\", "").replace("\"{", "{").replace("}\"", "}");
		 
		 String body =params.toString();
		 
		 System.out.println(body);
		 
		
		 String str =body+utcTimestamp+random+ secretKey;
		 String str1 =SignUntil.sign1( str);
    	 httpPost.addHeader("Signature", str1);
    	// System.out.println(str1);
    	 StringEntity entity = new StringEntity(body,"utf-8");
		  httpPost.setEntity(entity);
		 
		 
		 HttpResponse httpResponse = client.execute(httpPost);


			HttpEntity httpEntity = httpResponse.getEntity();
			String contentStr = EntityUtils.toString(httpEntity);
			
		  //  params.clear();
		
		
		
		String result ="[{\"status\":\"" + String.valueOf(httpResponse.getStatusLine().getStatusCode()) + "\"},"	+ contentStr + "]";
		return result;
		
	}
	
@Test(description = "T1,创建经营场所的基本信息", priority = 0)
public  static String  set_store_base_info(CloseableHttpClient client,String utcTimestamp ,String store_id,String store_name,String has_face,String addr,String store_abstract,String resources_type,String property_type,String cooperation_type,String active_status,String start_business_time,String lat,String lng,String name,String phone,String email,String pro_id,String city_id,String zone_id,String canshu) throws Exception
	   //输入 store_id 必须要提供，其他项目当不提供key时则不修改
	{
		String url = ConfigModel.devhost;
		 JSONObject params = new JSONObject();
	
		 params.put("package", "public_platform.ground_sys.base_info.store_operate");
		 params.put("class", "SET_STORE_BASE_INFO");
		 params.put("store_id",store_id);
		 params.put("store_name",store_name);
		 params.put("has_face",has_face);
		 params.put("addr",addr);
		 params.put("store_abstract",store_abstract);
		 params.put("resources_type",resources_type);
		 params.put("property_type",property_type);
		 params.put("cooperation_type",cooperation_type);
		 params.put("active_status",active_status);
		 params.put("start_business_time",start_business_time);
		 params.put("has_face",has_face);
		 if(canshu !=""){
			 params.put("canshu",canshu);
		 }
		 
		 JSONObject inJsonObject = new JSONObject();
		 inJsonObject.put("lat", lat);
		 inJsonObject.put("lng", lng);
		 params.put("location", inJsonObject); 		
		 
		 JSONObject inJsonObject1 = new JSONObject();
		 inJsonObject1.put("name", name);
		 inJsonObject1.put("phone", phone);
		 inJsonObject1.put("email", email);
		 params.put("manager", inJsonObject1); 
 
		 JSONObject inJsonObject2 = new JSONObject();
		 inJsonObject2.put("pro_id", pro_id);
		 inJsonObject2.put("city_id", city_id);
		 inJsonObject2.put("zone_id", zone_id);
		 params.put("region", inJsonObject2); 
		 
		 
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

@Test(description = "T1,设置经营场所的图片组", priority = 0)
public  static String  set_store_img(CloseableHttpClient client,String utcTimestamp,String  store_id,String type,String imgurl) throws Exception
	    //imgs.type 现阶段只支持 1的类型，且只保存第一张图
	{
		String url = ConfigModel.devhost;
		 JSONObject params = new JSONObject();
	
		 params.put("package", "public_platform.ground_sys.base_info.store_operate");
		 params.put("class", "SET_STORE_IMG");
		 params.put("store_id",store_id);
		 
		 JSONArray jsonArray = new JSONArray();
		 JSONObject inJsonObject = new JSONObject();
		 inJsonObject.put("type", type);
		 if (imgurl !=""){
		 inJsonObject.put("url", imgurl);
		 }
		 jsonArray.put(inJsonObject);
		 params.put("imgs", jsonArray); 
		
			 
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
	

@Test(description = "T1,设置经营场所的服务时间", priority = 0)
public  static String  set_store_service_time(CloseableHttpClient client,String utcTimestamp,String  store_id,String service_time_type,String week,String start_time,String end_time,String week1,String start_time1,String end_time1) throws Exception
	     //服务时间包含：有限权益时间(limited_right_time), 营业时间(business_service_time)
        //service_time_type = limited_right_time 时，且set_time_list=[]，表示不存在有限权益服务时间
        //service_time_type = business_service_time 时，且set_time_list=[]，表示24小时营业
       //set_time_list中每条记录，表示某一周中的某个时间段
	{
		String url = ConfigModel.devhost;
		 JSONObject params = new JSONObject();
	
		 params.put("package", "public_platform.ground_sys.base_info.store_operate");
		 params.put("class", "SET_STORE_SERVICE_TIME");
		 params.put("store_id",store_id);
		 params.put("service_time_type",service_time_type);
		 
		 JSONArray jsonArray = new JSONArray();
		 JSONObject inJsonObject = new JSONObject();
		 JSONObject inJsonObject1 = new JSONObject();
		 inJsonObject.put("week", week);
		 inJsonObject.put("start_time", start_time);
		 inJsonObject.put("end_time", end_time);
		 jsonArray.put(inJsonObject);
		 if(week1 !=""){
			 inJsonObject1.put("week", week1);
			 inJsonObject1.put("start_time", start_time1);
			 inJsonObject1.put("end_time", end_time1);
			 jsonArray.put(inJsonObject1);
		 }
		 params.put("set_time_list", jsonArray); 
		
			 
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

@Test(description = "T1,获取地区信息", priority = 0)
public  static String  get_area_list(CloseableHttpClient client,String utcTimestamp,String  parent_id) throws Exception
	     //地区信息包含：省，市，区，街
	{
		String url = ConfigModel.devhost;
		 JSONObject params = new JSONObject();
	
		 params.put("package", "public_platform.ground_sys.region");
		 params.put("class", "GET_AREA_LIST");
		 params.put("parent_id",parent_id);
		 
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
	  
		//String result0 =bissness_field_store_operate.create_store_base_info(client, utcstr, "test", "1", "杭州市西溪路525号", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 //	String result1 =bissness_field_store_operate.set_store_base_info(client, utcstr, "7","test04", "1", "杭州市西溪路525号", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	//	String result1 =bissness_field_store_operate.set_store_img(client, utcstr, "7","1", "https://img.leoao.com/o_1b15urgpgsdm1uebf7g4up1rg19.jpg");
	//	String result1 =bissness_field_store_operate.set_store_img(client, utcstr, "7","1", "https://img.leoao.com/o_1b15urgpgsdm1uebf7g4up1rg19.jpg");
		//String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "7","business_service_time", "1","900","1100");
		String result1 =bissness_field_store_operate.get_area_list(client, utcstr, "12596");
	    
		
		System.out.println(result1);
	     	
	   //  log.info("test is:" + result1);
	   
		
		 
		
		
	}
	
	
	

}
