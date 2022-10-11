package com.crm.VTiger.TestCases;

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
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationWithIndTypeTest {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");

		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");
		WebElement loginButton = driver.findElement(By.id("submitButton"));
		loginButton.click();

		String orgName="TestYantra Organisation";

		WebElement orgButton = driver.findElement(By.linkText("Organizations"));
		orgButton.click();
		WebElement plusButton = driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']"));
		plusButton.click();

		WebElement orgNameTF = driver.findElement(By.name("accountname"));
		orgNameTF.sendKeys(orgName);

		WebElement indDD = driver.findElement(By.name("industry"));
		Select select1 = new Select(indDD);
		select1.selectByValue("Biotechnology");

		WebElement saveButton = driver.findElement(By.name("button"));
		saveButton.click();

		String orgHeader = driver.findElement(By.className("dvHeaderText")).getText();

		if (orgHeader.contains(orgName)) {
			System.out.println("Validated successfully");
		} else {
			System.out.println("Not validated ");
		}
		Thread.sleep(3000);

		WebElement adminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions action = new Actions(driver);
		action.moveToElement(adminImg).perform();
		WebElement signOut = driver.findElement(By.linkText("Sign Out"));
		signOut.click();

		driver.close();
	}
}
