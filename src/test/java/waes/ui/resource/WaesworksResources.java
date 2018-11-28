package waes.ui.resource;

/**
 * The WaesworksResources is a interface that manager all the input data for the UI tests, it could be easy changed for other environments just have other interface like "ENV1".
 * 
 * @author Leonardo Santos
 */

public interface WaesworksResources {	
	
	public interface ENV1{
		
		String ENV = "ENV1";

		String URL_WAESWORKS = "https://waesworks.bitbucket.io/";
		
		
		//users		
		String ADMIN[] = {"admin","hero","a.admin@wearewaes.com","Amazing Admin","Change the course of a waterfall."};
		String DEV[] = {"dev","wizard","zd.dev@wearewaes.com","Zuper Dooper Dev","Debug a repellent factory storage."};
		String TESTER[] = {"tester","maniac","as.tester@wearewaes.com","Al Skept-Cal Tester","Voltage AND Current."};
		String WRONG[] = {"leoleo","test"};
		
		
		//Login Page
		String LOGIN_LINK_XPATH = "//*[@id=\"login_link\"]";
		String USER_FIELD_ID = "username_input";
		String PWD_FIELD_ID = "password_input";
		String LOGIN_BTN_ID = "login_button";
		
		//Welcome Page
		String LOGGED_EMAIL_PATH = "//*[@id=\"status\"]/p";
		String LOGGED_NAME_PATH = "//*[@id=\"status\"]/p";
		String LOGGED_NAME_WTEXT_PATH = "//*[@id=\"___gatsby\"]/div/div/main/div[2]/section/p[1]";
		String LOGGED_POWER_PATH = "//*[@id=\"___gatsby\"]/div/div/main/div[2]/section/p[2]";
		String LOGGED_ADMIN_LIST_TEXT_PATH = "//*[@id=\"___gatsby\"]/div/div/main/div[2]/section/div/p";
		String LOGGED_ADMIN_LIST_TEXT = "This is a list of users for you:";
		String LOGGED_ADMIN_LIST_TABLE_PATH = "//*[@id=\"users_list_table\"]/tbody/tr";
		
		
		//Logout
		String LOGOUT_XPATH = "//*[@id=\"status\"]/p/a";
		String LOGOUT_TEXT_XPATH = "//*[@id=\"status\"]/p";
		String LOGOUT_TEXT = "To get the full hero experience, you’ll need to log in.";
		
		//Wrong Credentials
		String WRONGC_TEXT_PATH ="//*[@id=\"status\"]/p";
		String WRONGC_TEXT = "Wrong credentials. You can do it, try again!";
						
		//Signup Page
		String SIGNUP_LINK_XPATH = "//*[@id=\"signup_link\"]";
		String SIGNUP_USER_FIELD_ID = "username_input";
		String SIGNUP_PWD_FIELD_ID = "password_input";
		String SIGNUP_NAME_FIELD_ID = "name_input";
		String SIGNUP_EMAIL_FIELD_ID = "email_input";
		String SIGNUP_DOB_DAY_ID = "day_select";
		String SIGNUP_DOB_MON_ID = "month_select";
		String SIGNUP_DOB_YEA_ID = "year_select";
		String SIGNUP_SUBMIT_BTN_ID = "submit_button";
		
		//SignUp Users
		String NEW1[] = {"leotest","senha123","leo_test@wearewaes.com","Leonardo Santos","1","May","1990"};
		String NEW2[] = {"a","a","a@a.com","a","1","May","1995"};
		
		//Profile Page
		String PROFILE_EMAIL_PATH = "//*[@id=\"status\"]/p";
		String PROFILE_NAME_PATH = "//*[@id=\"status\"]/p";
		String PROFILE_MESSAGE_PATH = "//*[@id=\"___gatsby\"]/div/div/main/div[2]/section/p";
		
		//Details Page
		String DETAILS_XPATH_LINK = "//*[@id=\"details_link\"]";
		String DETAILS_NAME_XPATH = "//*[@id=\"___gatsby\"]/div/div/main/div[2]/section/ul/li[1]";
		String DETAILS_EMAIL_XPATH = "//*[@id=\"___gatsby\"]/div/div/main/div[2]/section/ul/li[2]";
		
	}
	
	
	
}
