package com.gateway.teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PackagesPage;
import com.gateway.repository.PortalDevelopersPage;
import com.gateway.repository.PortalPlansPage;
import com.gateway.repository.PortalSubscriptionsPage;
import com.gateway.utility.PropertiesFile;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Subscriptions {

	String envName = PropertiesFile.GetProperty("envName");

	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;
	private Screenshot sc;

	public Subscriptions(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
	}


	public void verifySubscription(String planName) {

		By by = By.xpath(".//a[@name='planName' and contains(text(),'"+planName+"')]");
		if (act.isDisplayed(by)) {
			test.log(LogStatus.PASS, planName + " is found");
		} else {
			test.log(LogStatus.FAIL, planName + " is not found");
		}
	}	
		public void unSubscribe(String planName) {

			By by = By.xpath("//*[@name='mySubscriptionsList']//div[@name='"+planName+"']//i[@name='unsubscribe']");
			if (act.isDisplayed(by)) {
				act.click(by);
				
				if(act.isDisplayed(PortalSubscriptionsPage.unsubscribeform)){
					act.click(PortalSubscriptionsPage.btn_confirm);
				}
				
				act.VerifyToast();
				
			} else {
				test.log(LogStatus.FAIL, planName + " is not found");
			}

	}


		public void verifySubscriptionNotFound(String planName) {

			By by = By.xpath(".//a[@name='planName' and contains(text(),'"+planName+"')]");
			if (act.isDisplayed(by)) {
				test.log(LogStatus.FAIL, planName + " is found");
			} else {
				test.log(LogStatus.PASS, planName + " is not found");
			}
		}
}
