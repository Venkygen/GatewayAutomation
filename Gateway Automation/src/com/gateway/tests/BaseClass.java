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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;
	public String filePath = null;
	
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	
	@BeforeMethod
	@Parameters({ "Url" })
	public void beforeMethod(Method method, String Url) {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		driver.get(Url);

//		Date date = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//		filePath="E://GatewayAutomation//Report" + dateFormat.format(date) + ".html";
		extent = new ExtentReports(getFilePath(), false);
		test = extent.startTest(method.getName());

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		extent.endTest(test);
		extent.flush();

	}

	@AfterSuite
	public void afterSuite() {
			
		

	}
	
	public String getFilePath(){
//		Date date = new Date();
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		return "E://GatewayAutomation//Report" + dateFormat.format(date) + ".html";
	}
}
