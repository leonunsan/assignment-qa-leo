# assignment-qa-leo
# This is a automation project results of assignment for WAES

The tests of this automation covers Rest Backend and Front-End as information below


## Rest Backend API
 
  | Method        | Endpoint          | Description         |
  | ------------- | ---------------------------- | ------------------------ |
  | GET           | /waesheroes/api/v1/users/details?username=<username> | http endpoint to retrieve user information  |
  | GET           | /waesheroes/api/v1/users/all | http endpoint to retrieve information from all users (requires Basic Auth) |
  | GET           | /waesheroes/api/v1/users/access | http endpoint to log in (requires Basic Auth) |
  | POST          | /waesheroes/api/v1/users | http endpoint to sign-up |
  | PUT           | /waesheroes/api/v1/users | http endpoint to update user information (requires Basic Auth) |
  | DELETE        | /waesheroes/api/v1/users | http endpoint to delete user (requires Basic Auth) |
  
## Front-End
[WAESWORKS](https://waesworks.bitbucket.io/)



## How To Run

###Needed

  **Java**
  
  **Gradle 4.9+**
  
  
### Run All Tests
	gradle test --tests RunAllTests  

### Run RestAPI Tests
	gradle test --tests RunAllTests.*restTest*   
  
### Run UI Tests  
	gradle test --tests RunAllTests.*uiTest*
	
	
### Test Report
assignment-qa-leo/**Waesworks - Report Tests.html**