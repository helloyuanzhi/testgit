package com.leoao.test.common;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.leoao.test.tool.SystemListener;


/**
 * Created by jinhua on 5/5/17.
 */
@Listeners({ SystemListener.class })
public class TestBase {

	
	public static String classhost = "";
	public static String devhost = "";
	public static String db_ms_test ="";
	public static String class1host = "";
	
	@BeforeMethod
	@BeforeTest
	protected void setUp() throws Exception {
		
	InputStream inputStream = this.getClass().getClassLoader()
			.getResourceAsStream("./config/config.properties");

	Properties p = new Properties();
	try {
		p.load(inputStream);
		String env = p.getProperty("envIs");
		
		if (env.equals("TEST")) {

			classhost = p.getProperty("classHost");
			ConfigModel.setHost(classhost);
		//	System.out.println(host);
			devhost = p.getProperty("devHost");
			ConfigModel.setHost(devhost,devhost);
		//	class1host = p.getProperty("class1Host");
		//	ConfigModel.setHost(class1host,class1host);
			
		//	devhost = p.getProperty("devHost");
		//	ConfigModel.setHost(devhost,devhost);
			db_ms_test = p.getProperty("db_ms_test");
			ConfigModel.setdbhost(db_ms_test);
			
			
		} else
			throw new Exception("出现异常");

	} catch (IOException e) {
		e.printStackTrace();
	}
	}

	public static void main(String[] args) throws Exception {
		TestBase test = new TestBase();
		test.setUp();
	}
	
}
