package com.gateway.tests;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.gateway.utility.Driver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public String filePath = null;

	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");
	
	Driver dr = new Driver();
	
	@BeforeMethod
	@Parameters({ "Url", "Browser" })
	public void beforeMethod(Method method, String Url, String Browser) {

		
		this.driver = dr.initializeBrowser(Url, Browser);

		extent = new ExtentReports(getFilePath(), false);
		test = extent.startTest(method.getName());

	}

	@AfterMethod
	public void afterMethod() {
		
		dr.closeAllDriver();
		extent.endTest(test);
		extent.flush();
	
	}

	@AfterSuite
	public void afterSuite() {

	}

	public String getFilePath() {

		return "E://GatewayAutomation//Report" + dateFormat.format(date) + ".html";
	}
}
