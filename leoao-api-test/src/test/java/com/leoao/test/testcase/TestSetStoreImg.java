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

public class TestSetStoreImg extends TestBase{
	 SystemLogger log = SystemLogger.getLogger(TestSetStoreImg.class);
@Test(description = "T1,经营场所store_id存在", priority = 0)
public void set_store_img_001() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_img(client, utcstr, "191","1", "https://img.leoao.com/o_1b15urgpgsdm1uebf7g4up1rg19.jpg");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_img_001:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");
		
			
	}
	
@Test(description = "T2,经营场所store_id为空", priority = 0)
public void set_store_img_002() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_img(client, utcstr, "","1", "https://img.leoao.com/o_1b15urgpgsdm1uebf7g4up1rg19.jpg");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_img_002:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");
		
	}
@Test(description = "T3,经营场所store_id不存在", priority = 0)
public void set_store_img_003() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_img(client, utcstr, "0","1", "https://img.leoao.com/o_1b15urgpgsdm1uebf7g4up1rg19.jpg");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_img_003:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10020");
		
	}
@Test(description = "T4,IMG type为空", priority = 0)
public void set_store_img_004() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_img(client, utcstr, "192","", "https://img.leoao.com/o_1b15urgpgsdm1uebf7g4up1rg19.jpg");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_img_004:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");
		
	}
@Test(description = "T5,IMG url缺省，结构不存在", priority = 0)
public void set_store_img_005() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_img(client, utcstr, "193","1", "");
		 JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_img_005:    "+result1);
			} 

	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10013");
		
	}


}
