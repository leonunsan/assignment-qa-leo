package waes.ui.test;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import waes.ui.resource.SeleniumCalls;
import waes.ui.resource.WaesworksResources;

public class TestsSignup implements WaesworksResources.ENV1{

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


	public void signupPage(WebDriver driver, String user [], ExtentTest step)  {
		stepAction = "Fill Signup Page";
		try {

			//Click on SignUp
			action.clickElementXpath(SIGNUP_LINK_XPATH, driver);

			//Fill the fields
			action.writeOnFieldById(SIGNUP_USER_FIELD_ID, user[0], driver);
			action.writeOnFieldById(SIGNUP_PWD_FIELD_ID, user[1], driver);
			action.writeOnFieldById(SIGNUP_NAME_FIELD_ID, user[3], driver);
			action.writeOnFieldById(SIGNUP_EMAIL_FIELD_ID, user[2], driver);
			action.selectComboBoxId(SIGNUP_DOB_DAY_ID, user[4], driver);
			action.selectComboBoxId(SIGNUP_DOB_MON_ID, user[5], driver);
			action.selectComboBoxId(SIGNUP_DOB_YEA_ID, user[6], driver);

			//Click Login button
			action.clickElementID(SIGNUP_SUBMIT_BTN_ID, driver);

			step.log(Status.PASS, "Step => " + stepAction);
		}catch (Exception e) {
			e.printStackTrace();
			step.log(Status.FAIL, "Step => " + stepAction);
		}
	}


	public void profilePage(WebDriver driver, String user [], ExtentTest step)  {
		stepAction = "Check Profile Page";
		try {

			//Check informations displayed on Profile page
			action.checkTextOnXpath(user[2], PROFILE_EMAIL_PATH, driver);
			action.checkTextOnXpath(user[3], PROFILE_NAME_PATH, driver);
			action.checkTextOnXpath(user[3], PROFILE_MESSAGE_PATH, driver);

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

			//Eexecute logout of user
			action.clickElementXpath(LOGOUT_XPATH, driver);
			action.checkTextOnXpath(LOGOUT_TEXT, LOGOUT_TEXT_XPATH, driver);

			step.log(Status.PASS, "Step => " + stepAction);

		}catch (Exception e) {
			e.printStackTrace();
			step.log(Status.FAIL, "Step => " + stepAction);
		}
	}
}		