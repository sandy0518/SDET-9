package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPageClass {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreOrg;
	
	public OrgPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreOrg() {
		return CreOrg;
	}
	
	
}
