package generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Result implements ITestListener,IAutoConst{

	static int passCount=0, failCount=0; //skipCount=0;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//below code is working fine but i commented bcoz it is coming 2 times
		//String name = result.getName();	
		//Reporter.log("Test "+name+" is pass", true);
		passCount++;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//below code is working fine but i commented bcoz it is coming 2 times
		//String name = result.getName();	
		//Reporter.log("Test "+name+" is fail", true);
		failCount++;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//skipCount++;
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		//below code is working fine but i commented bcoz it is coming 2 times
		//Reporter.log("pass:"+passCount,true);
		//Reporter.log("fail:"+failCount,true);
		Utility.writeResultToXL(SUMMARY_PATH,"sheet1", passCount, failCount);
	}

}
