package waes.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import waes.commonresource.ExtentManager;
import waes.rest.resource.DataProvider;

/**
 * The GetInfoUserTest is a class that have all test cases validations for get Information from user Calls. 
 * It will be called for RunAllTests.
 * 
 * @author Leonardo Santos
 */

public class GetInfoUserTest {

		
	public void searchValidUser(String id, Boolean typeAccount, String dob, String email, String name,  String power) {	

		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Valid Users - Call For Get User Api Call - Information of user on response");
		
		try {
		
		String response = searchUser(id, DataProvider.getUrl()).
			then()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.assertThat()				
				.body("dateOfBirth", equalTo(dob))				
				.body("email", equalTo(email))
				.body("isAdmin", equalTo(typeAccount))
				.body("name", equalTo(name))
				.body("superpower", equalTo(power)).
			extract()
				.response().asString()
			;	

		step.log(Status.PASS, "Response =	> " + response);	    
		}catch (AssertionError | Exception e) {
	 		step.log(Status.FAIL, e.getMessage());
	 		throw e;
		}	
	}
	
	public void searchIvanlidUser(String id) {

		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Invalid Users - Call For Get User Api Call - Message Error");
		
		try {
		
		String response = searchUser(id, DataProvider.getUrl()).
			then()
				.statusCode(404)
				.contentType(ContentType.JSON)
				.assertThat()
				.body("errorCode", equalTo(404))
				.body("errorMessage", equalTo("Username "+id+" does not exist.")).
			extract()
				.response().asString()
		;

		step.log(Status.PASS, "Response =	> " + response);	    
		}catch (AssertionError | Exception e) {
	 		step.log(Status.FAIL, e.getMessage());
	 		throw e;
		}
	}	
	
	private Response searchUser(String id, String baseUrl) {		
		 return given()
			.baseUri(baseUrl).
		when()
			.get("/users/details?username="+id)
		;				 
	}
	
}
