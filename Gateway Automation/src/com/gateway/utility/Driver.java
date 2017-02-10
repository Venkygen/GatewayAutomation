package com.gateway.utility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Driver {
	
	public  static WebDriver driver;


	public static ExtentReports extent;
	public static ExtentTest test;
	public static String filePath = "E://GatewayAutomation//GatewayAutomation.html";
	
	static {			
		extent= new ExtentReports(filePath, false);
		test = extent.startTest("My First Test", "Sample description"); 
	}
	
//	public Driver(){
//		ProfilesIni allProfiles = new ProfilesIni();
//		FirefoxProfile myProfile = allProfiles.getProfile("default");
//		myProfile.setAcceptUntrustedCertificates(true);
//		myProfile.setAssumeUntrustedCertificateIssuer(true);
//		driver = new FirefoxDriver(myProfile);
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
//	
//	}
	
	public static WebDriver getDriver() {
		return driver;
		
	}
	
	public static ExtentReports getReporter() {
		return extent;
		
	}

	public static ExtentTest getTest() {
		return test;
	}
//	public synchronized static ExtentReports getReporter(String filePath) {
//		if (extent == null) {
//			extent = new ExtentReports(filePath, true);
//
//			extent.addSystemInfo("Environment", "QA");
//		}
//
//		return extent;
//	}

//	public void StartTest(String testName) {
//		test = extent.startTest("firsttest");
//	}

	@Test()
	public void dummy(){
		System.out.println("dummy test");
		
	}
	  
	  @AfterTest
    protected void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            test.log(LogStatus.PASS, "Test passed");
        }
        
        extent.endTest(test);        
        extent.flush();
    }
    
//    @BeforeSuite
//    public void beforeSuite() {
//        extent = Driver.getReporter();
//        extent.startTest("firsttest");
//    }
    
    @AfterSuite
    protected void afterSuite() {
        extent.close();
    }
}
