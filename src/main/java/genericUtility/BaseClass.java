package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepository.HomePageClass;
import ObjectRepository.LoginPageClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;
	public static WebDriver sdriver;
	PropertyFileUtility propertyFileUtility = new PropertyFileUtility();


	@BeforeSuite
	public void dataBaseConnection() {
		System.out.println("===Connected to Database===");
	}

	@AfterSuite
	public void disConnectDatavbase() {
		System.out.println("===Dis Connected===");
	}

	/*
	 * Launch the browser
	 */

	@BeforeClass
	public void launchBrowser() throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		WebDriverUtility webDriverUtility=new WebDriverUtility(driver);
		webDriverUtility.maximize();
		driver.get(propertyFileUtility.readDataFromPropertyFile("url"));
		webDriverUtility.implicitlyWait();
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

	@BeforeMethod 
	public void logintoApp() throws Throwable {


		String uName = propertyFileUtility.readDataFromPropertyFile("username");
		String pWD = propertyFileUtility.readDataFromPropertyFile("password");

		LoginPageClass lpc=new LoginPageClass(driver);
		lpc.login(uName, pWD);
	}
	@AfterMethod
	public void logoutfromApp() 
	{
		HomePageClass homePageClass = new HomePageClass(driver);
		homePageClass.signOut(driver);

	}

}
