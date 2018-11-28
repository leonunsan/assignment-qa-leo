package waes.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import waes.rest.resource.DataProvider;
import waes.ui.resource.ExtentManager;

public class AuthenticationUserTest {
	
	public void authenticateUser(String auth, Boolean typeAccount, String dob, String email, String name,  String power) {	
		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Valid Users - Call For Authentication Api Call - Information of user on response");
			
		try {
		String response = logIn(auth, DataProvider.getUrl()).
			then().
				statusCode(200).
				contentType(ContentType.JSON).
			assertThat()
				.body("dateOfBirth", equalTo(dob))				
				.body("email", equalTo(email))
				.body("isAdmin", equalTo(typeAccount))
				.body("name", equalTo(name))
				.body("superpower", equalTo(power)).
			extract()
				.asString();
		
			step.log(Status.PASS, "Response =	> " + response);	    
		}catch (AssertionError | Exception e) {
	 		step.log(Status.FAIL, e.getMessage());
	 		throw e;
		}
		
	}
	
	public void authenticateInvalidUser(String auth, Boolean typeAccount, String dob, String email, String name,  String power) {		

		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Invalid Users - Call For Authentication Api Call - Message Error");
		
		try {
		String response = logIn(auth,DataProvider.getUrl()).
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
	
	
	private Response logIn(String auth, String baseUrl)  {
		return given()
			.header("authorization", auth)
			.baseUri(baseUrl).
		when()
			.get("/users/access")			
		;
	}

}
