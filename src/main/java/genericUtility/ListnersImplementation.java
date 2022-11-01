package genericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplementation implements ITestListener {

	ExtentTest test;
	ExtentReports reports;

	public void onTestStart(ITestResult result) 
	{
		test=reports.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, result.getMethod().getMethodName()+ " got passed");
	}

	public void onTestFailure(ITestResult result) {

		String path = BaseClass.takescreenshot(result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getMethod().getMethodName()+ " got Failed" );
		test.log(Status.FAIL, result.getThrowable());

		test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+ " got Skipped" );
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {



	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) 
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReports/Vtiger.html");
		reporter.config().setDocumentTitle("V-TIGER");
		reporter.config().setTheme(Theme.STANDARD);

		reports = new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Build", "10.3.5");
		reports.setSystemInfo("Reporter Name", "Pavan");
		reports.setSystemInfo("Env", "QA");

	}

	public void onFinish(ITestContext context) 
	{
		reports.flush();
	}



}
