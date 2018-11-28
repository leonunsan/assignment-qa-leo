# assignment-qa-leo

This is an automation project result of assignment for WAES, it will cover Backend and Front-End tests as information provided described on assignment and shared below.



### Rest Backend API
 
  | Method        | Endpoint          | Description         |
  | ------------- | ---------------------------- | ------------------------ |
  | GET           | /waesheroes/api/v1/users/details?username=<username> | http endpoint to retrieve user information  |
  | GET           | /waesheroes/api/v1/users/all | http endpoint to retrieve information from all users (requires Basic Auth) |
  | GET           | /waesheroes/api/v1/users/access | http endpoint to log in (requires Basic Auth) |
  | POST          | /waesheroes/api/v1/users | http endpoint to sign-up |
  | PUT           | /waesheroes/api/v1/users | http endpoint to update user information (requires Basic Auth) |
  | DELETE        | /waesheroes/api/v1/users | http endpoint to delete user (requires Basic Auth) |
 
 
  
### Front-End
[WAESWORKS](https://waesworks.bitbucket.io/)



## How To Run

### Setup Needed

  **JAVA 8+ jdk**
  
  **Gradle 4.9+**
  
  
### Run All Tests
	gradle test --tests RunAllTests  


### Run RestAPI Tests
	gradle test --tests RunAllTests.*restTest*   
  
  
### Run UI Tests  
	gradle test --tests RunAllTests.*uiTest*
	
	
### Run UI Tests only on Chrome 
	gradle test --tests RunAllTests.*uiTest*chrome*


### Run UI Tests only on Firefox 
	gradle test --tests RunAllTests.*uiTest*firefox*

	
	
## Test Report
The Report is generate each execution on Path => assignment-qa-leo/**Waesworks - Report Tests.html**

The report have the following information about the test execution:
-  Graphs for Pass/Fail test cases
-  Graphs for Pass/Fail test steps
-  List of test cases with Pass/Fail
-  Each test case with list on test steps containing status Pass/Fail
-  Time of test start, test finish and duration



## Suggestion for Improvements
-  Implementation JUnit 5 Parallel Test Execution;
-  Implementation Seleium grid for escalation and setup for tests;
-  Replicate UI test cases for Internet explorer;
