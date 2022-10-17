package com.crm.VTiger.TestCases_Final;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ObjectRepository.ConPageClass;
import ObjectRepository.HomePageClass;
import ObjectRepository.NewConPageClass;
import genericUtility.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.WebDriverUtility;

public class CreateContactWithOrgNameTest extends BaseClass {

	@Test
	public void createContactWithOrg() throws Throwable 
	{
		ExcelFileUtility eFU=new ExcelFileUtility();
		String fNameType = eFU.readDataFromExcelFile("sheet1", 7, 3);
		String fName = eFU.readDataFromExcelFile("sheet1", 7, 1);
		String lName = eFU.readDataFromExcelFile("sheet1", 7, 2);
		String orgName = eFU.readDataFromExcelFile("sheet1", 1, 1);

		HomePageClass hpc=new HomePageClass(driver);
		WebDriverUtility  webDriverUtility = new WebDriverUtility(driver);
		hpc.getConButton().click();

		ConPageClass cpc=new ConPageClass(driver);
		cpc.clickonPB();

		NewConPageClass ncp=new NewConPageClass(driver);
		ncp.fNDD(fNameType);
		ncp.fandLastName(fName, lName);

		ncp.getOrgButton().click();

		String parentWindow = webDriverUtility.getParentHandle();
		webDriverUtility.allHandles(parentWindow);

		WebElement searchTF = driver.findElement(By.name("search_text"));
		searchTF.sendKeys(orgName);

		WebElement searchButton = driver.findElement(By.xpath("//input[@type='button']"));
		searchButton.click();

		Thread.sleep(3000);

		WebElement selectOrg = driver.findElement(By.id("1"));
		selectOrg.click();

		webDriverUtility.allHandles(parentWindow);

		WebElement saveButton = driver.findElement(By.name("button"));
		saveButton.click();
	}
}
