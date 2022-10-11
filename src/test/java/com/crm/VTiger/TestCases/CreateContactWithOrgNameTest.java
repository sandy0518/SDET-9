package com.crm.VTiger.TestCases;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrgNameTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");
		WebElement loginButton = driver.findElement(By.id("submitButton"));
		loginButton.click();
		
		WebElement conButton = driver.findElement(By.linkText("Contacts"));
		conButton.click();
		WebElement plusButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		plusButton.click();
		
		WebElement fNameType = driver.findElement(By.name("salutationtype"));
		Select select=new Select(fNameType);
		select.selectByValue("Mr.");
		
		WebElement fNameTF = driver.findElement(By.name("firstname"));
		fNameTF.sendKeys("mukesh");
		
		WebElement lNameTF = driver.findElement(By.name("lastname"));
		lNameTF.sendKeys("ambani");
		
		WebElement addOrgButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']"));
		addOrgButton.click();
		
//		String parentWindow = wdu.getParentHandle();
		String parentWindow = driver.getWindowHandle();
		
		Set<String> allHandles = driver.getWindowHandles();
		for(String aH:allHandles) {
			driver.switchTo().window(aH);
		}
		
		WebElement searchTF = driver.findElement(By.name("search_text"));
		searchTF.sendKeys("Testyantra Organisation");
		
		WebElement searchButton = driver.findElement(By.xpath("//input[@type='button']"));
		searchButton.click();
		
		Thread.sleep(3000);
		
		WebElement selectOrg = driver.findElement(By.id("1"));
		selectOrg.click();

		driver.switchTo().window(parentWindow);
		
		WebElement saveButton = driver.findElement(By.name("button"));
		saveButton.click();
		
		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action=new Actions(driver);
		action.moveToElement(adminImg).perform();
		WebElement signOut = driver.findElement(By.linkText("Sign Out"));
		signOut.click();
		
		driver.close();
	
	}
}
