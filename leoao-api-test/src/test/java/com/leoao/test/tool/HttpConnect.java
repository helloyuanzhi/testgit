package com.leoao.test.tool;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;

import java.util.Iterator;
import java.util.Map;




import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.ByteArrayPartSource;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;




//import common.debug.AlertReport;



public class HttpConnect  {
	


	
	public static String sendPost(String url,Map<String,Object> params,
			Map<String,String> files){
		HttpClient client = new HttpClient();
		
		PostMethod postMethod = new PostMethod(url);
		try{
			if (files != null && files.size() > 0){
				Part[] parts;
				parts = new Part[params.size() + files.size()];
				Iterator<String> iters = params.keySet().iterator();
				int i = 0;
				while(iters.hasNext())
				{
					String key = (String)iters.next();
					parts[i] = new StringPart(key,params.get(key).toString(),"UTF-8");
					i++;
				}
				iters = files.keySet().iterator();
				while(iters.hasNext()){
					String key = (String)iters.next();
					if (files.get(key).toString().startsWith("http://"))
					{
						InputStream bin = null;
						ByteArrayOutputStream bout = new ByteArrayOutputStream();
						
						try
						{
							URL fileurl = new URL(files.get(key).toString());
							bin = fileurl.openStream();
							
							byte[] buf = new byte[500];
							int count = 0;
							
							while((count = bin.read(buf)) > 0)
							{
								bout.write(buf,0,count);
							}
							
							parts[i] = new FilePart(key,
									new ByteArrayPartSource(fileurl.getFile().substring(fileurl.getFile().lastIndexOf("/")+1)
											,bout.toByteArray()));
							
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
						finally
						{
							if (bin != null)
								bin.close();
							
							if (bout != null)
								bout.close();
						}
					}
					else
						parts[i] = new FilePart(key,new File(files.get(key).toString()));
					i++;
				}
				
				postMethod.setRequestEntity(new MultipartRequestEntity(parts,postMethod.getParams()));
			}
			else{
				NameValuePair[] postData;
				
				if (params != null){
					postData = new NameValuePair[params.size()]; 
					Iterator<String> iters = params.keySet().iterator();
					int i = 0;
					
					while(iters.hasNext()){
						String key = (String)iters.next();
						if (params.get(key) == null)					
							postData[i] = new NameValuePair(key,null); 	
						else
						{
							postData[i] = new NameValuePair(key, params.get(key).toString());
						}
						i++;
					}
				
					postMethod.setRequestBody(postData);
				}
				postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			}
			client.executeMethod(postMethod);
	
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			byte[] rsp = null;
			try
			{
				InputStream in = postMethod.getResponseBodyAsStream();
				
				byte[] buf = new byte[500];
				int count = 0;
				
				while((count = in.read(buf)) > 0)
				{
					bout.write(buf,0,count);
				}
				
				
				rsp = bout.toByteArray();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				if (bout != null)
					bout.close();
			}
			String status = String.valueOf(postMethod.getStatusCode());
			//System.out.println(status);
			//return new String(rsp,"UTF-8");
			return "[{\"status\":\"" + status + "\"}," + new String(rsp,"UTF-8")+"]";
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if (postMethod != null)
				postMethod.releaseConnection();
		}
		return "error";
	}
	
	
	
	public static String download (String url,String filePath,Map<String,Object> params) throws HttpException, IOException{
		HttpClient client = new HttpClient();
		PostMethod postMethod = new PostMethod(url);
		NameValuePair[] postData;
		
		if (params != null){
			postData = new NameValuePair[params.size()]; 
			Iterator<String> iters = params.keySet().iterator();
			int i = 0;
			
			while(iters.hasNext()){
				String key = (String)iters.next();
				if (params.get(key) == null)					//
					postData[i] = new NameValuePair(key,null); 	//
				else
					postData[i] = new NameValuePair(key,params.get(key).toString());
				i++;
			}
			postMethod.setRequestBody(postData);
		}
		postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		
	
		client.executeMethod(postMethod);
		//System.out.println(postMethod.getResponseHeader("Content-Length").getValue());
		File storeFile = new File( filePath);
        FileOutputStream output = new FileOutputStream(storeFile,false);
        // 
        InputStream input = postMethod.getResponseBodyAsStream();
        byte b[] = new byte[1024];
        int j = 0;
        while( (j = input.read(b))!=-1)
        {
        output.write(b,0,j);
        }
        output.flush();
        output.close();
        return postMethod.getResponseHeader("Content-Length").getValue();
      
	}
}
