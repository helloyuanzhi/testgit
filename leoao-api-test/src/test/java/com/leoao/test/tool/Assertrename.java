package com.leoao.test.tool;



public class Assertrename {

	static int errorCount=0;
	
	
	
	
	public boolean assert_equal(int a,int b){
//		System.out.println("== check  the two int value whether it equal==");
		if(a!=b) {errorCount++;
		return false;
	}else{
		return true;
	}	
		
		
	
	}
	
	public boolean assert_notEqual(int a,int b){
//		System.out.println("== check  the two int value whether not equal==");
		if(a==b) {errorCount++;
		return false;
		}else{
			return true;
		}	
	}
	
	public static boolean assert_equal(String a,String b){
//		System.out.println("== check  the two String value whether it equal==");
		if(!a.equals(b))
			{errorCount++;
			return false;
			}else{
				return true;
			}		
	}
	
	public boolean assert_notEqual(String a,String b){
//		System.out.println("== check  the two int value whether not equal==");
		if(a.equals(b)) {errorCount++;
		return false;
	}else{
		return true;
	}	
	}
	
	public static boolean assert_notNull(Object a){
//		System.out.println("== check whether the object is null==");
		if(a==null){
			errorCount++;
			return false;
		}
		else{
			return true;
		}		
		
	}
	
	
	public boolean assert_isNull(Object a){
//		System.out.println("== check whether the object is null==");
		if(a!=null){errorCount++;
		return false;
	}else{
		return true;
	}	
	}
	
	
	public boolean assert_true(boolean a){
//		System.out.println("== check whether the object is true==");
		if(!a){errorCount++;
		return false;
	}else{
		return true;
	}	
	}
	
	public int get(){
		
		return errorCount;
	}
	
	
	
	
	 public void reset() {
		  errorCount = 0;
		 }
}
