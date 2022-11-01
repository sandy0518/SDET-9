package testNG.pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Report_Extent 
{

	ExtentSparkReporter reporter ;
	ExtentReports reports;
	ExtentTest test;

	@Test
	public void createReport() {

		reporter = new ExtentSparkReporter("./ExtentReports/SDET10.html");
		reporter.config().setDocumentTitle("NEW FB");
		reporter.config().setTheme(Theme.STANDARD);

		reports= new ExtentReports();
		reports.attachReporter(reporter);

		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Build", "10.3.5");
		reports.setSystemInfo("Reporter Name", "Pavan");
		reports.setSystemInfo("Env", "QA");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://facebook.com");

		test=	reports.createTest("FB_2");
		
		Assert.assertEquals(true, true);





	}

	@AfterSuite
	public void as() {
		reports.flush();
	}

}
