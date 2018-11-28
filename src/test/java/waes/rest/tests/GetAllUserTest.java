package waes.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import waes.rest.resource.DataProvider;
import waes.ui.resource.ExtentManager;

public class GetAllUserTest {
	
	public void searchAllUsers(String auth) {

		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Valid Admin Users - Call For Get All Users Api Call - List of all users on response");
		
		try {
			String response = searchAllUser(auth, DataProvider.getUrl()).
			then()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.assertThat()				
				.body("$", hasKey("dev"))	
				.body("$", hasKey("tester"))	
				.body("$", hasKey("admin")).	
			extract()
				.response().asString()
		;

			step.log(Status.PASS, "Response =	> " + response);	    
		}catch (AssertionError | Exception e) {
	 		step.log(Status.FAIL, e.getMessage());	
	 		throw e;
		}
	}
	
	public void searchAllUsersInvalid(String auth) {	

		ExtentReports logger = ExtentManager.getInstance();
		ExtentTest step = logger.createTest("Invalid Admin Users - Call For Get All Users Api Call - Message Error");
		
		try {
		
		String response = searchAllUser(auth, DataProvider.getUrl()).
			then()
				.statusCode(401)
				.contentType(ContentType.JSON)
				.assertThat()				
				.body("errorCode", equalTo(401))
				.body("errorMessage", equalTo("Invalid credentials: You do not have access to this information.")).	
			extract()
				.response().asString()
		;

		step.log(Status.PASS, "Response =	> " + response);	    
		}catch (AssertionError | Exception e) {
	 		step.log(Status.FAIL, e.getMessage());
	 		throw e;
		}
	}
	

	private Response searchAllUser(String auth, String baseUrl) {		
		return given()
			.header("authorization", auth)
			.baseUri(baseUrl).
		when()
			.get("/users/all")
		;				 
	}
	
	
	

}
