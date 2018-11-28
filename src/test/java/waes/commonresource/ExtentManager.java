package waes.commonresource;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * The ExtentManager is a class that manager the report configuration, all the setup of report and his instance is created here
 * It will be used for all test cases.
 * 
 * @author Leonardo Santos
 */

public class ExtentManager {

    private static ExtentReports repoExtent;
    
    public static ExtentReports getInstance() {
    	if (repoExtent == null)
    		createInstance(System.getProperty("user.dir"));
    	
        return repoExtent;
    }
    
    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter hReporter = new ExtentHtmlReporter(fileName);
        
        hReporter.config().setDocumentTitle("WAES - Leo");
        hReporter.config().setReportName("Assignemnt Leonardo - Waes - Report Tests");
        hReporter.config().setTheme(Theme.DARK);
        hReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        hReporter.config().setFilePath(System.getProperty("user.dir"));
        
        repoExtent = new ExtentReports();
        repoExtent.attachReporter(hReporter);
        
        return repoExtent;
    }
}
