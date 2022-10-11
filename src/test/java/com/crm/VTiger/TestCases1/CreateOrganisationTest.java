package com.crm.VTiger.TestCases1;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationTest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		WebDriverUtility wdu=new WebDriverUtility(driver);
		wdu.maximize();
		wdu.implicitlyWait();

		PropertyFileUtility pFU=new PropertyFileUtility();
		String uRL = pFU.readDataFromPropertyFile("url");
		String uName = pFU.readDataFromPropertyFile("username");
		String pWD = pFU.readDataFromPropertyFile("password");
		
		ExcelFileUtility efu=new ExcelFileUtility();
		String orgName = efu.readDataFromExcelFile("sheet1", 1, 1)+JavaUtility.generateRanNum();
		
		driver.get(uRL);
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(uName);
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(pWD);
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
		Thread.sleep(3000);
		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdu.mouseOverAction(adminImg);
		WebElement signOut = driver.findElement(By.linkText("Sign Out"));
		signOut.click();

		driver.close();
	}

}
