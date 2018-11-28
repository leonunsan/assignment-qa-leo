package waes.ui.test;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import waes.ui.resource.ExtentManager;
import waes.ui.resource.GenerateDriver;
import waes.ui.resource.WaesworksResources;

public class Tests implements WaesworksResources.ENV1{
	
	public void validLoginAdmin() {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with valid credentials for ADMIN");
		TestsLogin runLogin = new TestsLogin();
		
		//It can be changed to "iexplorer", "chrome" and "firefox"
		WebDriver driver = new GenerateDriver().firefox();	
		
		try {
			runLogin.loadUrl(driver, step);			
			runLogin.loginPage(driver, ADMIN, step);
			runLogin.welcomePageAdmin(driver, ADMIN, step);
			runLogin.detailsPage(driver, ADMIN, step);			
			runLogin.logoutAction(driver, step);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}
	
	public void validLoginDev() {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with valid credentials for DEV");
		WebDriver driver = new GenerateDriver().chrome();
		
		TestsLogin runLogin = new TestsLogin();
		
		try {
			runLogin.loadUrl(driver, step);
			runLogin.loginPage(driver, DEV, step);
			runLogin.welcomePage(driver, DEV, step);
			runLogin.logoutAction(driver, step);
			driver.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			driver.close();
		}
	}
	

	public void validLoginTester() {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with valid credentials for TESTER");
		WebDriver driver = new GenerateDriver().chrome();
		
		TestsLogin runLogin = new TestsLogin();
		
		try {
			runLogin.loadUrl(driver, step);
			runLogin.loginPage(driver, TESTER, step);
			runLogin.welcomePage(driver, TESTER, step);
			runLogin.logoutAction(driver, step);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			driver.close();
		}
	}
	
	

	public void invalidLoginLeoleo() {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Login with invalid credentials for leoleo");
		WebDriver driver = new GenerateDriver().chrome();
		
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
	
	

	public void validSignUp() {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Signup with valid information");
		WebDriver driver = new GenerateDriver().chrome();
		
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
