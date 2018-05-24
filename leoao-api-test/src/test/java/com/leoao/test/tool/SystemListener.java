package com.leoao.test.tool;

import java.util.HashMap;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SystemListener implements ITestListener {
	private static Map<String, Boolean> testmethodsstartmap = new HashMap<String, Boolean>();
	private static Map<String, Boolean> testmethodsendmap = new HashMap<String, Boolean>();
	private SystemLogger logger;
	
	public SystemListener() {
		super();

		this.logger = SystemLogger.getLogger(SystemListener.class);
	}

	public void onTestSuccess(ITestResult tr) {
		logTestEnd(tr, "Success");
	}

	public void onTestFailure(ITestResult tr) {
		logTestEnd(tr, "Failed");
	}

	public void onTestSkipped(ITestResult tr) {
		logTestEnd(tr, "Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult tr) {
		logTestEnd(tr, "FailedButWithinSuccessPercentage");
	}

	public void onTestStart(ITestResult result) {
		logTestStart(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	protected void logTestEnd(ITestResult tr, String result) {
		if (!testmethodsendmap.containsKey(tr.getName())) {
			testmethodsendmap.put(tr.getName(), false);
		}

		if (!testmethodsendmap.get(tr.getName())) {
			this.logger.info(String.format("===========Result: %s===========",
					result));
			testmethodsendmap.put(tr.getName(), true);
		}
	}

	protected void logTestStart(ITestResult tr) {	
		if (!testmethodsstartmap.containsKey(tr.getName())) {
			testmethodsstartmap.put(tr.getName(), false);
		}

		if (!testmethodsstartmap.get(tr.getName())) {
			this.logger.info(String.format("===========Run: %s=============",
					tr.getMethod()));
			testmethodsstartmap.put(tr.getName(), true);
		}
	}
}
