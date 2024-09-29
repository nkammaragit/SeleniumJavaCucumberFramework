package testRunner;

import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
//    features = "E:\\Workspace-1\\July2024_BDDCucumberProject\\src\\test\\resources\\features",
    		features = "src/test/resources/features",
             glue = "stepDefinitions",
//       	    tags="@DDT",
            tags="@LoginTest",
//           	    comment ,
            
       	    
       	    		
          plugin = {"pretty", "html:target/cucumber-reports.html"}
    		)


public class TestRunner extends AbstractTestNGCucumberTests {
    // No need for @RunWith, simply extend AbstractTestNGCucumberTests
	  ExtentReports extent;
	    public static ExtentTest test;

	    @BeforeClass
	    public void setup() {
	        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        test = extent.createTest("Orange HRM", "Validate functionality");
	    }

	    @AfterClass
	    public void teardown() {
	        extent.flush();
	    }
}
