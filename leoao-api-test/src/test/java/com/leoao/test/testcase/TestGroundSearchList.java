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

public class TestGroundSearchList extends TestBase{
SystemLogger log = SystemLogger.getLogger(TestGroundSearchList.class);
@Test(description = "T1,查询开放城市,store_id存在", priority = 0)
public void ground_search_list_001() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.ground_search_list(client, utcstr, "191", "公共器械区", "1", "20");
								 JSONArray res1 = JSON.parseArray(result1);
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("ground_search_list_001:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
}
@Test(description = "T2,查询开放城市,store_id为空", priority = 0)
public void ground_search_list_002() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.ground_search_list(client, utcstr, "", "公共器械区", "1", "20");
								 JSONArray res1 = JSON.parseArray(result1);
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("ground_search_list_002:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");			
}
@Test(description = "T3,查询开放城市,store_id为不存在", priority = 0)
public void ground_search_list_003() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.ground_search_list(client, utcstr, "9999999", "公共器械区", "1", "20");
								 JSONArray res1 = JSON.parseArray(result1);
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("ground_search_list_003:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");			
}
@Test(description = "T4,查询开放城市,ground_name为空", priority = 0)
public void ground_search_list_004() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.ground_search_list(client, utcstr, "192", "", "1", "20");
								 JSONArray res1 = JSON.parseArray(result1);
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("ground_search_list_004:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
}

@Test(description = "T5,查询开放城市,page为2", priority = 0)
public void ground_search_list_005() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.ground_search_list(client, utcstr, "192", "", "2", "20");
								 JSONArray res1 = JSON.parseArray(result1);
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("ground_search_list_005:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
}
@Test(description = "T6,查询开放城市,page为空", priority = 0)
public void ground_search_list_006() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.ground_search_list(client, utcstr, "192", "", "", "20");
								 JSONArray res1 = JSON.parseArray(result1);
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("ground_search_list_006:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
}

@Test(description = "T7,查询开放城市,page为-1", priority = 0)
public void ground_search_list_007() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.ground_search_list(client, utcstr, "192", "", "-1", "20");
								 JSONArray res1 = JSON.parseArray(result1);
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("ground_search_list_007:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
}
@Test(description = "T8,查询开放城市,pagesize为2", priority = 0)
public void ground_search_list_008() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.ground_search_list(client, utcstr, "192", "", "1", "2");
								 JSONArray res1 = JSON.parseArray(result1);
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("ground_search_list_008:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
}
@Test(description = "T9,查询开放城市,pagesize为空", priority = 0)
public void ground_search_list_009() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.ground_search_list(client, utcstr, "192", "", "1", "");
								 JSONArray res1 = JSON.parseArray(result1);
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("ground_search_list_008:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
}


}
