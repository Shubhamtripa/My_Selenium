package generic_utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportImp implements ITestListener{
ExtentTest test;
ExtentReports report;
	
	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		System.out.println("-------taking Screen Shot----");
		String screenShot = null;
		try {
			screenShot = Web_Driver_Utility.takeScreenShot(Base_Class.sdriver, result.getMethod().getMethodName());
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenShot);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) 
	{
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html"+ranNum);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Vtiger_Report");
		spark.config().setReportName("Shubham");
			
			//system Configuration
		report.attachReporter(spark);
		report.setSystemInfo("platform", "Window10");
		report.setSystemInfo("Reported By ", "Shubham");
		report.setSystemInfo("Reviwed By",	"Shobha Rani");
			
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}
