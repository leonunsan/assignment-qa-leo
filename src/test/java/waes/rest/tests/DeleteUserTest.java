package waes.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import waes.rest.resource.DataProvider;
import waes.ui.resource.ExtentManager;


public class DeleteUserTest {
	
		
	public Response deleteUser(String auth, String userName, Boolean typeAccount, String dob, String email, String name, String pwd, String power) {	

		
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Valid Users - Call For Delete Api Call - Information of deleted user on response");
		 Response response = null;
		try {
			
		signUp(userName, typeAccount, dob, email, name, pwd, power, DataProvider.getUrl());	
		
		 response = delete(auth, DataProvider.getUrl()).
			then()
				.statusCode(200)
				.contentType(ContentType.JSON).				
			extract()
				.response()
		;
		
		 	step.log(Status.PASS, "Response =	> " + response.asString());	    
		}catch (AssertionError | Exception e) {
	 		step.log(Status.FAIL, e.getMessage());	
	 		throw e;
		}
		return response;
	}	
	
	public Response invalidDeleteUser(String auth) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Invalid Users - Call For Delete Api Call - Message Error");
		Response response = null;
		try {
		response = delete(auth, DataProvider.getUrl()).
			then()
				.statusCode(401)
				.contentType(ContentType.JSON)
				.assertThat()
				.body("errorCode", equalTo(401))
				.body("errorMessage", equalTo("Invalid credentials: Invalid username or password.")).	
			extract()
				.response()
		;
		step.log(Status.PASS, "Response =	> " + response.asString());	    
		}catch (AssertionError | Exception e) {
	 		step.log(Status.FAIL, e.getMessage());
	        throw e;
		}
		
		return response;
	}
	
	
	private Response delete(String auth, String baseUrl) {		
		return given()
			.header("authorization", auth)
			.baseUri(baseUrl).
		when()
			.delete("/users")
	;
		
		
	}	
	private void signUp(String userName, Boolean typeAccount, String dob, String email, String name, String pwd, String power, String baseUrl) {		
		
			JSONObject requestParams = new JSONObject();
		
			requestParams.put("isAdmin", typeAccount);
			requestParams.put("dateOfBirth", dob); 
			requestParams.put("email", email);		 
			requestParams.put("name", name);
			requestParams.put("pw", pwd);
			requestParams.put("superpower",  power);		
		given()
			.header("username", userName)
			.header("Content-Type" ,"application/json")
			.body(requestParams.toJSONString())
			.baseUri(baseUrl).
		when()
			.post("/users")
		;
		
					 
	}

}
