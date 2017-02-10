package com.gateway.teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PortalLandingPage;
import com.gateway.utility.PropertiesFile;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Portal {

	String envName = PropertiesFile.GetProperty("envName");

	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;
	private Screenshot sc;

	public Portal(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
	}

	public void NavigateToPage(String PageName) {

		act.click(By.xpath(".//nav[@id='navbar']//a[contains(text(),'" + PageName + "')]"));
	}

	public void subscribeAndCreateApp(String appName, String appDescription, String appType, String appUri) {

		String redirectUri1 = "https://stage-gw.wavemakeronline.com/oauth-client/authorization_callback";
		String redirectUri2 = "https://stage-gw.wavemakeronline.com/oauth-client/callback.jsp";
		act.click(PortalLandingPage.subscribe);
		act.setText(PortalLandingPage.appName, appName);
		act.setText(PortalLandingPage.appDescription, appDescription);
		act.setText(PortalLandingPage.appType, appType);
		act.setText(PortalLandingPage.appUri, appUri);
		act.setTextAndEnter(PortalLandingPage.redirectUri, redirectUri1);
		act.setTextAndEnter(PortalLandingPage.redirectUri, redirectUri2);
		act.click(PortalLandingPage.btn_RegisterApp);

	}

	public void VerifyApp(String appName) {
		if (act.isDisplayed(By.xpath(".//*[@id='registeredApps']//ul/li[contains(text(),'" + appName + "')]"))) {
			act.verifyActualExpected(act.getText(PortalLandingPage.verifyAppName), appName);
			test.log(LogStatus.PASS, appName + " Found");
			test.log(LogStatus.INFO, "ClientID: " + act.getText(PortalLandingPage.verifyAppClientID));
			test.log(LogStatus.INFO, "Client Secret: " + act.getText(PortalLandingPage.verifyAppClientSecret));
			test.log(LogStatus.PASS, appName + " Found");
		} else {
			test.log(LogStatus.FAIL, appName + " not Found");
		}

	}

	public void selectEnterprise(String enterpriseName) {

		if (act.isDisplayed(By.xpath(".//*[@id='chooseEnterprises']"))) {
			act.click(By.xpath(".//*[@id='entList']//div[contains(text(),'" + enterpriseName + "')]"));
			test.log(LogStatus.PASS, "Selected " + enterpriseName);
		} else {
			test.log(LogStatus.INFO, "Enterprise page not displayed");
		}

	}

	public void searchAndVerifyPlan(String planName) {
		try {

			if (act.isDisplayed(PortalLandingPage.apiPlansList)) {
				Thread.sleep(1500);
				act.click(By.xpath(".//*[@id='apiPlansList']//span[@name='" + planName + "']"));
			}

			act.waitForPageToLoad(
					By.xpath(".//div[contains(@class,'entity-details')]//p[contains(text(),'" + planName + "')]"));

		} catch (Exception e) {
			test.log(LogStatus.FAIL, planName + " plan not found");
			test.log(LogStatus.FAIL, planName + " plan not found", test.addScreenCapture(sc.getSnap()));
			e.printStackTrace();
		}
	}

}
