package com.leoao.test.tool;

import org.apache.log4j.Logger;
import org.testng.Reporter;

public class SystemLogger {
	private Logger logger;

	static {
		//PropertyConfigurator.configure("../log4j.properties");
	}

	public static SystemLogger getLogger(Class<?> classname) {
		SystemLogger systemLogger = new SystemLogger();
		systemLogger.logger = Logger.getLogger(classname);
		return systemLogger;
	}

	public void logAndReport(String info) {
		this.info(info);
		Reporter.log(info);
	}

	public void logAndReportStep(int stepnum, String stepinfo) {
		String info = String.format("step<%d>: %s", stepnum, stepinfo);
		this.logAndReport(info);
	}

	public void info(String info) {
		this.logger.info(info);
	}
	
	public void info(int info) {
		this.logger.info(info);
	}

	public void error(String message, Exception e) {
		// TODO Auto-generated method stub
		
	}
}
