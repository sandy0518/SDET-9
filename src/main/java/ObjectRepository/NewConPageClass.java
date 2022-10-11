package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewConPageClass {
	@FindBy(name = "salutationtype")
	private WebElement fNType;
	
	@FindBy(name = "firstname")
	private WebElement fNTF;
	
	@FindBy(name = "lastname")
	private WebElement lNTF;
	
	@FindBy(name = "//img[@src='themes/softed/images/select.gif']")
	private WebElement orgButton;
	
	@FindBy(className ="crmButton small save")
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
	
	public void fNDD(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByValue(value);
	}
	
	public void fAndLName(String firstName, String lastName) {
		fNTF.sendKeys(firstName);
		lNTF.sendKeys(lastName);
	}
}
