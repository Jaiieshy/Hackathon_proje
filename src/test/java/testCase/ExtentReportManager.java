package testCase;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import Base.base;

//import testCase.TestCase;


public class ExtentReportManager extends base implements ITestListener{
	//UI of the report
	public ExtentSparkReporter sparkReporter;
	//populate common info on the report
	public ExtentReports extent;
	//creating test case entries in the report and update status of the test methods
	public ExtentTest test;
	String repName;
	public void onStart(ITestContext context) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\reports\\myReport.html");
		sparkReporter.config().setDocumentTitle("Display_Bookshelf_Automation");
		sparkReporter.config().setReportName("Display_Bookshelf_Testing");
		sparkReporter.config().setTheme(Theme.STANDARD);
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
 
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QEA");
		extent.setSystemInfo("Tester Name","Jayesh Jain");
		extent.setSystemInfo("OS","Windows11");
		extent.setSystemInfo("Browser Name","Chrome Browser");
		
	}
	public void onTestSuccess(ITestResult result) {
		//logger.info("checkout validation");
		test=extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case Passed is: "+result.getName());
		logger.info("Passed" + result.getName());
		try 
		{
			String screenshotpath = base.screenShot(result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed is: "+result.getName());
		test.log(Status.FAIL, "Test Case Failed cause is: "+result.getThrowable());
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped is: "+result.getName());	
	}
	public void onFinish(ITestContext context) {
		extent.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}