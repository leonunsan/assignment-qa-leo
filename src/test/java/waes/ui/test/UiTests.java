package waes.ui.test;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import waes.commonresource.ExtentManager;
import waes.ui.resource.GenerateDriver;
import waes.ui.resource.WaesworksResources;

/**
 * The UiTests is a class that have all test cases calls for UI Tests, it's responsible mount the test cases.
 * It implements the WaesworksResources and the environment for tests (ENV1) to get the data needed for the tests
 * 
 * @author Leonardo Santos
 */

public class UiTests implements WaesworksResources.ENV1{
	
	public void validLoginAdmin(String browser) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with valid credentials for ADMIN " + browser);
		TestsLogin runLogin = new TestsLogin();
		
		WebDriver driver = new GenerateDriver().getDriver(browser);	
		
		try {
			runLogin.loadUrl(driver, step);			
			runLogin.loginPage(driver, ADMIN, step);
			runLogin.welcomePageAdmin(driver, ADMIN, step);
			
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}
	
	public void validDetailsPageAdmin(String browser) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with ADMIN and check Details Page " + browser);
		TestsLogin runLogin = new TestsLogin();
		
		WebDriver driver = new GenerateDriver().getDriver(browser);		
		
		try {
			runLogin.loadUrl(driver, step);			
			runLogin.loginPage(driver, ADMIN, step);
			runLogin.welcomePageAdmin(driver, ADMIN, step);
			runLogin.detailsPage(driver, ADMIN, step);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}
	
	public void validLogoutAdmin(String browser) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with ADMIN and check Details Page " + browser);
		TestsLogin runLogin = new TestsLogin();
		
		WebDriver driver = new GenerateDriver().getDriver(browser);		
		
		try {
			runLogin.loadUrl(driver, step);			
			runLogin.loginPage(driver, ADMIN, step);					
			runLogin.logoutAction(driver, step);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}
	
	public void validLoginDev(String browser) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with valid credentials for DEV " + browser);
		WebDriver driver = new GenerateDriver().getDriver(browser);	
		
		TestsLogin runLogin = new TestsLogin();
		
		try {
			runLogin.loadUrl(driver, step);
			runLogin.loginPage(driver, DEV, step);
			runLogin.welcomePage(driver, DEV, step);
			
			driver.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			driver.close();
		}
	}
	
	public void validDetailsPageDev(String browser) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with valid credentials for DEV " + browser);
		WebDriver driver = new GenerateDriver().getDriver(browser);	
		
		TestsLogin runLogin = new TestsLogin();
		
		try {
			runLogin.loadUrl(driver, step);
			runLogin.loginPage(driver, DEV, step);
			runLogin.welcomePage(driver, DEV, step);
			runLogin.detailsPage(driver, DEV, step);
			driver.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			driver.close();
		}
	}
	
	public void validLogoutDev(String browser) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with valid credentials for DEV " + browser);
		WebDriver driver = new GenerateDriver().getDriver(browser);	
		
		TestsLogin runLogin = new TestsLogin();
		
		try {
			runLogin.loadUrl(driver, step);
			runLogin.loginPage(driver, DEV, step);
			runLogin.logoutAction(driver, step);
			driver.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			driver.close();
		}
	}
	
	
	public void validLoginTester(String browser) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with valid credentials for TESTER " + browser);
		WebDriver driver = new GenerateDriver().getDriver(browser);	
		
		TestsLogin runLogin = new TestsLogin();
		
		try {
			runLogin.loadUrl(driver, step);
			runLogin.loginPage(driver, TESTER, step);
			runLogin.welcomePage(driver, TESTER, step);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}
	
	public void validDetailsPageTester(String browser) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with valid credentials for TESTER " + browser);
		WebDriver driver = new GenerateDriver().getDriver(browser);	
		
		TestsLogin runLogin = new TestsLogin();
		
		try {
			runLogin.loadUrl(driver, step);
			runLogin.loginPage(driver, TESTER, step);
			runLogin.welcomePage(driver, TESTER, step);
			runLogin.detailsPage(driver, TESTER, step);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}
	
	public void validLogoutTester(String browser) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with valid credentials for TESTER " + browser);
		WebDriver driver = new GenerateDriver().getDriver(browser);
		
		TestsLogin runLogin = new TestsLogin();
		
		try {
			runLogin.loadUrl(driver, step);
			runLogin.loginPage(driver, TESTER, step);
			runLogin.logoutAction(driver, step);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}
	
	

	public void invalidLoginLeoleo(String browser) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with invalid credentials for leoleo " + browser);
		WebDriver driver = new GenerateDriver().getDriver(browser);	
		
		TestsLogin runLogin = new TestsLogin();
		
		try {
			runLogin.loadUrl(driver, step);
			runLogin.loginPage(driver, WRONG, step);
			runLogin.wrongCredentials(driver, step);
			
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}
	
	

	public void validSignUp(String browser) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Signup with valid information " + browser);
		WebDriver driver = new GenerateDriver().getDriver(browser);	
		
		TestsSignup runSignup = new TestsSignup();
		
		try {
			runSignup.loadUrl(driver, step);
			runSignup.signupPage(driver, NEW1, step);
			runSignup.profilePage(driver, NEW1, step);
			runSignup.detailsPage(driver, NEW1, step);
			runSignup.logoutAction(driver, step);
			
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}


}
