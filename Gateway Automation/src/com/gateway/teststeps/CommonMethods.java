package com.gateway.teststeps;

import org.openqa.selenium.WebDriver;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.CommonPage;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CommonMethods {

	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;
	private Screenshot sc;

	public CommonMethods(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
	}

	public void VerifyPolicyElements(String policyElementName) {
		try {
			String policyElement = policyElementName.toUpperCase();

			switch (policyElement) {
			case "ANALYTICS":
				if (act.isDisplayed(CommonPage.analytics)) {
					test.log(LogStatus.PASS, policyElement + " Present");
				} else {
					test.log(LogStatus.FAIL, policyElement + " not found");
				}
				break;

			case "AUTHENTICATION":
				if (act.isDisplayed(CommonPage.authentication)) {
					test.log(LogStatus.PASS, policyElement + " Present");
				} else {
					test.log(LogStatus.FAIL, policyElement + " not found");
				}
				break;

			case "APPS LIMIT":
				if (act.isDisplayed(CommonPage.appsLimit)) {
					test.log(LogStatus.PASS, policyElement + " Present");
				} else {
					test.log(LogStatus.FAIL, policyElement + " not found");
				}
				break;
			case "CUSTOM":
				if (act.isDisplayed(CommonPage.customRequest)) {
					test.log(LogStatus.PASS, policyElement + " Present");
				} else {
					test.log(LogStatus.FAIL, policyElement + " not found");
				}
				break;
			

			default: // Optional
				// Statements
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
