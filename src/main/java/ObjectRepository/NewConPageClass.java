package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import genericUtility.WebDriverUtility;

public class NewConPageClass {
	WebDriver driver;
	public WebDriverUtility wDU=new WebDriverUtility(driver); 
	
	@FindBy(name = "salutationtype")
	private WebElement fNType;
	
	@FindBy(name = "firstname")
	private WebElement fNTF;
	
	@FindBy(name = "lastname")
	private WebElement lNTF;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement orgButton;
	
	@FindBy(xpath ="xpath=\"//input[@class='crmButton small save']")
	private WebElement saveButton;
	
	public NewConPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getfNType() {
		return fNType;
	}

	public WebElement getfNTF() {
		return fNTF;
	}

	public WebElement getlNTF() {
		return lNTF;
	}

	public WebElement getOrgButton() {
		return orgButton;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void fNDD(String value) {
		wDU.selectByValue(fNType, value);
	}
	
	public void fandLastName(String value1, String value2) {
		fNTF.sendKeys(value1);
		lNTF.sendKeys(value2);
	}
	
	public void saveButton() {
		saveButton.click();
	}
}
