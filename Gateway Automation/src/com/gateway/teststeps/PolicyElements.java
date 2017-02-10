package com.gateway.teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PolicyElementsPage;
import com.gateway.utility.PropertiesFile;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PolicyElements {
	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;

	public PolicyElements(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
	}

	String Analytics = PropertiesFile.GetProperty("Analytics");
	String Authentication = PropertiesFile.GetProperty("Authentication");
	String AuthProvider = PropertiesFile.GetProperty("AuthProvider");
	String ConfigureFlows = PropertiesFile.GetProperty("ConfigureFlows");
	String MetertingHits = PropertiesFile.GetProperty("MetertingHits");
	String MeteringPayload = PropertiesFile.GetProperty("MeteringPayload");
	String HitsRateLimit = PropertiesFile.GetProperty("HitsRateLimit");

	public void Metering() {
		try {

			act.click(PolicyElementsPage.metering);

			act.click(PolicyElementsPage.btn_addPolicyElement);

			String splitHits[] = MetertingHits.split(";");
			if (splitHits.length > 0) {

				act.click(PolicyElementsPage.btn_Hits);

				for (int i = 0; i < splitHits.length; i++) {
					Select type = new Select(
							driver.findElement(By.xpath(".//*[@id='policyElementAttrs']//select[@name='hitType']")));
					type.selectByVisibleText(splitHits[i].trim().toString());
					act.click(PolicyElementsPage.btn_Save);
					act.click(PolicyElementsPage.btn_addPolicyElement);

				}
			}

			String splitMetering[] = MeteringPayload.split(";");
			if (splitMetering.length > 0) {

				for (int j = 0; j < splitMetering.length; j++) {
					act.click(PolicyElementsPage.btn_PayLoad);
					Select type = new Select(driver.findElement(
							By.xpath(".//*[@id='policyElementAttrs']//select[@name='meteringPayloadType']")));
					type.selectByVisibleText(splitMetering[j].trim().toString());
					test.log(LogStatus.INFO, splitMetering[j].trim().toString() + " metering policy Element created");
					act.click(PolicyElementsPage.btn_Save);
					act.click(PolicyElementsPage.btn_addPolicyElement);
				}
			}

			act.click(PolicyElementsPage.btn_showAll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Analytics() {

		try {

			act.click(PolicyElementsPage.analytics);

			if (Analytics.equalsIgnoreCase("TRUE")) {
				act.click(PolicyElementsPage.btn_YES);
			} else {
				act.click(PolicyElementsPage.btn_NO);
			}
			test.log(LogStatus.INFO, "Analytics policy Element created");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Authentication() {
		try {

			act.click(PolicyElementsPage.authentication);

			if (Authentication.equalsIgnoreCase("OAUTH2")) {

				Select authType = new Select(driver
						.findElement(By.xpath(".//*[@id='policyElementAttrs']//select[@name='authenticationType']")));
				authType.selectByVisibleText(Authentication);

				Select authProvider = new Select(
						driver.findElement(By.xpath(".//*[@id='policyElementAttrs']//select[@name='authProvider']")));
				authProvider.selectByVisibleText(AuthProvider);

			} else {
				Select authType = new Select(driver
						.findElement(By.xpath(".//*[@id='policyElementAttrs']//select[@name='authenticationType']")));
				authType.selectByVisibleText(Authentication);

			}

			test.log(LogStatus.INFO, "Authentication policy Element created");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Ratelimit() {

		try {

			act.click(PolicyElementsPage.rateLimit);

			act.click(PolicyElementsPage.btn_addPolicyElement);

			String[] splitHitsRatelimit = HitsRateLimit.split(";");

			act.click(PolicyElementsPage.btn_Hits);

			int i = 0;

			Select target = new Select(
					driver.findElement(By.xpath(".//*[@id='policyElementAttrs']//select[@name='target']")));
			target.selectByVisibleText(splitHitsRatelimit[i].trim().toString());

			Select hitType = new Select(
					driver.findElement(By.xpath(".//*[@id='policyElementAttrs']/div[1]//select[@name='hitType']")));
			hitType.selectByVisibleText(splitHitsRatelimit[i + 1].trim().toString());

			act.setText(PolicyElementsPage.frequency, splitHitsRatelimit[i + 2].trim().toString());

			Select frequencyUnit = new Select(
					driver.findElement(By.xpath(".//*[@id='policyElementAttrs']//select[@name='frequencyUnit']")));
			frequencyUnit.selectByVisibleText(splitHitsRatelimit[i + 3].trim().toString());

			if (splitHitsRatelimit[i + 4].trim().toString().equalsIgnoreCase("YES")) {
				act.click(PolicyElementsPage.btn_enableSoft);
				act.setText(PolicyElementsPage.notifyEmailAddresses, splitHitsRatelimit[i + 5].trim().toString());

				act.click(PolicyElementsPage.btn_Save);

			}

			test.log(LogStatus.INFO, "RateLimit policy Element created");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void AppsLimit() {
		try {

			act.click(PolicyElementsPage.appsLimit);
			test.log(LogStatus.INFO, "Apps limit policy Element created");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
