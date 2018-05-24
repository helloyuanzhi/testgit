package com.leoao.test.common;


public class ConfigModel {
	public static String host;
	public static String devhost;
	public static String db_ms_test;
	public static String testhost;
	public static String classhost;
	
	public static String getHost(String host) {
		
		return host;
	}

	public static void setHost(String host) {
		ConfigModel.classhost = host;
		
	}
	
	
	public static String getHost(String devhost,String dev) {
		
		return devhost;
		
	}

	public static void setHost(String devhost,String dev) {
		
		ConfigModel.devhost = devhost;
	}
	
	public static void setdbhost(String db_ms_test) {
		ConfigModel.db_ms_test = db_ms_test;
	}
	
	public static String getdbhost() {
		return db_ms_test;
	}
	
	


	

}
