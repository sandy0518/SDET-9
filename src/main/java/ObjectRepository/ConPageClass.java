package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConPageClass {

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusButton;
	
	public ConPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPlusButton() {
		return plusButton;
	}
	
	public void clickonPB() {
		plusButton.click();
	}
}
