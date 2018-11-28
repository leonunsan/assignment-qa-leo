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

public class SignupUserTest {


	public void signUpUser(String auth,String userName, Boolean typeAccount, String dob, String email, String name, String pwd, String power) {		

		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Valid Users Informations - Call For SignUp Api Call - Information of user on response");
		try {
			
		
		String response = signUp(userName, typeAccount, dob, email, name, pwd, power, DataProvider.getUrl()).
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
		delete(auth, DataProvider.getUrl()).
		then()
		.statusCode(200)
		.contentType(ContentType.JSON);
		step.log(Status.PASS, "Response =	> " + response);	    
		}catch (AssertionError | Exception e) {
	 		step.log(Status.FAIL, e.getMessage());	
	 		throw e;
		}
	}
	

	public void invalidSignUpUser(String userName, Boolean typeAccount, String dob, String email, String name, String pwd, String power, String msg) {		

		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Invalid Users Informations - Call For SignUp Api Call - Message Error");
		
		try {
		String response = signUp(userName, typeAccount, dob, email, name, pwd, power, DataProvider.getUrl()).
			then()
				.statusCode(409)
				.contentType(ContentType.JSON)
				.assertThat()
				.body("errorCode", equalTo(409))
				.body("errorMessage", equalTo(msg)).
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
	
	
}
