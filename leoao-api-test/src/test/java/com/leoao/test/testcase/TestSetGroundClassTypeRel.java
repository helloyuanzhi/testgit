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

public class TestSetGroundClassTypeRel  extends TestBase{
	SystemLogger log = SystemLogger.getLogger(TestSetGroundClassTypeRel.class);
	
@Test(description = "T1,设置场地绑定的课程业务类型,ground_id存在", priority = 0)
public void set_ground_class_type_rel_001() throws Exception{
					CloseableHttpClient client = HttpClients.createDefault();	
					String utcstr = String.valueOf(System.currentTimeMillis()/1000);
					String result1 =bissness_field_ground_operate.set_ground_class_type_rel(client, utcstr, "1", "[{\"id\":\"9999\",\"name\":\"团课侃侃课卡\"},{\"id\":\"2\",\"name\":\"私家\"}]");
					 JSONArray res1 = JSON.parseArray(result1);
				     System.out.println(result1);			    
				     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
						{
							log.info("set_ground_class_type_rel_001:    "+result1);
						} 
				     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
				}
@Test(description = "T2,设置场地绑定的课程业务类型,ground_id为空", priority = 0)
public void set_ground_class_type_rel_002() throws Exception{
					CloseableHttpClient client = HttpClients.createDefault();	
					String utcstr = String.valueOf(System.currentTimeMillis()/1000);
					String result1 =bissness_field_ground_operate.set_ground_class_type_rel(client, utcstr, "", "[{\"id\":\"9999\",\"name\":\"团课侃侃课卡\"},{\"id\":\"1\",\"name\":\"私教侃侃坎坎坷坷坎坎坷坷\"}]");
					 JSONArray res1 = JSON.parseArray(result1);
				     System.out.println(result1);			    
				     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
						{
							log.info("set_ground_class_type_rel_002:    "+result1);
						} 
				     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");			
				}
@Test(description = "T3,设置场地绑定的课程业务类型,ground_id为不存在的值", priority = 0)
public void set_ground_class_type_rel_003() throws Exception{
					CloseableHttpClient client = HttpClients.createDefault();	
					String utcstr = String.valueOf(System.currentTimeMillis()/1000);
					String result1 =bissness_field_ground_operate.set_ground_class_type_rel(client, utcstr, "0","[{\"id\":\"9999\",\"name\":\"团课侃侃课卡\"},{\"id\":\"2\",\"name\":\"私教侃侃坎坎坷坷坎坎坷坷\"}]");
					 JSONArray res1 = JSON.parseArray(result1);
				     System.out.println(result1);			    
				     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
						{
							log.info("set_ground_class_type_rel_003:    "+result1);
						} 
				     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10020");			
				}

@Test(description = "T4,设置场地绑定的课程业务类型,id为空", priority = 0)
public void set_ground_class_type_rel_004() throws Exception{
					CloseableHttpClient client = HttpClients.createDefault();	
					String utcstr = String.valueOf(System.currentTimeMillis()/1000);
					String result1 =bissness_field_ground_operate.set_ground_class_type_rel(client, utcstr, "","[{\"id\":\"9999\",\"name\":\"团课侃侃课卡\"},{\"id\":\"2\",\"name\":\"私教侃侃坎坎坷坷坎坎坷坷\"}]");
					 JSONArray res1 = JSON.parseArray(result1);
				     System.out.println(result1);			    
				     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
						{
							log.info("set_ground_class_type_rel_004:    "+result1);
						} 
				     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
				}
@Test(description = "T5,设置场地绑定的课程业务类型,id为999，第2个id 为空为一个对象", priority = 0)
public void set_ground_class_type_rel_005() throws Exception{
					CloseableHttpClient client = HttpClients.createDefault();	
					String utcstr = String.valueOf(System.currentTimeMillis()/1000);
					//"[{\"id\":\"9999\",\"name\":\"团课侃侃课卡\"},{\"id\":\"\",\"name\":\"私教侃侃坎坎坷坷坎坎坷坷\"}]"
					String result1 =bissness_field_ground_operate.set_ground_class_type_rel(client, utcstr, "1", "[{\"id\":\"9999\",\"name\":\"团课侃侃课卡\"},{\"id\":\"\",\"name\":\"私教侃侃坎坎坷坷坎坎坷坷\"}]");
					 JSONArray res1 = JSON.parseArray(result1);
				     System.out.println(result1);			    
				     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
						{
							log.info("set_ground_class_type_rel_005:    "+result1);
						} 
				     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
				}
@Test(description = "T6,设置场地绑定的课程业务类型,id为999，第2个id 为空为一个对象", priority = 0)
public void set_ground_class_type_rel_006() throws Exception{
					CloseableHttpClient client = HttpClients.createDefault();	
					String utcstr = String.valueOf(System.currentTimeMillis()/1000);
					String result1 =bissness_field_ground_operate.set_ground_class_type_rel(client, utcstr, "1", "[{\"id\":\"9999\",\"name\":\"团课侃侃课卡\"},{\"id\":\"\",\"name\":\"私教课程服务名称123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890\"}]");
					 JSONArray res1 = JSON.parseArray(result1);
				     System.out.println(result1);			    
				     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
						{
							log.info("set_ground_class_type_rel_006:    "+result1);
						} 
				     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
				}

}
