package com.gateway.tests;

import org.testng.annotations.Test;

import com.gateway.teststeps.LoginToApplication;
import com.gateway.teststeps.Portal;
import com.gateway.utility.PropertiesFile;

public class HappyPathPortalTests extends BaseClass {

	@Test(priority = 0)
	public void SubscribePlan() throws Exception {
		LoginToApplication lb = new LoginToApplication(driver, test);
		Portal portal = new Portal(driver, test);
		
		String planName = PropertiesFile.GetProperty("planName");
		String appName = PropertiesFile.GetProperty("appName");
		String appDescription = PropertiesFile.GetProperty("appDescription");
		String appType = PropertiesFile.GetProperty("appType");
		String appUri = PropertiesFile.GetProperty("appUri");
		
		String enterpriseName =  "wavemaker";
		
		lb.loginToPortal("venkatesh.ladi@wavemaker.com", "pramati123");
		portal.selectEnterprise(enterpriseName);
		portal.NavigateToPage("API Plans");
		portal.searchAndVerifyPlan(planName);
		portal.subscribeAndCreateApp(appName, appDescription, appType, appUri);
		portal.VerifyApp(appName);

	}


}
