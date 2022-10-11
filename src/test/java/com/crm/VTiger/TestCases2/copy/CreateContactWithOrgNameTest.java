package com.crm.VTiger.TestCases2.copy;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ObjectRepository.ConPageClass;
import ObjectRepository.HomePageClass;
import ObjectRepository.LoginPageClass;
import ObjectRepository.NewConPageClass;
import ObjectRepository.NewOrgPageClass;
import ObjectRepository.OrgPageClass;
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
		
		LoginPageClass lpc=new LoginPageClass(driver);
		lpc.login(uName, pWD);
		
		HomePageClass hpc=new HomePageClass(driver);
		hpc.getConButton().click();
		
		ConPageClass cpc=new ConPageClass(driver);
		cpc.clickonPB();

		NewConPageClass ncp=new NewConPageClass(driver);
		ncp.fNDD(fNameType);
		ncp.fandLastName(fName, lName);

		ncp.getOrgButton().click();

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

		hpc.signOut(driver);
		
		driver.close();
	}
}
