package com.crm.VTiger.TestCases1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationWithIndTypeTest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebDriverUtility wdu=new WebDriverUtility(driver);
		wdu.maximize();
		wdu.implicitlyWait();
		
		PropertyFileUtility pFU=new PropertyFileUtility();
		String uRL = pFU.readDataFromPropertyFile("url");
		String uName = pFU.readDataFromPropertyFile("username");
		String pWD = pFU.readDataFromPropertyFile("password");
		
		ExcelFileUtility eFU=new ExcelFileUtility();
		String orgName = eFU.readDataFromExcelFile("sheet1", 4, 1)+JavaUtility.generateRanNum();
		String indType = eFU.readDataFromExcelFile("sheet1", 4, 2);
		
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

		WebElement indDD = driver.findElement(By.name("industry"));
		wdu.selectByValue(indDD, indType);

		WebElement saveButton = driver.findElement(By.name("button"));
		saveButton.click();

		String orgHeader = driver.findElement(By.className("dvHeaderText")).getText();

		if (orgHeader.contains(orgName)) {
			System.out.println("Validated successfully");
		} else {
			System.out.println("Not validated ");
		}

		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdu.mouseOverAction(adminImg);
		WebElement signOut = driver.findElement(By.linkText("Sign Out"));
		signOut.click();

		driver.close();
	}
}
