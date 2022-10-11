package scenerios;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWindows {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement mobile = driver.findElement(By.xpath("//div[@id=\"nav-xshop\"]//a[@href=\"/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles\"]"));
		Thread.sleep(1500);
		Actions ac=new Actions(driver);
		ac.contextClick(mobile).perform();

		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement book = driver.findElement(By.xpath("//div[@id=\"nav-xshop\"]//a[@href=\"/Books/b/?ie=UTF8&node=976389031&ref_=nav_cs_books\"]"));
		ac.contextClick(book).perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement deal_of_the_day = driver.findElement(By.xpath("//div[@id=\"nav-xshop\"]//a[@href=\"/deals?ref_=nav_cs_gb\"]"));
		ac.contextClick(deal_of_the_day).perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		String parent_WH = driver.getWindowHandle();
		System.out.println(parent_WH);
		Set<String> all_WH = driver.getWindowHandles();
		System.out.println("total window are :"+all_WH.size());

		for (String one_id : all_WH) {
			Thread.sleep(3000);
			
			String title=driver.switchTo().window(one_id).getTitle();
			System.out.println(driver.getTitle());
//			if(title.equals("Book Store Online : Buy Books Online at Best Prices in India | Books Shopping @ Amazon.in"))
//			{
//				break;
//			}
		}
		WebElement bookOption = driver.findElement(By.className("nav-search-facade"));
		if(bookOption.isDisplayed()) {
			System.out.println("switched to books page");
		}
		driver.quit();
	}
}
