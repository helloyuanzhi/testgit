package com.leoao.test.testcase;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;
import  com.leoao.test.tool.Assertrename;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.leoao.test.common.TestBase;
import com.leoao.test.field.bissness_field_store_operate;
import com.leoao.test.tool.SystemLogger;

public class TestCreatStoreBaseInfo extends TestBase{
	static SystemLogger log = SystemLogger.getLogger(TestCreatStoreBaseInfo.class);
@Test(description = "T1,完整信息，创建经营场所的基本信息", priority = 0)
public void create_store_base_info_001() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "杭州市西溪路525号", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_001:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");
	
		
}
@Test(description = "T2,重复创建门店", priority = 0)
public void create_store_base_info_002() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店", "1", "杭州市西溪路525号", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_002:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10020");		
}
@Test(description = "T3,Utc时间格式对，值不对", priority = 0)
public void create_store_base_info_003() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr+"100", "乐刻自动门店", "1", "杭州市西溪路525号", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_003:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"903");		
}	
@Test(description = "T4,Utc时间格式不对，是字母", priority = 0)
public void create_store_base_info_004() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, "ec", "乐刻自动门店", "1", "杭州市西溪路525号", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_004:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"903");		
}	
@Test(description = "T5,门店没门面，has_face =0", priority = 0)
public void create_store_base_info_005() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "0", "杭州市西溪路525号", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_005:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");		
}
@Test(description = "T6,门店不存在的门面类型，has_face=3", priority = 0)
public void create_store_base_info_006() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "3", "杭州市西溪路525号", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_006:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10002");		
}
@Test(description = "T7,经营场所名称超过128个字符", priority = 0)
public void create_store_base_info_007() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店1234123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890", "1", "杭州市西溪路525号", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_007:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10001");		
}
@Test(description = "T8,地址为空值，addr=''", priority = 0)
public void create_store_base_info_008() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "", "西溪路门店001", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_008:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10003");		
}
@Test(description = "T9,摘要简介带特色字符", priority = 0)
public void create_store_base_info_009() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525👌@#¥～？》", "西溪路门店001👌@#¥～？》", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_009:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");		
}
@Test(description = "T10,摘要简介store_abstract为空", priority = 0)
public void create_store_base_info_010() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525👌@#¥～？》", "", "1", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_010:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10004");		
}
@Test(description = "T11,资源类型resources_type为空", priority = 0)
public void create_store_base_info_011() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_011:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10005");		
}
@Test(description = "T12,资源类型resources_type为不存在的类型", priority = 0)
public void create_store_base_info_012() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "111", "2", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_012:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10021");		
}
@Test(description = "T13,物业类型property_type为空", priority = 0)
public void create_store_base_info_013() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_013:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10006");		
}
@Test(description = "T14,物业类型property_type不存在的值", priority = 0)
public void create_store_base_info_014() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "222", "3", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_014:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10022");		
}
@Test(description = "T15,合作模式cooperation_type为空", priority = 0)
public void create_store_base_info_015() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "2", "", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_015:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10007");		
}
@Test(description = "T16,合作模式cooperation_type为不存在的值", priority = 0)
public void create_store_base_info_016() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "2", "333", "1", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_016:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10023");		
}
@Test(description = "T17,营业状态active_status为空", priority = 0)
public void create_store_base_info_017() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "2", "3", "", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_017:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10008");		
}
@Test(description = "T18,营业状态active_status为不存在的值", priority = 0)
public void create_store_base_info_018() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "2", "3", "1111", utcstr, "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_018:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10024");		
}

@Test(description = "T19,开业时间start_business_time为空", priority = 0)
public void create_store_base_info_019() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "2", "3", "1", "", "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_019:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10009");		
}
@Test(description = "T20,开业时间start_business_time不合法", priority = 0)
public void create_store_base_info_020() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "2", "3", "1","er", "30.268661", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_020:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10009");		
}
@Test(description = "T21,纬度lat不传", priority = 0)
public void create_store_base_info_021() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "2", "3", "1",utcstr, "abc当时的", "120.111221", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_021:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");		
}
@Test(description = "T22,纬度lat经度lng传字符串", priority = 0)
public void create_store_base_info_022() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "2", "3", "1",utcstr, "嗯嗯", "的订单", "西先生", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_022:    "+result1);
		} 
     //System.out.println(res1.getJSONObject(1).getJSONObject("status").getString("code"));
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");		
}
/*
@Test(description = "T23,管理负责人name超过32个字符，截断存储", priority = 0)
public void create_store_base_info_023() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "2", "3", "1",utcstr, "30.268661", "120.111221", "西先生123456789012345678901234567890", "13777570336", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_023:    "+result1);
		} 
    
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"00000");		
}
*/
@Test(description = "T24,管理负责人电话phone超过11位", priority = 0)
public void create_store_base_info_024() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "2", "3", "1",utcstr, "30.268661", "120.111221", "西先生", "1377757033", "jinhua@leoao.com", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_024:    "+result1);
		} 
    
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10015");		
}
@Test(description = "T25,管理负责人邮箱email不符合规则", priority = 0)
public void create_store_base_info_025() throws Exception{
	CloseableHttpClient client = HttpClients.createDefault();	
	String utcstr = String.valueOf(System.currentTimeMillis()/1000);
	String result1 =bissness_field_store_operate.create_store_base_info(client, utcstr, "乐刻自动门店"+utcstr, "1", "西溪路525", "西溪路门店001", "1", "2", "3", "1",utcstr, "30.268661", "120.111221", "西先生", "13777570337", "jinhua", "5", "12597", "5");
	 JSONArray res1 = JSON.parseArray(result1);
     System.out.println(result1);
    
     if(Assertrename.assert_equal("200",res1.getJSONObject(0).getString("status"))!=true)
		{
			log.info("create_store_base_info_025:    "+result1);
		} 
    
     Assert.assertEquals(res1.getJSONObject(1).getJSONObject("status").getString("code"),"10016");		
}

	

}
