package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organisationInfoPageClass {
	@FindBy(className = "dvHeaderText")
	private WebElement hText;
	
	public organisationInfoPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement gethText() {
		return hText;
	}
	
	public String headT() {
		return hText.getText();
	}
}
