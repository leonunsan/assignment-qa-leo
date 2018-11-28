package waes;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.aventstack.extentreports.ExtentReports;

import waes.commonresource.ExtentManager;
import waes.rest.resource.DataProvider;
import waes.rest.tests.AuthenticationUserTest;
import waes.rest.tests.DeleteUserTest;
import waes.rest.tests.GetAllUserTest;
import waes.rest.tests.GetInfoUserTest;
import waes.rest.tests.SignupUserTest;
import waes.rest.tests.UpdateUserTest;
import waes.ui.resource.GenerateDriver;
import waes.ui.test.UiTests;

/**
 * The RunAllTests have all tests cases of this project, it is the responsible for 
 * have the Junit Annotations also.
 * Any test cases created should be called from here.
 * 
 * @author Leonardo Santos
 */

public class RunAllTests {
	private static ExtentReports extent;

	UiTests runUiTest = new UiTests();
	AuthenticationUserTest authUser = new AuthenticationUserTest();
	DeleteUserTest deleteUser = new DeleteUserTest();
	GetAllUserTest getAllUser = new GetAllUserTest();
	GetInfoUserTest getUser = new GetInfoUserTest();
	SignupUserTest signUser = new SignupUserTest();
	UpdateUserTest updateUser = new UpdateUserTest();

	
	private static Stream<Arguments> getAuthUser() {
		return DataProvider.getAuthUser();
	}

	private static Stream<Arguments> getInvalidAuthUser() {
		return DataProvider.getInvalidAuthUser();
	}

	private static Stream<Arguments> getSignUser() {
		return DataProvider.getSignUser();
	}

	private static Stream<Arguments> getDeleteUser() {
		return DataProvider.getDeleteUser();
	}

	private static Stream<Arguments> getInvalidDeleteUser() {
		return DataProvider.getInvalidDeleteUser();
	}

	private static Stream<Arguments> getAuthAllUsers() {
		return DataProvider.getAuthAllUsers();
	}

	private static Stream<Arguments> getInvalidAuthAllUsers() {
		return DataProvider.getInvalidAuthAllUsers();
	}

	private static Stream<Arguments> getUserInformation() {
		return DataProvider.getUserInformation();
	}

	private static Stream<Arguments> getInvalidUserInformation() {
		return DataProvider.getInvalidUserInformation();
	}

	private static Stream<Arguments> getInvalidSignUser() {
		return DataProvider.getInvalidSignUser();
	}

	private static Stream<Arguments> getUpdateUser() {
		return DataProvider.getUpdateUser();
	}

	private static Stream<Arguments> getUpdateInvalidUser() {
		return DataProvider.getUpdateInvalidUser();
	}
	
	
	@BeforeAll
	public static void beforeConfig() {
		extent = ExtentManager.createInstance("Waesworks - Report Tests.html");
	}
	
	@Test
	public void uiTest_chrome_validUser_asAdmin_loginOnApplication_accessWelcomePage() {
		runUiTest.validLoginAdmin("chrome");
	}
	
	@Test
	public void uiTest_firefox_validUser_asAdmin_loginOnApplication_accessWelcomePage() {
		runUiTest.validLoginAdmin("firefox");
	}
	
	@Test
	public void uiTest_chrome_validUser_asAdmin_accessDetailsPage_validPageInfo() {
		runUiTest.validDetailsPageAdmin("chrome");
	} 
	
	@Test
	public void uiTest_firefox_validUser_asAdmin_accessDetailsPage_validPageInfo() {
		runUiTest.validDetailsPageAdmin("firefox");
	}

	@Test
	public void uiTest_chrome_validUser_asAdmin_logoutFromApplication_successMessage() {
		runUiTest.validLogoutAdmin("chrome");
	}  
	
	@Test
	public void uiTest_firefox_validUser_asAdmin_logoutFromApplication_successMessage() {
		runUiTest.validLogoutAdmin("firefox");
	} 
	
	@Test
	public void uiTest_chrome_validUser_asDev_loginOnApplication_accessWelcomePage() {
		runUiTest.validLoginDev("chrome");
	}  
	
	@Test
	public void uiTest_firefox_validUser_asDev_loginOnApplication_accessWelcomePage() {
		runUiTest.validLoginDev("firefox");
	} 
	
	@Test
	public void uiTest_chrome_validUser_asDev_accessDetailsPage_validPageInfo() {
		runUiTest.validDetailsPageDev("chrome");
	} 
	
	@Test
	public void uiTest_firefox_validUser_asDev_accessDetailsPage_validPageInfo() {
		runUiTest.validDetailsPageDev("firefox");
	}
	
	@Test
	public void uiTest_chrome_validUser_asDev_logoutFromApplication_successMessage() {
		runUiTest.validLogoutDev("chrome");
	} 
	
	@Test
	public void uiTest_firefox_validUser_asDev_logoutFromApplication_successMessage() {
		runUiTest.validLogoutDev("firefox");
	}
	
	@Test
	public void uiTest_chrome_validUser_asTester_loginOnApplication_accessToProfileDetails() {
		runUiTest.validLoginTester("chrome");
	}
	
	@Test
	public void uiTest_firefox_validUser_asTester_loginOnApplication_accessToProfileDetails() {
		runUiTest.validLoginTester("firefox");
	}
	
	@Test
	public void uiTest_chrome_validUser_asTester_accessDetailsPage_validPageInfo() {
		runUiTest.validDetailsPageTester("chrome");
	}
	
	@Test
	public void uiTest_firefox_validUser_asTester_accessDetailsPage_validPageInfo() {
		runUiTest.validDetailsPageTester("firefox");
	}
	
	@Test
	public void uiTest_chrome_validUser_asTester_logoutFromApplication_successMessage() {
		runUiTest.validLogoutTester("chrome");
	}
	
	@Test
	public void uiTest_firefox_validUser_asTester_logoutFromApplication_successMessage() {
		runUiTest.validLogoutTester("firefox");
	}	

	@Test
	public void uiTest_chrome_invalidUser_asLeoleo_loginOnApplication_messageError() {
		runUiTest.invalidLoginLeoleo("chrome");
	}
	
	@Test
	public void uiTest_firefox_invalidUser_asLeoleo_loginOnApplication_messageError() {
		runUiTest.invalidLoginLeoleo("firefox");
	}

	@Test
	public void uiTest_chrome_validNewUserInformation_signUpOnApplication_accessToProfileDetail() {
		runUiTest.validSignUp("chrome");
	}
	
	@Test
	public void uiTest_firefox_validNewUserInformation_signUpOnApplication_accessToProfileDetail() {
		runUiTest.validSignUp("firefox");
	}

	
	// Rest API test Cases
	@MethodSource("getAuthUser")
	@ParameterizedTest
	public void restTest_validAdminDevTesterUsers_restAuthenticationCall_fullUserInformationResponse(String auth, Boolean typeAccount, String dob, String email, String name, String power) {
		authUser.authenticateUser(auth, typeAccount, dob, email, name, power);
	}

	@MethodSource("getInvalidAuthUser")
	@ParameterizedTest()
	public void restTest_invalidAdminDevTesterUsers_restAuthenticationCall_errorCodeAndErrorMessageResponse(String auth, Boolean typeAccount, String dob, String email, String name, String power) {
		authUser.authenticateInvalidUser(auth, typeAccount, dob, email, name, power);
	}	

	@MethodSource("getDeleteUser")
	@ParameterizedTest()
	public void restTest_validUsersInformation_restDeleteCall_deletedUserInformationResponse(String auth, String userName, Boolean typeAccount, String dob, String email, String name, String pwd, String power) {
		
		deleteUser.deleteUser(auth, userName, typeAccount, dob, email, name, pwd, power);
	}

	@MethodSource("getInvalidDeleteUser")
	@ParameterizedTest()
	public void restTest_invalidUsersinformation_restDeleteCall_invaliduserInformationMessageResponse(String auth) {
		deleteUser.invalidDeleteUser(auth);
	}

	@MethodSource("getAuthAllUsers")
	@ParameterizedTest()
	public void restTest_validAdminAccess_restGetAllUsersCall_listOfAllUsersResponse(String auth) {
		getAllUser.searchAllUsers(auth);
	}

	@MethodSource("getInvalidAuthAllUsers")
	@ParameterizedTest()
	public void restTest_invalidAdminAccess_restGetAllUsersCall_errorCodeAndErrorMessageResponse(String auth) {
		getAllUser.searchAllUsersInvalid(auth);
	}

	@MethodSource("getUserInformation")
	@ParameterizedTest()
	public void restTest_validUser_restGetUsersCall_informationFromUserResponse(String id, Boolean typeAccount, String dob, String email, String name, String power) {
		getUser.searchValidUser(id, typeAccount, dob, email, name, power);
	}

	@MethodSource("getInvalidUserInformation")
	@ParameterizedTest()
	public void restTest_invalidUser_restGetUsersCall_errorCodeAndErrorMessageResponse(String auth) {
		getUser.searchIvanlidUser(auth);
	}

	@MethodSource("getSignUser")
	@ParameterizedTest()
	public void restTest_validNewUserInformation_restSignUpCall_informationFromUserResponse(String auth, String userName, Boolean typeAccount, String dob, String email, String name, String pwd,
			String power) {
		signUser.signUpUser(auth, userName, typeAccount, dob, email, name, pwd, power);
	}

	@MethodSource("getInvalidSignUser")
	@ParameterizedTest()
	public void restTest_invalidNewUserInformation_restSignUpCall_errorCodeAndErrorMessageResponse(String userName, Boolean typeAccount, String dob, String email, String name, String pwd,
			String power, String msg) {
		signUser.invalidSignUpUser(userName, typeAccount, dob, email, name, pwd, power, msg);
	}


	@MethodSource("getUpdateUser")
	@ParameterizedTest()
	public void restTest_validUserInformation_restUpdateCall_newInformationFromUserResponse(String auth, String userName, Boolean typeAccount, String dob, String email, String name, String pwd,
			String power) {		
		updateUser.updateUser(auth, userName, typeAccount, "1988-11-11", email+"2", name+"2", pwd, power+"2");

	}	

	@MethodSource("getUpdateInvalidUser")
	@ParameterizedTest()
	public void restTest_invalidUserInformation_restUpdateCall_errorCodeAndErrorMessageResponse(String userName, Boolean typeAccount, String dob, String email, String name, String pwd,
			String power) {
		updateUser.updateInvalidUser(userName, typeAccount, dob, email, name, pwd, power);
	}
	
	@AfterAll
	public static void afterConfig() {
		extent.flush();
	}
}
