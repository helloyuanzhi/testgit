package com.leoao.test.tool;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.Statement;


public class mySql  {
	
	 public static Connection getConnection(String url,String host,
			 String username,String password) {  
		 Connection con = null;  //创建用于连接数据库的Connection对象  
	     try{  
	    	 Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
	    	
	    	 con = DriverManager.getConnection(
	    			  url  ,username,password);// 创建数据连接  
	    //	 con = DriverManager.getConnection(
	    	//		 "jdbc:mysql://" + url + "/" + dbName ,username,password);// 创建数据连接  
	    	 
	     } catch (Exception e){
	    	 System.out.println("数据库连接失败" + e.getMessage());  
	     }
	     return con; //返回所建立的数据库连接  
	 }  
	 
	 public static JSONArray query(Connection conn,String sql){	
		 Statement st = null ;
		 JSONArray jArray = new JSONArray();
		 try{
			 st = (Statement) conn.createStatement();
			 ResultSet rs = st.executeQuery(sql);
             ResultSetMetaData rsm = rs.getMetaData();
             Map<String, Object> map = null;
             while (rs.next()) {
                      map = new HashMap<String, Object>();
                      for (int i = 1; i <= rsm.getColumnCount(); i++) {
                                map.put(rsm.getColumnName(i), rs.getObject(rsm.getColumnName(i)));
                      }
                      jArray.add(JSONObject.parseObject(JSONObject.toJSONString(map)));
               
             }
		 } catch (SQLException e) {
			 System.out.println(e.getMessage());  
	     } 
	     return jArray;
	 }
	 
	 public static void update(Connection conn,String sql){
		 Statement st = null ;
		 try{
			 st = (Statement) conn.createStatement();
			 @SuppressWarnings("unused")
			int count = st.executeUpdate(sql);
			// System.out.println(count);
		 }catch (SQLException e) {
			 System.out.println(e.getMessage());  
	     } 
	 }

	
	 
}
