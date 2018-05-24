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

public class TestStoreSearchList extends TestBase{
SystemLogger log = SystemLogger.getLogger(TestStoreSearchList.class);
@Test(description = "T1,搜索经营场所列表,store_name存在", priority = 0)
public void store_search_list_001() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.store_search_list(client, utcstr, "西溪", "12597", "12637", "", "", "", "","","1", "20");
								 JSONArray res1 = JSON.parseArray(result1); 
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("store_search_list_001:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
							}	
@Test(description = "T2,搜索经营场所列表,store_name为空", priority = 0)
public void store_search_list_002() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.store_search_list(client, utcstr, "", "12597", "12637", "", "", "", "","", "1", "20");
								 JSONArray res1 = JSON.parseArray(result1); 
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("store_search_list_002:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
							}	
@Test(description = "T3,搜索经营场所列表,翻页功能", priority = 0)
public void store_search_list_003() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.store_search_list(client, utcstr, "", "12597", "12637", "", "", "", "","", "3", "5");
								 JSONArray res1 = JSON.parseArray(result1); 
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("store_search_list_003:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
							}	
@Test(description = "T4,搜索经营场所列表,ID倒叙排列", priority = 0)
public void store_search_list_004() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.store_search_list(client, utcstr, "", "12597", "12637", "", "", "","", "2", "4", "5");
								 JSONArray res1 = JSON.parseArray(result1); 
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("store_search_list_004:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
							}
@Test(description = "T5,搜索经营场所列表,active_status为2", priority = 0)
public void store_search_list_005() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.store_search_list(client, utcstr, "", "12597", "12637", "", "", "","2", "2", "1", "10");
								 JSONArray res1 = JSON.parseArray(result1); 
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("store_search_list_005:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
							}
@Test(description = "T6,搜索经营场所列表,active_status为1营业状态", priority = 0)
public void store_search_list_006() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.store_search_list(client, utcstr, "", "12597", "12637", "", "", "","1", "2", "1", "10");
								 JSONArray res1 = JSON.parseArray(result1); 
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("store_search_list_006:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
							}
@Test(description = "T7,搜索经营场所列表,pagesize为空，默认是10", priority = 0)
public void store_search_list_007() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.store_search_list(client, utcstr, "", "12597", "12637", "", "", "","1", "2", "1", "");
								 JSONArray res1 = JSON.parseArray(result1); 
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("store_search_list_007:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
							}
@Test(description = "T8,搜索经营场所列表,pages为空，默认是1", priority = 0)
public void store_search_list_008() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.store_search_list(client, utcstr, "", "12597", "12637", "", "", "","1", "2", "", "");
								 JSONArray res1 = JSON.parseArray(result1); 
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("store_search_list_008:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
							}
@Test(description = "T9,搜索经营场所列表,pages为中文，异常处理为1", priority = 0)
public void store_search_list_009() throws Exception{
								CloseableHttpClient client = HttpClients.createDefault();	
								String utcstr = String.valueOf(System.currentTimeMillis()/1000);
								String result1 =bissness_field_pull.store_search_list(client, utcstr, "", "12597", "12637", "", "", "","1", "2", "中文", "");
								 JSONArray res1 = JSON.parseArray(result1); 
							     System.out.println(result1);			    
							     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
									{
										log.info("store_search_list_009:    "+result1);
									} 
							     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
							}





}
