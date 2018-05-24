package com.leoao.test.testcase;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.leoao.test.common.TestBase;
import com.leoao.test.field.bissness_city_operate;
import com.leoao.test.tool.Assertrename;
import com.leoao.test.tool.SystemLogger;

public class TestRemoveCity extends TestBase{
	SystemLogger log = SystemLogger.getLogger(TestRemoveCity.class);
	@Test(description = "T1,从开放业务城市中移除一个城市,city_id存在", priority = 0)
	public void remove_city_001() throws Exception{
							CloseableHttpClient client = HttpClients.createDefault();	
							String utcstr = String.valueOf(System.currentTimeMillis()/1000);
							String result1 =bissness_city_operate.remove_city(client, utcstr, "12598");
							 JSONArray res1 = JSON.parseArray(result1);
						     System.out.println(result1);			    
						     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
								{
									log.info("remove_city_001:    "+result1);
								} 
						     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");			
						}
	@Test(description = "T2,从开放业务城市中移除一个城市,city_id为空", priority = 0)
	public void remove_city_002() throws Exception{
							CloseableHttpClient client = HttpClients.createDefault();	
							String utcstr = String.valueOf(System.currentTimeMillis()/1000);
							String result1 =bissness_city_operate.remove_city(client, utcstr, "");
							 JSONArray res1 = JSON.parseArray(result1);
						     System.out.println(result1);			    
						     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
								{
									log.info("remove_city_002:    "+result1);
								} 
						     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");			
						}

	@Test(description = "T3,从开放业务城市中移除一个城市,city_id为中文字", priority = 0)
	public void remove_city_003() throws Exception{
							CloseableHttpClient client = HttpClients.createDefault();	
							String utcstr = String.valueOf(System.currentTimeMillis()/1000);
							String result1 =bissness_city_operate.remove_city(client, utcstr, "中文98");
							 JSONArray res1 = JSON.parseArray(result1);
						     System.out.println(result1);			    
						     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
								{
									log.info("remove_city_003:    "+result1);
								} 
						     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");			
						}
	
}
