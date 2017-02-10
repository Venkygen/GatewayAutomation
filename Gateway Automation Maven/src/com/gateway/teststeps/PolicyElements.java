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

	public void Metering(String MetertingHits, String MeteringPayload) {
		try {
			act.click(PolicyElementsPage.metering);
			act.click(PolicyElementsPage.btn_addPolicyElement);
			String splitHits[] = MetertingHits.split(";");
			if (splitHits.length > 0) {
				act.click(PolicyElementsPage.btn_Hits);
				for (int i = 0; i < splitHits.length; i++) {
					act.Select(PolicyElementsPage.meteringhitType, splitHits[i].trim().toString());
					act.click(PolicyElementsPage.btn_Save);
					act.click(PolicyElementsPage.btn_addPolicyElement);
				}
			}

			String splitMetering[] = MeteringPayload.split(";");
			if (splitMetering.length > 0) {

				for (int j = 0; j < splitMetering.length; j++) {
					act.click(PolicyElementsPage.btn_PayLoad);
					act.Select(PolicyElementsPage.meteringPayloadType, splitMetering[j].trim().toString());
					test.log(LogStatus.INFO, splitMetering[j].trim().toString() + " metering policy Element created");
					act.click(PolicyElementsPage.btn_Save);
					act.click(PolicyElementsPage.btn_addPolicyElement);
				}
			}

			act.click(PolicyElementsPage.btn_showAll);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Analytics(String Analytics) {

		try {

			act.click(PolicyElementsPage.analytics);

			if (Analytics.equalsIgnoreCase("TRUE")) {
				act.click(PolicyElementsPage.btn_YES);
			} else {
				act.click(PolicyElementsPage.btn_NO);
			}
			test.log(LogStatus.INFO, "Analytics policy Element created");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void Authentication(String Authentication, String AuthProvider) {
		try {

			act.click(PolicyElementsPage.authentication);

			if (Authentication.equalsIgnoreCase("OAUTH2")) {

				act.Select(PolicyElementsPage.authenticationType, Authentication);
				act.Select(PolicyElementsPage.authProvider, AuthProvider);

			} else {
				act.Select(PolicyElementsPage.authenticationType, Authentication);

			}

			test.log(LogStatus.INFO, "Authentication policy Element created");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Ratelimit(String HitsRateLimit) {

		try {

			act.click(PolicyElementsPage.rateLimit);
			act.click(PolicyElementsPage.btn_addPolicyElement);
			String[] splitHitsRatelimit = HitsRateLimit.split(";");
			act.click(PolicyElementsPage.btn_Hits);
			int i = 0;
			act.Select(PolicyElementsPage.rl_target, splitHitsRatelimit[i].trim().toString());
			act.Select(PolicyElementsPage.rl_hitType, splitHitsRatelimit[i + 1].trim().toString());
			act.setText(PolicyElementsPage.rl_frequency, splitHitsRatelimit[i + 2].trim().toString());
			act.Select(PolicyElementsPage.rl_frequencyUnit, splitHitsRatelimit[i + 3].trim().toString());

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
	
	public void RatelimitForTemplate(String HitsRateLimit) {

		try {
				
			
			act.click(PolicyElementsPage.rateLimit);
			act.click(PolicyElementsPage.btn_addPolicyElement);
			String[] splitHitsRatelimit = HitsRateLimit.split(";");
						
			act.click(PolicyElementsPage.btn_Hits);
			int i = 0;
			act.Select(PolicyElementsPage.rl_hitType, splitHitsRatelimit[i + 1].trim().toString());
			act.setText(PolicyElementsPage.rl_frequency, splitHitsRatelimit[i + 2].trim().toString());
			act.Select(PolicyElementsPage.rl_frequencyUnit, splitHitsRatelimit[i + 3].trim().toString());

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
