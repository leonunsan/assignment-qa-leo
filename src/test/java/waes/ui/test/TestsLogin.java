package waes.ui.test;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import waes.ui.resource.SeleniumCalls;
import waes.ui.resource.WaesworksResources;

public class TestsLogin implements WaesworksResources.ENV1{
	
	String stepAction;
	SeleniumCalls action = new SeleniumCalls();
	

	
	 
	public void loadUrl(WebDriver driver, ExtentTest step)  {
	 	stepAction = "Load URL";
	 	try {
	 		
	 	//Load URL 
	 	action.goUrl(URL_WAESWORKS, driver);
	 	
		step.log(Status.PASS, "Step => " + stepAction);
	}catch (Exception e) {
 		e.printStackTrace();
 		step.log(Status.FAIL, "Step => " + stepAction);
	}
	}
	
	
	public void loginPage(WebDriver driver, String user [], ExtentTest step)  {
	 	stepAction = "Fill Login";
	 	try {
	 		
	 	//Click on Login
	 	action.clickElementXpath(LOGIN_LINK_XPATH, driver);
	 	
	 	//Fill the fields
	 	action.writeOnFieldById(USER_FIELD_ID, user[0], driver);
	 	action.writeOnFieldById(PWD_FIELD_ID, user[1], driver);
	 	
	 	//Click Login button
	 	action.clickElementID(LOGIN_BTN_ID, driver);
	 	
		step.log(Status.PASS, "Step => " + stepAction);
	}catch (Exception e) {
 		e.printStackTrace();
 		step.log(Status.FAIL, "Step => " + stepAction);
	}
	}
	
	
	public void welcomePage(WebDriver driver, String user [], ExtentTest step)  {
	 	stepAction = "Verify Welcome Page";
	 	try {
	 		
	 	//Check informations displayed on welcome page
	 	action.checkTextOnXpath(user[2], LOGGED_EMAIL_PATH, driver);
	 	action.checkTextOnXpath(user[3], LOGGED_NAME_PATH, driver);
	 	action.checkTextOnXpath(user[3], LOGGED_NAME_WTEXT_PATH, driver);
	 	action.checkTextOnXpath(user[4], LOGGED_POWER_PATH, driver);
	 	
		step.log(Status.PASS, "Step => " + stepAction);
		
	 	}catch (Exception e) {
	 		e.printStackTrace();
	 		step.log(Status.FAIL, "Step => " + stepAction);
		}
	}
	
	
	public void welcomePageAdmin(WebDriver driver, String user [], ExtentTest step)  {
	 	stepAction = "Verify Welcome Page";
	 	try {
	 		
	 	//Check informations displayed on welcome page
	 	action.checkTextOnXpath(user[2], LOGGED_EMAIL_PATH, driver);
	 	action.checkTextOnXpath(user[3], LOGGED_NAME_PATH, driver);
	 	action.checkTextOnXpath(user[3], LOGGED_NAME_WTEXT_PATH, driver);
	 	action.checkTextOnXpath(user[4], LOGGED_POWER_PATH, driver);
	 	action.checkTextOnXpath(LOGGED_ADMIN_LIST_TEXT, LOGGED_ADMIN_LIST_TEXT_PATH, driver);
	 	assertTrue(action.countElements(LOGGED_ADMIN_LIST_TABLE_PATH, driver) > 2);
		step.log(Status.PASS, "Step => " + stepAction);
		
	 	}catch (Exception e) {
	 		e.printStackTrace();
	 		step.log(Status.FAIL, "Step => " + stepAction);
		}
	}
	
	public void detailsPage(WebDriver driver, String user [], ExtentTest step)  {
		stepAction = "Check Details Page";
		try {

			//Click on SignUp
			action.clickElementXpath(DETAILS_XPATH_LINK, driver);

			//Check informations displayed on Details Page
			action.checkTextOnXpath(user[3], DETAILS_NAME_XPATH, driver);
			action.checkTextOnXpath(user[2], DETAILS_EMAIL_XPATH, driver);

			step.log(Status.PASS, "Step => " + stepAction);
		}catch (Exception e) {
			e.printStackTrace();
			step.log(Status.FAIL, "Step => " + stepAction);
		}
	}
	
	
	public void logoutAction(WebDriver driver, ExtentTest step)  {
	 	stepAction = "Logout";
	 	try {
	 		
	 		//Do logout of user
		 	action.clickElementXpath(LOGOUT_XPATH, driver);
		 	action.checkTextOnXpath(LOGOUT_TEXT, LOGOUT_TEXT_XPATH, driver);
		 	
		 	step.log(Status.PASS, "Step => " + stepAction);
	 		
	 	}catch (Exception e) {
	 		e.printStackTrace();
	 		step.log(Status.FAIL, "Step => " + stepAction);
		}
	}
	
	public void wrongCredentials(WebDriver driver, ExtentTest step)  {
	 	stepAction = "Wrong Credentials Message";
	 	try {
	 		
	 		//Verify message error for wrong credentials
		 	action.checkTextOnXpath(WRONGC_TEXT, WRONGC_TEXT_PATH, driver);
		 	
		 	step.log(Status.PASS, "Step => " + stepAction);
	 		
	 	}catch (Exception e) {
	 		e.printStackTrace();
	 		step.log(Status.FAIL, "Step => " + stepAction);
		}
	}
}		