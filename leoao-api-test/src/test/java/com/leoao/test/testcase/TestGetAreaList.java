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

public class TestGetAreaList extends TestBase{
	SystemLogger log = SystemLogger.getLogger(TestGetAreaList.class);
@Test(description = "T1,获取地区信息parent_id存在", priority = 0)
public void get_area_list_001() throws Exception{
			CloseableHttpClient client = HttpClients.createDefault();	
			String utcstr = String.valueOf(System.currentTimeMillis()/1000);
			String result1 =bissness_field_store_operate.get_area_list(client, utcstr, "12596");
			 JSONArray res1 = JSON.parseArray(result1);
		     System.out.println(result1);
		    
		     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
				{
					log.info("get_area_list_001:    "+result1);
				} 

		     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");
			
				
		}

@Test(description = "T2,获取地区信息parent_id为空", priority = 0)
public void get_area_list_002() throws Exception{
			CloseableHttpClient client = HttpClients.createDefault();	
			String utcstr = String.valueOf(System.currentTimeMillis()/1000);
			String result1 =bissness_field_store_operate.get_area_list(client, utcstr, "");
			 JSONArray res1 = JSON.parseArray(result1);
		     System.out.println(result1);
		    
		     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
				{
					log.info("get_area_list_002:    "+result1);
				} 

		     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");
			
		}
@Test(description = "T3,获取地区信息parent_id不存在", priority = 0)
public void get_area_list_003() throws Exception{
			CloseableHttpClient client = HttpClients.createDefault();	
			String utcstr = String.valueOf(System.currentTimeMillis()/1000);
			String result1 =bissness_field_store_operate.get_area_list(client, utcstr, "122222");
			 JSONArray res1 = JSON.parseArray(result1);
		     System.out.println(result1);
		    
		     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
				{
					log.info("get_area_list_002:    "+result1);
				} 

		     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10010");
			
		}



	

}
