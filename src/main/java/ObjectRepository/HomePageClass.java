package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageClass 
{
	WebDriver driver;

	public HomePageClass(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgButton;

	@FindBy(linkText = "Contacts")
	private WebElement conButton;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement SOButton;

	public WebElement getOrgButton() {
		return orgButton;
	}

	public WebElement getConButton() {
		return conButton;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSOButton() {
		return SOButton;
	}

	public void signOut(WebDriver driver) throws InterruptedException {
		Actions action =new Actions(driver);
		
		action.moveToElement(adminImg).build().perform();;
		Thread.sleep(2000);
		SOButton.click();
	}
}
