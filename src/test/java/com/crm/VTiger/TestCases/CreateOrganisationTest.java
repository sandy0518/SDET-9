package com.crm.VTiger.TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationTest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888");
		String orgName="TestYantra Organisation5684";
		
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");
		WebElement loginButton = driver.findElement(By.id("submitButton"));
		loginButton.click();
		
		WebElement orgButton = driver.findElement(By.linkText("Organizations"));
		orgButton.click();
		
		WebElement plusButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		plusButton.click();
		
		WebElement orgNameTF = driver.findElement(By.name("accountname"));
		orgNameTF.sendKeys(orgName);
		
		WebElement saveButton = driver.findElement(By.name("button"));
		saveButton.click();
		
		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action =new Actions(driver);
		action.moveToElement(adminImg).perform();
		WebElement signOut = driver.findElement(By.linkText("Sign Out"));
		signOut.click();

		driver.close();
	}

}
