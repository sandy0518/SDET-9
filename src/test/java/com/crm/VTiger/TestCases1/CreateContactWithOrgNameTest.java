package com.crm.VTiger.TestCases1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrgNameTest {

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
		
		ExcelFileUtility eFU=new ExcelFileUtility();
		String fNameType = eFU.readDataFromExcelFile("sheet1", 7, 3);
		String fName = eFU.readDataFromExcelFile("sheet1", 7, 1);
		String lName = eFU.readDataFromExcelFile("sheet1", 7, 2);
		String orgName = eFU.readDataFromExcelFile("sheet1", 1, 1);
		
		driver.get(uRL);
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys(uName);
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys(pWD);
		WebElement loginButton = driver.findElement(By.id("submitButton"));
		loginButton.click();
		
		WebElement conButton = driver.findElement(By.linkText("Contacts"));
		conButton.click();
		WebElement plusButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		plusButton.click();
		
		WebElement fNameDD = driver.findElement(By.name("salutationtype"));
		wdu.selectByValue(fNameDD, fNameType);
		
		WebElement fNameTF = driver.findElement(By.name("firstname"));
		fNameTF.sendKeys(fName);
		
		WebElement lNameTF = driver.findElement(By.name("lastname"));
		lNameTF.sendKeys(lName);
		
		WebElement addOrgButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']"));
		addOrgButton.click();
		
		String parentWindow = wdu.getParentHandle();
		wdu.allHandles(parentWindow);
		
		WebElement searchTF = driver.findElement(By.name("search_text"));
		searchTF.sendKeys(orgName);
		
		WebElement searchButton = driver.findElement(By.xpath("//input[@type='button']"));
		searchButton.click();
		
		Thread.sleep(3000);
		
		WebElement selectOrg = driver.findElement(By.id("1"));
		selectOrg.click();
		
		wdu.allHandles(parentWindow);
		
		WebElement saveButton = driver.findElement(By.name("button"));
		saveButton.click();

		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wdu.mouseOverAction(adminImg);
		WebElement signOut = driver.findElement(By.linkText("Sign Out"));
		signOut.click();
		
		driver.close();
	}
}
