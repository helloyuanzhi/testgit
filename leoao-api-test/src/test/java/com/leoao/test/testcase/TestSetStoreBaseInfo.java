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

public class TestSetStoreBaseInfo extends TestBase{
	static SystemLogger log = SystemLogger.getLogger(TestSetStoreBaseInfo.class);	
@Test(description = "T1,完整信息，更新经营场所的基本信息", priority = 0)
public void set_store_base_info_001() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_base_info(client, utcstr, "190","test04侃侃课卡", "1", "杭州市西溪路525号", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5","");
		JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_base_info_001:    "+result1);
			} 
	     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");
		
			
	}
@Test(description = "T2,经营场所store_id不存在", priority = 0)
public void set_store_base_info_002() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_base_info(client, utcstr, "0","test04侃侃课卡", "1", "杭州市西溪路525号", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5","1234");
		JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_base_info_002:    "+result1);
			} 
	     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10025");
		
			
	}
@Test(description = "T3,store_id为空", priority = 0)
public void set_store_base_info_003() throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();	
		String utcstr = String.valueOf(System.currentTimeMillis()/1000);
		String result1 =bissness_field_store_operate.set_store_base_info(client, utcstr, "","test04侃侃课卡", "1", "杭州市西溪路525号", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5","1234");
		JSONArray res1 = JSON.parseArray(result1);
	     System.out.println(result1);
	    
	     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
			{
				log.info("set_store_base_info_003:    "+result1);
			} 
	     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
	     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10014");
		
			
	}

	
	
	

}
