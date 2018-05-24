package com.leoao.test.testcase;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.leoao.test.common.TestBase;
import com.leoao.test.field.bissness_field_pull;
import com.leoao.test.tool.Assertrename;
import com.leoao.test.tool.SystemLogger;

public class TestGetStoreBaseInfo extends TestBase{
SystemLogger log = SystemLogger.getLogger(TestGetStoreBaseInfo.class);
@Test(description = "T1,查询经营场所基本信息,store_id存在", priority = 0)
public void get_store_base_info_001() throws Exception{
							CloseableHttpClient client = HttpClients.createDefault();	
							String utcstr = String.valueOf(System.currentTimeMillis()/1000);
							String result1 =bissness_field_pull.get_store_base_info(client, utcstr, "191");
							 JSONArray res1 = JSON.parseArray(result1);
						     System.out.println(result1);			    
						     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
								{
									log.info("get_store_base_info_001:    "+result1);
								} 
						     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
						}
@Test(description = "T2,查询经营场所基本信息,store_id为空", priority = 0)
public void get_store_base_info_002() throws Exception{
							CloseableHttpClient client = HttpClients.createDefault();	
							String utcstr = String.valueOf(System.currentTimeMillis()/1000);
							String result1 =bissness_field_pull.get_store_base_info(client, utcstr, "");
							 JSONArray res1 = JSON.parseArray(result1);
						     System.out.println(result1);			    
						     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
								{
									log.info("get_store_base_info_002:    "+result1);
								} 
						     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");			
}
@Test(description = "T3,查询经营场所基本信息,store_id为不存在", priority = 0)
public void get_store_base_info_003() throws Exception{
							CloseableHttpClient client = HttpClients.createDefault();	
							String utcstr = String.valueOf(System.currentTimeMillis()/1000);
							String result1 =bissness_field_pull.get_store_base_info(client, utcstr, "0");
							 JSONArray res1 = JSON.parseArray(result1);
						     System.out.println(result1);			    
						     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
								{
									log.info("get_store_base_info_003:    "+result1);
								} 
						     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10010");			
}
@Test(description = "T4,查询经营场所基本信息,store_id为中文", priority = 0)
public void get_store_base_info_004() throws Exception{
							CloseableHttpClient client = HttpClients.createDefault();	
							String utcstr = String.valueOf(System.currentTimeMillis()/1000);
							String result1 =bissness_field_pull.get_store_base_info(client, utcstr, "中文字符");
							 JSONArray res1 = JSON.parseArray(result1);
						     System.out.println(result1);			    
						     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
								{
									log.info("get_store_base_info_004:    "+result1);
								} 
						     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");			
}




}
