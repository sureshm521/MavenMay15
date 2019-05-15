package MavenGIT.MavenMay15;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extentreportgen {
	ExtentReports extent;
	ExtentTest logger;
	@BeforeTest
	public void startTest()
	{
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/STMExtentReport.html", true);
		extent.addSystemInfo("Environment","Environment Name");
		extent.addSystemInfo("Host Name", "SoftwareTestingMaterial")
		.addSystemInfo("Environment", "Automation Testing")
		.addSystemInfo("User Name", "Rajkumar SM");
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	@Test
	public void passTest()
	{
		logger=extent.startTest("Pass test case");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test case1 is passed");
	}
	public void failTest()
	{
		logger=extent.startTest("Fail test case");
		Assert.assertTrue(false);
		logger.log(LogStatus.FAIL, "Test case2 is failed");;
	}
	public void skipTest()
	{
		logger=extent.startTest("Skip test");
		throw new SkipException("Skip test is not ready for testing");
	}
	@AfterMethod
	public void result(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL,"Test case Failed is:"+result.getName());
			logger.log(LogStatus.FAIL, "Test case Failed is:"+result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(LogStatus.SKIP, "Skipped test cases is:"+result.getName());
		}
		extent.endTest(logger);
	}
	@AfterTest
	public void endTest()
	{
		extent.flush();
		extent.close();
	}
}
