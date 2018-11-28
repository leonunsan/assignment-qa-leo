package waes.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import waes.commonresource.ExtentManager;
import waes.rest.resource.DataProvider;

/**
 * The UpdateUserTest is a class that have all test cases validations for Update user Calls.
 * It will be called for RunAllTests.
 * 
 * @author Leonardo Santos
 */

public class UpdateUserTest {

	public void updateUser(String auth, String userName, Boolean typeAccount, String dob, String email, String name, String pwd, String power) {		

		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Valid Users Informations - Call For Update Api Call - New Information of user on response");
		
		try {		
			
			signUp(userName, typeAccount, dob, email, name, pwd, power,DataProvider.getUrl());			
			
			String response = update(auth, typeAccount, "1988-11-11", email+"2", name+"2", pwd, power+"2", DataProvider.getUrl()).
					then()
					.statusCode(200)
					.contentType(ContentType.JSON)
					.assertThat().
					extract()
					.response().asString()
					;
			
			delete(auth, DataProvider.getUrl());
			step.log(Status.PASS, "Response =	> " + response);	    
		}catch (AssertionError | Exception e) {
	 		step.log(Status.FAIL, e.getMessage());	
	 		throw e;
		}	 
	}

	public void updateInvalidUser(String auth, Boolean typeAccount, String dob, String email, String name, String pwd, String power) {		

		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Invalid Users Informations - Call For Update Api Call - Message Error");

		try {			
			String response = update(auth, typeAccount, dob, email, name, pwd, power, DataProvider.getUrl()).
					then()
					.statusCode(401)
					.contentType(ContentType.JSON)
					.assertThat()
					.body("errorCode", equalTo(401))
					.body("errorMessage", equalTo("Invalid credentials: Invalid username or password.")).	
					extract()
					.response().asString()
					;
			step.log(Status.PASS, "Response =	> " + response);	    
		}catch (AssertionError | Exception e) {
	 		step.log(Status.FAIL, e.getMessage());	
	 		throw e;
		}
	}

	private Response signUp(String userName, Boolean typeAccount, String dob, String email, String name, String pwd, String power, String baseUrl) {		
		JSONObject requestParams = new JSONObject();
		requestParams.put("isAdmin", typeAccount);
		requestParams.put("dateOfBirth", dob); 
		requestParams.put("email", email);		 
		requestParams.put("name", name);
		requestParams.put("pw", pwd);
		requestParams.put("superpower",  power);		
		return given()
				.header("username", userName)
				.header("Content-Type" ,"application/json")
				.body(requestParams.toJSONString())
				.baseUri(baseUrl).
				when()
				.post("/users")
				;				 
	}

	private Response delete(String auth, String baseUrl){		
		return given()
				.header("authorization", auth)
				.baseUri(baseUrl).
				when()
				.delete("/users")
				;


	}	


	private Response update(String auth, Boolean typeAccount, String dob, String email, String name, String pwd, String power, String baseUrl) {	
		JSONObject requestParams = new JSONObject();
		requestParams.put("dateOfBirth", dob); 
		requestParams.put("email", email);		 
		requestParams.put("isAdmin", typeAccount);
		requestParams.put("name", name);
		requestParams.put("pw", pwd);
		requestParams.put("superpower",  power);
		return given()
				.header("authorization", auth)
				.header("Content-Type" ,"application/json")
				.body(requestParams.toJSONString())
				.baseUri(baseUrl).
				when()
				.put("/users")
				;				 
	}



}
