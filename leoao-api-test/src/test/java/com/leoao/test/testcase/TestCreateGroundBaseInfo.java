package com.leoao.test.testcase;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.leoao.test.common.TestBase;
import com.leoao.test.field.bissness_field_ground_operate;
import com.leoao.test.tool.Assertrename;
import com.leoao.test.tool.SystemLogger;

public class TestCreateGroundBaseInfo extends TestBase{
	SystemLogger log = SystemLogger.getLogger(TestCreateGroundBaseInfo.class);
	
@Test(description = "T1,创建经营场所下的场地基本信息,store_id存在", priority = 0)
public void create_ground_base_info_001() throws Exception{
				CloseableHttpClient client = HttpClients.createDefault();	
				String utcstr = String.valueOf(System.currentTimeMillis()/1000);
				String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "192", "维多利亚多亚"+utcstr, "150", "1", "0");
				 JSONArray res1 = JSON.parseArray(result1);
			     System.out.println(result1);			    
			     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
					{
						log.info("create_ground_base_info_001:    "+result1);
					} 
			     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
			}
@Test(description = "T2,创建经营场所下的场地基本信息,重复创建", priority = 0)
public void create_ground_base_info_002() throws Exception{
				CloseableHttpClient client = HttpClients.createDefault();	
				String utcstr = String.valueOf(System.currentTimeMillis()/1000);
				String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "192", "维多利亚多亚", "150", "1", "0");
				 JSONArray res1 = JSON.parseArray(result1);
			     System.out.println(result1);			    
			     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
					{
						log.info("create_ground_base_info_002:    "+result1);
					} 
			     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10012");			
			}

@Test(description = "T3,创建经营场所下的场地基本信息,store_id为空", priority = 0)
public void create_ground_base_info_003() throws Exception{
				CloseableHttpClient client = HttpClients.createDefault();	
				String utcstr = String.valueOf(System.currentTimeMillis()/1000);
				String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "", "维多利亚多亚"+utcstr, "150", "1", "0");
				 JSONArray res1 = JSON.parseArray(result1);
			     System.out.println(result1);			    
			     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
					{
						log.info("create_ground_base_info_003:    "+result1);
					} 
			     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");			
			}
@Test(description = "T4,创建经营场所下的场地基本信息,store_id为不存在", priority = 0)
public void create_ground_base_info_004() throws Exception{
				CloseableHttpClient client = HttpClients.createDefault();	
				String utcstr = String.valueOf(System.currentTimeMillis()/1000);
				String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "1222222", "维多利亚多亚"+utcstr, "150", "1", "0");
				 JSONArray res1 = JSON.parseArray(result1);
			     System.out.println(result1);			    
			     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
					{
						log.info("create_ground_base_info_004:    "+result1);
					} 
			     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10010");			
			}
@Test(description = "T5,创建经营场所下的场地基本信息,ground_name为空", priority = 0)
public void create_ground_base_info_005() throws Exception{
				CloseableHttpClient client = HttpClients.createDefault();	
				String utcstr = String.valueOf(System.currentTimeMillis()/1000);
				String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "192", "", "150", "1", "0");
				 JSONArray res1 = JSON.parseArray(result1);
			     System.out.println(result1);			    
			     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
					{
						log.info("create_ground_base_info_005:    "+result1);
					} 
			     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10002");			
			}
@Test(description = "T6,创建经营场所下的场地基本信息,usable_area为空", priority = 0)
public void create_ground_base_info_006() throws Exception{
				CloseableHttpClient client = HttpClients.createDefault();	
				String utcstr = String.valueOf(System.currentTimeMillis()/1000);
				String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "192", "维多利亚多亚"+utcstr, "", "1", "0");
				 JSONArray res1 = JSON.parseArray(result1);
			     System.out.println(result1);			    
			     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
					{
						log.info("create_ground_base_info_006:    "+result1);
					} 
			     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10003");			
			}
@Test(description = "T7,创建经营场所下的场地基本信息,usable_area为中文字", priority = 0)
public void create_ground_base_info_007() throws Exception{
				CloseableHttpClient client = HttpClients.createDefault();	
				String utcstr = String.valueOf(System.currentTimeMillis()/1000);
				String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "192", "维多利亚多亚"+utcstr, "一百平", "1", "0");
				 JSONArray res1 = JSON.parseArray(result1);
			     System.out.println(result1);			    
			     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
					{
						log.info("create_ground_base_info_007:    "+result1);
					} 
			     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10003");			
			}
@Test(description = "T8,创建经营场所下的场地基本信息,area_type为4", priority = 0)
public void create_ground_base_info_008() throws Exception{
				CloseableHttpClient client = HttpClients.createDefault();	
				String utcstr = String.valueOf(System.currentTimeMillis()/1000);
				String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "192", "维多利亚多亚"+utcstr, "150", "4", "0");
				 JSONArray res1 = JSON.parseArray(result1);
			     System.out.println(result1);			    
			     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
					{
						log.info("create_ground_base_info_008:    "+result1);
					} 
			     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
			}
@Test(description = "T9,创建经营场所下的场地基本信息,area_type为空", priority = 0)
public void create_ground_base_info_009() throws Exception{
				CloseableHttpClient client = HttpClients.createDefault();	
				String utcstr = String.valueOf(System.currentTimeMillis()/1000);
				String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "192", "维多利亚多亚"+utcstr, "150", "", "0");
				 JSONArray res1 = JSON.parseArray(result1);
			     System.out.println(result1);			    
			     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
					{
						log.info("create_ground_base_info_009:    "+result1);
					} 
			     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10004");			
			}
@Test(description = "T10,创建经营场所下的场地基本信息,area_type不存在", priority = 0)
public void create_ground_base_info_010() throws Exception{
				CloseableHttpClient client = HttpClients.createDefault();	
				String utcstr = String.valueOf(System.currentTimeMillis()/1000);
				String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "192", "维多利亚多亚"+utcstr, "150", "9", "0");
				 JSONArray res1 = JSON.parseArray(result1);
			     System.out.println(result1);			    
			     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
					{
						log.info("create_ground_base_info_010:    "+result1);
					} 
			     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10011");			
			}
@Test(description = "T11,创建经营场所下的场地基本信息,is_public_area为空", priority = 0)
public void create_ground_base_info_011() throws Exception{
				CloseableHttpClient client = HttpClients.createDefault();	
				String utcstr = String.valueOf(System.currentTimeMillis()/1000);
				String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "192", "维多利亚多亚"+utcstr, "150", "1", "");
				 JSONArray res1 = JSON.parseArray(result1);
			     System.out.println(result1);			    
			     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
					{
						log.info("create_ground_base_info_011:    "+result1);
					} 
			     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10005");			
			}
@Test(description = "T12,创建经营场所下的场地基本信息,is_public_area为不存在的类型", priority = 0)
public void create_ground_base_info_012() throws Exception{
				CloseableHttpClient client = HttpClients.createDefault();	
				String utcstr = String.valueOf(System.currentTimeMillis()/1000);
				String result1 =bissness_field_ground_operate.create_ground_base_info(client, utcstr, "192", "维多利亚多亚"+utcstr, "150", "1", "9");
				 JSONArray res1 = JSON.parseArray(result1);
			     System.out.println(result1);			    
			     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
					{
						log.info("create_ground_base_info_012:    "+result1);
					} 
			     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10005");			
			}



}
