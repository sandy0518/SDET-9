package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePageClass;
import ObjectRepository.LoginPageClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public WebDriver driver;
	public static WebDriver sdriver;
	PropertyFileUtility propertyFileUtility = new PropertyFileUtility();

	@BeforeSuite(groups = {"smoke","regression","integration"})
	public void dataBaseConnection() {
		System.out.println("===Connected to Database===");
	}

	@AfterSuite(groups = {"smoke","regression","integration"})
	public void disConnectDatavbase() {
		System.out.println("===Dis Connected===");
	}

	/*
	 * Launch the browser
	 */

	@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke","regression","integration"})
	public void launchBrowser(String browser) throws Throwable 
	{
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Input");
		}

		sdriver=driver;
		WebDriverUtility webDriverUtility=new WebDriverUtility(driver);
		webDriverUtility.maximize();
		driver.get(propertyFileUtility.readDataFromPropertyFile("url"));
		webDriverUtility.implicitlyWait();
	}

	@AfterClass(groups = {"smoke","regression","integration"})
	public void closeBrowser() {
		driver.close();
	}

	@BeforeMethod (groups = {"smoke","regression","integration"})
	public void logintoApp() throws Throwable {


		String uName = propertyFileUtility.readDataFromPropertyFile("username");
		String pWD = propertyFileUtility.readDataFromPropertyFile("password");

		LoginPageClass lpc=new LoginPageClass(driver);
		lpc.login(uName, pWD);
	}
	@AfterMethod(groups = {"smoke","regression","integration"})
	public void logoutfromApp() 
	{
		HomePageClass homePageClass = new HomePageClass(driver);
		homePageClass.signOut(driver);

	}

}
