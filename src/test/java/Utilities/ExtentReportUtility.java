package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.Baseclass;

public class ExtentReportUtility {
	
	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // update status of the test methods
	private String timestamp;

	public void onStart(ITestContext context) {
		
	  //SimpleDateFormat sd=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	  //Date dt=new Date();
	  //String timestamp=sd.format(dt);
	  String timestamp1=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/"+"Testreport"+"_"+timestamp+".html");//specify location of the report
		sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);		
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","laxminarayana");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");					
	}


	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName()); // create a new enty in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s
		
	}

	public void onTestFailure(ITestResult result) throws IOException {
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 
		new Baseclass().captureScreenshot(result.getName());
					
	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
		
	}

	
	public void onFinish(ITestContext context) {
		
		extent.flush();

}
}
