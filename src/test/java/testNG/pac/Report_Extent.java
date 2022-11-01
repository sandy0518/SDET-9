package testNG.pac;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Report_Extent 
{

	ExtentSparkReporter reporter ;
	ExtentReports reports;
	ExtentTest test;

	@Test
	public void createReport() throws IOException, InterruptedException {

		reporter = new ExtentSparkReporter("./Screenshot/SDET11.html");
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

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path= "./Screenshot/Fb1.png";
		File dest = new File(path);	
		Files.copy(src, dest);

		Thread.sleep(2000);
		test.addScreenCaptureFromPath(path);
	

		Assert.assertEquals(true, true);





	}

	@AfterSuite
	public void as() {
		reports.flush();
	}

}
