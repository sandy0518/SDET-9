package genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	WebDriver driver;

	public WebDriverUtility(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method is used to maximize the window
	 * @author saisandeep
	 */

	public void maximize() {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to  wait for page load
	 * @author tharun
	 */
	public void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * This method is used to select by index
	 * @author venkat
	 * @param ele
	 * @param num
	 */
	public void selectByIndex(WebElement ele, int num) {
		Select select=new Select(ele);
		select.selectByIndex(num);
	}

	/**
	 * This method is used to select by VisibleText
	 * @author saisandeep
	 * @param ele
	 * @param Text
	 */
	public void selectByVisibleText(WebElement ele, String Text) {
		Select select=new Select(ele);
		select.selectByVisibleText(Text);
	}

	/**
	 * This method is used to select by value
	 * @author saisandeep
	 * @param ele
	 * @param value
	 */
	public void selectByValue(WebElement ele, String value) {
		Select select=new Select(ele);
		select.selectByValue(value);
	}

	/**
	 * This method is used to get parent handle
	 * @author saisandeep
	 * @return
	 */
	public String getParentHandle() {
		String parentHandle = driver.getWindowHandle();
		System.out.println(parentHandle);
		return parentHandle;	
	}

	/**
	 * This method is used to get all window handles
	 * @author saisandeep
	 * @param pHandle
	 */
	public void allHandles(String pHandle) {
		Set<String> allWinHandles = driver.getWindowHandles();
		System.out.println("All window Handles are :");
		for(String aW:allWinHandles) {
			System.out.println(aW);
			if(!pHandle.equals(aW)) {
				driver.switchTo().window(aW);
				break;
			}
			else {
				driver.switchTo().window(pHandle);
			}
		}
	}

	/**
	 * This method is used to do mouse over action
	 * @author saisandeep
	 * @param variable
	 */
	public void mouseOverAction(WebElement variable) {
		Actions action = new Actions(driver);
		action.moveToElement(variable).perform();
	}

	/**
	 * This method is used for explicitly wait
	 * @author saisandeep
	 * @param locator
	 */
	public void explicitlyWait(By locator) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loactedEement=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		loactedEement.click();
	}
}
