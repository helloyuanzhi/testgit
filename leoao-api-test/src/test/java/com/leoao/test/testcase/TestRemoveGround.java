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

public class TestRemoveGround extends TestBase{
	SystemLogger log = SystemLogger.getLogger(TestRemoveGround.class);
	
	@Test(description = "T1,删除一个场地,ground_id存在", priority = 0)
	public void remove_ground_001() throws Exception{
							CloseableHttpClient client = HttpClients.createDefault();	
							String utcstr = String.valueOf(System.currentTimeMillis()/1000);
							String result1 =bissness_field_ground_operate.remove_ground(client, utcstr, "7");
							 JSONArray res1 = JSON.parseArray(result1);
						     System.out.println(result1);			    
						     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
								{
									log.info("remove_ground_001:    "+result1);
								} 
						     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
						}

	@Test(description = "T2,删除一个场地,ground_id为空", priority = 0)
	public void remove_ground_002() throws Exception{
							CloseableHttpClient client = HttpClients.createDefault();	
							String utcstr = String.valueOf(System.currentTimeMillis()/1000);
							String result1 =bissness_field_ground_operate.remove_ground(client, utcstr, "");
							 JSONArray res1 = JSON.parseArray(result1);
						     System.out.println(result1);			    
						     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
								{
									log.info("remove_ground_002:    "+result1);
								} 
						     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");			
						}
@Test(description = "T3,删除一个场地,ground_id为中文字母", priority = 0)
public void remove_ground_003() throws Exception{
							CloseableHttpClient client = HttpClients.createDefault();	
							String utcstr = String.valueOf(System.currentTimeMillis()/1000);
							String result1 =bissness_field_ground_operate.remove_ground(client, utcstr, "字符sd");
							 JSONArray res1 = JSON.parseArray(result1);
						     System.out.println(result1);			    
						     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
								{
									log.info("remove_ground_002:    "+result1);
								} 
						     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");			
						}


}
