package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class NewOrgPageClass {
	WebDriver driver;
	WebDriverUtility wdu=new WebDriverUtility(driver);
	
	@FindAll({@FindBy(name="accountname"), @FindBy(xpath="//input[@class='detailedViewTextBo']")})
	private WebElement orgNameTF;

	@FindBys({@FindBy(name="button"),@FindBy(xpath ="//input[@type='button']")})
	private WebElement saveButton;

	@FindBy(name="industry")
	private WebElement IndDD;


	public NewOrgPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getIndType() {
		return IndDD;
	}
	
	public void orgTF(String OrgText) {
		orgNameTF.sendKeys(OrgText);
	}

	
	public void IndustryDD(String value) {
		wdu.selectByValue(IndDD, value);
	}
	
	public void sButton() {
		saveButton.click();
	}

	
}
