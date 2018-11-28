package waes.ui.resource;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The SeleniumCalls is a class that manager the abstraction of Selenium Code, it have all Selenium code and turn available the friendly methods to execute the actions on the UI tests.
 * 
 * @author Leonardo Santos
 */

public class SeleniumCalls {

	public SeleniumCalls() {
		super();
	}
	
	// Load url.
	public void goUrl(String url, WebDriver driver) throws Exception {			
		driver.get(url);
		Thread.sleep(2000);
	}

	//Write on filed passing ID to indetify that.
	public void writeOnFieldById(String id, String text, WebDriver driver) throws Exception {			
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		element.sendKeys(text);
	}


	//Click on element using ID to identify.
	public void clickElementID(String id, WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(findElementID(id, driver)));
		element.click();
	}

	
	//Click on element using XPATH to identify.
		public void clickElementXpath(String xpath, WebDriver driver) throws Exception {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(findElementXpath(xpath, driver)));
			element.click();
		}
		

	// Verify text on element by xpath
	public void checkTextOnXpath(String text, String xpath, WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = findElementXpath(xpath, driver);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	// Select a value on select box using ID
		public void selectComboBoxId(String id, String value,  WebDriver driver) throws Exception {
				Select element = new Select(findElementID(id, driver));
				element.selectByValue(value);
		}
		
	// Count number of elements
		public int countElements(String path, WebDriver driver) throws Exception {			 
			 List<WebElement> lstElements = driver.findElements(By.xpath(path));
			return lstElements.size();
	}
		

	// Look of a element on page using XPATH for identification.
		public WebElement findElementXpath(String xpath, WebDriver driver) throws Exception {			
				WebElement element = driver.findElement(By.xpath(xpath));
				return element;			
		}

	// Look of a element on page using ID for identification.
		public WebElement findElementID(String id, WebDriver driver) throws Exception {			
			WebElement element = driver.findElement(By.id(id));
			return element;
		}

}
