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

public class TestUpdateBaseInfo extends TestBase{
	SystemLogger log = SystemLogger.getLogger(TestUpdateBaseInfo.class);
	
@Test(description = "T1,设置场地绑定的课程业务类型,ground_id存在", priority = 0)
public void update_ground_base_info_001() throws Exception{
						CloseableHttpClient client = HttpClients.createDefault();	
						String utcstr = String.valueOf(System.currentTimeMillis()/1000);
						String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "1", "维多利亚多亚001", "180", "0","1");
						 JSONArray res1 = JSON.parseArray(result1);
					     System.out.println(result1);			    
					     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
							{
								log.info("update_ground_base_info_001:    "+result1);
							} 
					     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
					}
@Test(description = "T2,设置场地绑定的课程业务类型,ground_id存在", priority = 0)
public void update_ground_base_info_002() throws Exception{
						CloseableHttpClient client = HttpClients.createDefault();	
						String utcstr = String.valueOf(System.currentTimeMillis()/1000);
						String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "2", "维多利亚多亚001", "180", "0","1");
						 JSONArray res1 = JSON.parseArray(result1);
					     System.out.println(result1);			    
					     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
							{
								log.info("update_ground_base_info_002:    "+result1);
							} 
					     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10012");			
					}
@Test(description = "T3,设置场地绑定的课程业务类型,ground_id为空", priority = 0)
public void update_ground_base_info_003() throws Exception{
						CloseableHttpClient client = HttpClients.createDefault();	
						String utcstr = String.valueOf(System.currentTimeMillis()/1000);
						String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "", "维多利亚多亚001", "180", "0","1");
						 JSONArray res1 = JSON.parseArray(result1);
					     System.out.println(result1);			    
					     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
							{
								log.info("update_ground_base_info_003:    "+result1);
							} 
					     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");			
					}
@Test(description = "T4,设置场地绑定的课程业务类型,ground_id为不存在的值", priority = 0)
public void update_ground_base_info_004() throws Exception{
						CloseableHttpClient client = HttpClients.createDefault();	
						String utcstr = String.valueOf(System.currentTimeMillis()/1000);
						String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "0", "维多利亚多亚001", "180", "0","1");
						 JSONArray res1 = JSON.parseArray(result1);
					     System.out.println(result1);			    
					     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
							{
								log.info("update_ground_base_info_004:    "+result1);
							} 
					     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10021");			
}
@Test(description = "T5,设置场地绑定的课程业务类型,ground_name为空，不修改", priority = 0)
public void update_ground_base_info_005() throws Exception{
						CloseableHttpClient client = HttpClients.createDefault();	
						String utcstr = String.valueOf(System.currentTimeMillis()/1000);
						String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "1", "", "180", "0","1");
						 JSONArray res1 = JSON.parseArray(result1);
					     System.out.println(result1);			    
					     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
							{
								log.info("update_ground_base_info_005:    "+result1);
							} 
					     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
}

@Test(description = "T6,设置场地绑定的课程业务类型,ground_name为空含特色字符，截断保存", priority = 0)
public void update_ground_base_info_006() throws Exception{
						CloseableHttpClient client = HttpClients.createDefault();	
						String utcstr = String.valueOf(System.currentTimeMillis()/1000);
						String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "1", "教室活动👌侃侃课️", "180", "0","1");
						 JSONArray res1 = JSON.parseArray(result1);
					     System.out.println(result1);			    
					     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
							{
								log.info("update_ground_base_info_006:    "+result1);
							} 
					     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
}
@Test(description = "T7,设置场地绑定的课程业务类型,usable_area为空，却修改", priority = 0)
public void update_ground_base_info_007() throws Exception{
						CloseableHttpClient client = HttpClients.createDefault();	
						String utcstr = String.valueOf(System.currentTimeMillis()/1000);
						String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "2", "教室活动"+utcstr, "", "0","1");
						 JSONArray res1 = JSON.parseArray(result1);
					     System.out.println(result1);			    
					     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
							{
								log.info("update_ground_base_info_007:    "+result1);
							} 
					     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
}
@Test(description = "T8,设置场地绑定的课程业务类型,usable_area为超过10000", priority = 0)
public void update_ground_base_info_008() throws Exception{
						CloseableHttpClient client = HttpClients.createDefault();	
						String utcstr = String.valueOf(System.currentTimeMillis()/1000);
						String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "2", "教室活动"+utcstr, "10001", "0","1");
						 JSONArray res1 = JSON.parseArray(result1);
					     System.out.println(result1);			    
					     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
							{
								log.info("update_ground_base_info_008:    "+result1);
							} 
					     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10003");			
}
@Test(description = "T8,设置场地绑定的课程业务类型,ground_name为超过64位", priority = 0)
public void update_ground_base_info_009() throws Exception{
						CloseableHttpClient client = HttpClients.createDefault();	
						String utcstr = String.valueOf(System.currentTimeMillis()/1000);
						String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "2", "教室活动1234567890123456789012345678901234567890123456789012345678901", "100", "0","1");
						 JSONArray res1 = JSON.parseArray(result1);
					     System.out.println(result1);			    
					     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
							{
								log.info("update_ground_base_info_009:    "+result1);
							} 
					     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10002");			
}
@Test(description = "T10,设置场地绑定的课程业务类型,is_public_area为空", priority = 0)
public void update_ground_base_info_010() throws Exception{
						CloseableHttpClient client = HttpClients.createDefault();	
						String utcstr = String.valueOf(System.currentTimeMillis()/1000);
						String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "2", "教室活动"+String.valueOf(System.currentTimeMillis()), "100", "","1");
						 JSONArray res1 = JSON.parseArray(result1);
					     System.out.println(result1);			    
					     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
							{
								log.info("update_ground_base_info_010 :    "+result1);
							} 
					     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10002");			
}
@Test(description = "T11,设置场地绑定的课程业务类型,is_public_area为5", priority = 0)
public void update_ground_base_info_011() throws Exception{
						CloseableHttpClient client = HttpClients.createDefault();	
						String utcstr = String.valueOf(System.currentTimeMillis()/1000);
						String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "2", "教室活动"+String.valueOf(System.currentTimeMillis()), "100", "5","1");
						 JSONArray res1 = JSON.parseArray(result1);
					     System.out.println(result1);			    
					     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
							{
								log.info("update_ground_base_info_011:    "+result1);
							} 
					     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10005");			
}
@Test(description = "T12,设置场地绑定的课程业务类型,area_type为5", priority = 0)
public void update_ground_base_info_012() throws Exception{
						CloseableHttpClient client = HttpClients.createDefault();	
						String utcstr = String.valueOf(System.currentTimeMillis()/1000);
						String result1 =bissness_field_ground_operate.update_ground_base_info(client, utcstr, "2", "教室活动"+String.valueOf(System.currentTimeMillis()), "100", "1","5");
						 JSONArray res1 = JSON.parseArray(result1);
					     System.out.println(result1);			    
					     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
							{
								log.info("update_ground_base_info_012:    "+result1);
							} 
					     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10011");			
}


}
