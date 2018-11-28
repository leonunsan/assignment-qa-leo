package waes.ui.resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * The GenerateDriver is a class that manager the Selenium WebDriver, it will  create as called the instance of webdriver for the specific browser.
 * 
 * @author Leonardo Santos
 */

public class GenerateDriver {	

	public WebDriver chrome() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		
		return driver;
	}  
	
	public WebDriver firefox() {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(); 
		driver.manage().window().maximize();
		
		return driver;
	} 
	
	public WebDriver iexplorer() {
		
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver(); 
		driver.manage().window().maximize();
		
		return driver;
	}
}
