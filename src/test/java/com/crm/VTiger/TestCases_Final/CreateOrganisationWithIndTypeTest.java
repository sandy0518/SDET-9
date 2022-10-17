package com.crm.VTiger.TestCases_Final;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ObjectRepository.HomePageClass;
import ObjectRepository.LoginPageClass;
import ObjectRepository.NewOrgPageClass;
import ObjectRepository.OrgPageClass;
import ObjectRepository.organisationInfoPageClass;
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
		
		LoginPageClass lpc=new LoginPageClass(driver);
		lpc.login(uName, pWD);
		
		HomePageClass hpc=new HomePageClass(driver);
		hpc.getOrgButton().click();
		
		OrgPageClass opc =new OrgPageClass(driver);
		opc.getCreOrg().click();

		NewOrgPageClass npc=new NewOrgPageClass(driver);
		npc.orgTF(orgName);
		npc.IndustryDD(indType);

		npc.sButton();

		organisationInfoPageClass oipc=new organisationInfoPageClass(driver);
		
		if (oipc.headT().contains(orgName)) {
			System.out.println("Validated successfully");
		} else {
			System.out.println("Not validated ");
		}
		
		hpc.signOut(driver);

		driver.close();
	}
}
