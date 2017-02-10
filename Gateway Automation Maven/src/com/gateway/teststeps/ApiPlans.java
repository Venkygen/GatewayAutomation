package com.gateway.teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PortalPlansPage;
import com.gateway.utility.PropertiesFile;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ApiPlans {

	String envName = PropertiesFile.GetProperty("envName");

	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;
	private Screenshot sc;

	private String clientID = null;

	private String clientSecret = null;

	public ApiPlans(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
	}

	public void NavigateToPage(String PageName) {

		try {
			act.click(By.xpath(".//nav[@id='navbar']//a[contains(text(),'" + PageName + "')]"));
			test.log(LogStatus.PASS, "User navigated to " + PageName + " page");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "User navigation to " + PageName + " failed");
			e.printStackTrace();
		}
	}

	public void subscribeAndCreateApp(String appName, String appDescription, String appType, String appUri) {

		try {
			String redirectUri1 = "https://stage-gw.wavemakeronline.com/oauth-client/authorization_callback";
			String redirectUri2 = "https://stage-gw.wavemakeronline.com/oauth-client/callback.jsp";
			act.click(PortalPlansPage.subscribe);
			act.setText(PortalPlansPage.appName, appName);
			act.setText(PortalPlansPage.appDescription, appDescription);
			act.setText(PortalPlansPage.appType, appType);
			act.setText(PortalPlansPage.appUri, appUri);
			act.setTextAndEnter(PortalPlansPage.redirectUri, redirectUri1);
			act.setTextAndEnter(PortalPlansPage.redirectUri, redirectUri2);
			act.click(PortalPlansPage.btn_RegisterApp);
			test.log(LogStatus.PASS, appName + " is successfully created");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, appName + " creation failed");
			e.printStackTrace();
		}

	}

	public void VerifyApp(String appName) {
		try {
			if (act.isDisplayed(By.xpath(".//*[@id='registeredApps']//li[contains(text(),'" + appName + "')]"))) {
				act.click(By.xpath(".//*[@id='registeredApps']//li[contains(text(),'" + appName + "')]"));
				act.verifyActualExpected(act.getText(PortalPlansPage.verifyAppName), appName);
				test.log(LogStatus.INFO, "ClientID: " + act.getText(PortalPlansPage.verifyAppClientID));
				test.log(LogStatus.INFO, "Client Secret: " + act.getText(PortalPlansPage.verifyAppClientSecret));

			} else {
				test.log(LogStatus.FAIL, appName + " not Found");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getClientId(String appName) {

		if (act.isDisplayed(By.xpath(".//*[@id='registeredApps']//li[contains(text(),'" + appName + "')]"))) {
			act.click(By.xpath(".//*[@id='registeredApps']//li[contains(text(),'" + appName + "')]"));
			clientID = act.getText(PortalPlansPage.verifyAppClientID).toString();

		} else {
			test.log(LogStatus.FAIL, appName + " not Found");
		}
		System.out.println(clientID);

		return clientID;
	}

	public String getClientSecret(String appName) {

		if (act.isDisplayed(By.xpath(".//*[@id='registeredApps']//li[contains(text(),'" + appName + "')]"))) {
			act.click(By.xpath(".//*[@id='registeredApps']//li[contains(text(),'" + appName + "')]"));
			clientSecret = act.getText(PortalPlansPage.verifyAppClientSecret).toString();

		} else {
			test.log(LogStatus.FAIL, appName + " not Found");
		}

		return clientSecret;
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

			if (act.isDisplayed(PortalPlansPage.apiPlansList)) {
				Thread.sleep(1500);
				act.click(By.xpath(".//*[@id='apiPlansList']//span[@name='" + planName + "']"));
			}

			act.waitForPageToLoad(
					By.xpath(".//div[contains(@class,'entity-details')]//p[contains(text(),'" + planName + "')]"));
			Thread.sleep(1500);

		} catch (Exception e) {
			test.log(LogStatus.FAIL, planName + " plan not found");
			test.log(LogStatus.FAIL, planName + " plan not found", test.addScreenCapture(sc.getSnap()));
			e.printStackTrace();
		}
	}

}
