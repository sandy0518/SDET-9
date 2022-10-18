package testNG.pac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Flipkart {

	static WebDriver driver;
	@Test
	public void flipkart() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://flipkart.com");
		System.out.println(driver.getTitle());

		Assert.assertEquals(false, true);
	}


}
