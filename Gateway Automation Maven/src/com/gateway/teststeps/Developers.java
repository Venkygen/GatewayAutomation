package com.gateway.teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PackagesPage;
import com.gateway.repository.PortalDevelopersPage;
import com.gateway.repository.PortalPlansPage;
import com.gateway.utility.PropertiesFile;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Developers {

	String envName = PropertiesFile.GetProperty("envName");

	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;
	private Screenshot sc;

	public Developers(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
	}

	public void addDeveloper(String Developer, String appName) {
		try {
			if (act.isDisplayed(PortalDevelopersPage.developersHeader)) {

				act.setText(PortalDevelopersPage.email, Developer);
				act.click(By.xpath("//span[contains(text(),'"+Developer+"')]"));
				act.Select(PortalDevelopersPage.selectApplication, appName);
				act.click(PortalDevelopersPage.btn_addDeveloper);

				act.VerifyToast();

			} else {
				test.log(LogStatus.FAIL, "Developers page not found", test.addScreenCapture(sc.getSnap()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void verifyDeveloper(String Developer, String appName) {
		try {
			if (act.isDisplayed(PortalDevelopersPage.developersList)) {

				By by = By.xpath("//*[@id='developersList']//li[@name='" + Developer + "']//div[contains(text(),'"
						+ appName + "')]");
				if (act.isDisplayed(by)) {
					test.log(LogStatus.PASS, Developer + " is found");
				} else {
					test.log(LogStatus.FAIL, Developer + " is not found");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Tempalte Creation Failed: ", test.addScreenCapture(sc.getSnap()));
			e.printStackTrace();
		}

	}
	
	
	public void verifyDeveloperNotFound(String Developer, String appName) {
		try {
			if (act.isDisplayed(PortalDevelopersPage.developersList)) {

				By by = By.xpath("//*[@id='developersList']//li[@name='" + Developer + "']//div[contains(text(),'"
						+ appName + "')]");
				if (act.isDisplayed(by)) {
					test.log(LogStatus.FAIL, Developer + " is found");
				} else {
					test.log(LogStatus.PASS, Developer + " is not found");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Tempalte Creation Failed: ", test.addScreenCapture(sc.getSnap()));
			e.printStackTrace();
		}

	}

	public void deleteDeveloper(String Developer, String appName) {
		try {
			if (act.isDisplayed(PortalDevelopersPage.developersList)) {

				By by = By.xpath(".//*[@id='developersList']//li[@name='" + Developer + "']//div[contains(text(),'"
						+ appName + "')]/following-sibling::div/i");
				if (act.isDisplayed(by)) {
					act.click(by);
					if (act.isDisplayed(PortalDevelopersPage.removeDeveloperMsg)) {
						act.click(PortalDevelopersPage.btn_confirm);
						act.VerifyToast();

					}
				}

			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Tempalte Creation Failed: ", test.addScreenCapture(sc.getSnap()));
			e.printStackTrace();
		}
	}
}
