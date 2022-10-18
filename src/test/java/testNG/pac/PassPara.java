package testNG.pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PassPara 
{
	
	WebDriver driver;

	@Parameters("tyss")
	@Test
	public void launchbrowser(String browser)
	{
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		if(browser.equals("firefox"))
		 {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else {
			System.out.println("Invalid respone");
		}
		driver.get("https://facebook.com");
		
		
		
	}
}
