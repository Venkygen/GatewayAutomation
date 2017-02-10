package com.gateway.tests;

import org.testng.annotations.Test;

import com.gateway.teststeps.LoginToApplication;
import com.gateway.teststeps.Portal;
import com.gateway.teststeps.ApiPlans;
import com.gateway.teststeps.Applications;
import com.gateway.teststeps.Developers;
import com.gateway.teststeps.RestService;
import com.gateway.teststeps.Subscriptions;
import com.gateway.utility.PropertiesFile;

public class HappyPathPortalTests extends BaseClass {

	@Test(priority = 0)
	public void SubscribePlan() throws Exception {
		LoginToApplication lb = new LoginToApplication(driver, test);
		ApiPlans apiPlans = new ApiPlans(driver, test);
		Applications applications = new Applications(driver, test);

		String planName = PropertiesFile.GetProperty("planName");
		String appName = PropertiesFile.GetProperty("appName");
		String appDescription = PropertiesFile.GetProperty("appDescription");
		String appType = PropertiesFile.GetProperty("appType");
		String appUri = PropertiesFile.GetProperty("appUri");

		String enterpriseName = "wavemaker";

		lb.loginToPortal("venkatesh.ladi@wavemaker.com", "pramati123");
		apiPlans.selectEnterprise(enterpriseName);
		apiPlans.NavigateToPage("API Plans");
		apiPlans.searchAndVerifyPlan(planName);
		apiPlans.subscribeAndCreateApp(appName, appDescription, appType, appUri);
		apiPlans.VerifyApp(appName);
		apiPlans.NavigateToPage("Applications");
		applications.verifyApp(appName);

	}

	@Test(priority = 1)
	public void RuntimeHit_get() throws InterruptedException {

		String hostname = PropertiesFile.GetProperty("hostnameValue");
		String Uri_Get = "http://" + hostname + ".stage-gw.wavemakeronline.com/v2/store/inventory";

		LoginToApplication lb = new LoginToApplication(driver, test);
		ApiPlans apiPlans = new ApiPlans(driver, test);
		RestService rs = new RestService(test);
		String planName = PropertiesFile.GetProperty("planName");
		String appName = PropertiesFile.GetProperty("appName");
		String enterpriseName = "wavemaker";

		lb.loginToPortal("venkatesh.ladi@wavemaker.com", "pramati123");
		apiPlans.selectEnterprise(enterpriseName);
		apiPlans.NavigateToPage("API Plans");
		apiPlans.searchAndVerifyPlan(planName);
		apiPlans.VerifyApp(appName);
		rs.doGet(apiPlans.getClientId(appName), apiPlans.getClientSecret(appName), Uri_Get);

	}

	@Test(priority = 2)
	public void AddDeveloper() throws Exception {
		LoginToApplication lb = new LoginToApplication(driver, test);
		ApiPlans apiPlans = new ApiPlans(driver, test);
		Developers developers = new Developers(driver, test);
		Applications applications = new Applications(driver, test);
		String appName = PropertiesFile.GetProperty("appName");
		String developer = "venkatesh.ladi+test@wavemaker.com";
		String enterpriseName = "wavemaker";

		lb.loginToPortal("venkatesh.ladi@wavemaker.com", "pramati123");
		apiPlans.selectEnterprise(enterpriseName);
		apiPlans.NavigateToPage("Developers");
		developers.addDeveloper(developer, appName);
		developers.verifyDeveloper(developer, appName);
		lb.logoutFromPortal();
		lb.loginToPortal(developer, "pramati123");
		apiPlans.selectEnterprise(enterpriseName);
		apiPlans.NavigateToPage("Applications");
		applications.verifyApp(appName);
		lb.logoutFromPortal();
	}

	@Test(priority = 3)
	public void deleteDeveloper() throws Exception {
		LoginToApplication lb = new LoginToApplication(driver, test);
		ApiPlans apiPlans = new ApiPlans(driver, test);
		Developers developers = new Developers(driver, test);
		Applications applications = new Applications(driver, test);
		new Applications(driver, test);
		String appName = PropertiesFile.GetProperty("appName");
		String developer = "venkatesh.ladi+test@wavemaker.com";
		String enterpriseName = "wavemaker";

		lb.loginToPortal("venkatesh.ladi@wavemaker.com", "pramati123");
		apiPlans.selectEnterprise(enterpriseName);
		apiPlans.NavigateToPage("Developers");
		developers.verifyDeveloper(developer, appName);
		developers.deleteDeveloper(developer, appName);
		developers.verifyDeveloperNotFound(developer, appName);
		lb.logoutFromPortal();
		lb.loginToPortal(developer, "pramati123");
		apiPlans.selectEnterprise(enterpriseName);
		apiPlans.NavigateToPage("Applications");
		applications.verifyAppNotFound(appName);
		lb.logoutFromPortal();
	}

	@Test(priority = 4)
	public void UnsubscribePlan() throws Exception {
		LoginToApplication lb = new LoginToApplication(driver, test);
		ApiPlans apiPlans = new ApiPlans(driver, test);
		Subscriptions subscriptions = new Subscriptions(driver, test);
		Applications applications = new Applications(driver, test);
		String appName =PropertiesFile.GetProperty("appName");
		String enterpriseName = "wavemaker";
		String planName = PropertiesFile.GetProperty("planName");

		lb.loginToPortal("venkatesh.ladi@wavemaker.com", "pramati123");
		apiPlans.selectEnterprise(enterpriseName);
		apiPlans.NavigateToPage("Subscriptions");
		subscriptions.verifySubscription(planName);
		subscriptions.unSubscribe(planName);
		subscriptions.verifySubscriptionNotFound(planName);
		apiPlans.NavigateToPage("Applications");
		applications.verifyAppNotFound(appName);
		lb.logoutFromPortal();
	}
}
