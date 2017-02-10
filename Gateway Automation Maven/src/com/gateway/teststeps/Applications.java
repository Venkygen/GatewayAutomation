package com.gateway.teststeps;

import org.apache.tools.ant.taskdefs.Sync.MyCopy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PackagesPage;
import com.gateway.repository.PortalApplicationsPage;
import com.gateway.repository.PortalDevelopersPage;
import com.gateway.repository.PortalPlansPage;
import com.gateway.utility.PropertiesFile;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Applications {

	String envName = PropertiesFile.GetProperty("envName");

	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;
	private Screenshot sc;

	public Applications(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
	}

	public void verifyApp(String appName) {

		By by = By.xpath("//a[@name='appName' and contains(text(),'" + appName + "')]");
		if (act.isDisplayed(by)) {
			test.log(LogStatus.PASS, appName + " is found");
		} else {
			test.log(LogStatus.FAIL, appName + " is not found");
		}

	}

	public void verifyAppNotFound(String appName) {

		By by = By.xpath("//a[@name='appName' and contains(text(),'" + appName + "')]");
		if (act.isDisplayed(by)) {
			test.log(LogStatus.FAIL, appName + " is found");
		} else {
			test.log(LogStatus.PASS, appName + " is not found");
		}

	}
}
