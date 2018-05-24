package com.leoao.test.testcase;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.leoao.test.common.TestBase;
import com.leoao.test.field.bissness_field_store_operate;
import com.leoao.test.tool.Assertrename;
import com.leoao.test.tool.SystemLogger;

public class TestSetServiceTime extends TestBase{
	SystemLogger log = SystemLogger.getLogger(TestSetServiceTime.class);
@Test(description = "T1,经营场所store_id存在", priority = 0)
public void set_store_service_time_001() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "191","business_service_time", "1","901","1101","","","");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_service_time_001:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");
		
			
	}
@Test(description = "T2,经营场所store_id为空", priority = 0)
public void set_store_service_time_002() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "","business_service_time", "1","900","1100","","","");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_service_time_002:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");
		
			
	}
@Test(description = "T3,经营场所store_id不存在", priority = 0)
public void set_store_service_time_003() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "0","business_service_time", "1","900","1100","","","");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_service_time_003:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10020");
		
			
	}
@Test(description = "T4,星期week值不存在，星期8", priority = 0)
public void set_store_service_time_004() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "191","business_service_time", "8","1030","1900","","","");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_service_time_004:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10014");
		
			
	}
@Test(description = "T5,星期week值为空", priority = 0)
public void set_store_service_time_005() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "191","business_service_time", "","1030","1900","","","");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_service_time_005:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10020");
		
			
	}
@Test(description = "T6,start_time值为空", priority = 0)
public void set_store_service_time_006() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "191","business_service_time", "1","","1900","","","");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_service_time_006:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");
		
			
	}
@Test(description = "T7,end_time值为9999", priority = 0)
public void set_store_service_time_007() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "191","business_service_time", "1","1000","9999","","","");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_service_time_007:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10016");
		
			
	}
@Test(description = "T8,end_time值<start_time", priority = 0)
public void set_store_service_time_008() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "191","business_service_time", "1","1000","800","","","");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_service_time_008:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10017");
		
			
	}
@Test(description = "T9,week 数组【12】", priority = 0)
public void set_store_service_time_009() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "191","business_service_time", "1","1000","1200","2","1030","1230");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_service_time_008:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");
		
			
	}
@Test(description = "T10,week 数组【12】", priority = 0)
public void set_store_service_time_010() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "191","business_service_time", "1","1200","1400","2","1230","1000");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_service_time_008:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10017");
		
			
	}
@Test(description = "T11,服务时间类型service_time_type ：limited_right_time", priority = 0)
public void set_store_service_time_011() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "191","limited_right_time", "1","1200","1400","2","1230","1900");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_service_time_008:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");
		
			
	}
@Test(description = "T12,服务时间类型service_time_type ：不存在的服务类型", priority = 0)
public void set_store_service_time_012() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_service_time(client, utcstr, "191","limited_right_kdltime", "1","1200","1400","2","1230","1900");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_service_time_008:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10002");
		
			
	}

	

}
