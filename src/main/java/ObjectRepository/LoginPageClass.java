package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
	@FindBy(name="user_name")
	private WebElement UserName;
	
	@FindBy(name="user_password")
	private WebElement Password;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	public LoginPageClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void login(String UserNameText, String PasswordText) {
		UserName.sendKeys(UserNameText);
		Password.sendKeys(PasswordText);
		loginButton.click();
	}
}
