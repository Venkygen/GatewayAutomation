package com.gateway.tests;

import org.testng.annotations.Test;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PackagesPage;
import com.gateway.teststeps.Deploy;
import com.gateway.teststeps.Environments;
import com.gateway.teststeps.LoginToApplication;
import com.gateway.teststeps.Packages;
import com.gateway.teststeps.Plans;
import com.gateway.teststeps.QuickPublish;
import com.gateway.teststeps.SecurityAdmin;
import com.gateway.utility.PropertiesFile;

public class HappyPathTests extends BaseClass {

	@Test(priority = 0,enabled=false)
	public void packageTemplateCreation() throws InterruptedException {
		String templateName = "two";
		LoginToApplication lb = new LoginToApplication(driver, test);
		Packages api = new Packages(driver, test);
		String username = PropertiesFile.GetProperty("ApiCreatorUserName");
		String password = PropertiesFile.GetProperty("ApiCreatorPassword");

		lb.loginToLaunchPad(username, password);
		api.createpkgPolicyTemplate();
		api.SearchapiTemplate(templateName);
		api.VerifyPackagepolicyTemplate();

	}

	@Test(priority = 0,enabled=false)
	public void packageCreation() throws InterruptedException {

		LoginToApplication lb = new LoginToApplication(driver, test);
		Packages api = new Packages(driver, test);
		String username = PropertiesFile.GetProperty("ApiCreatorUserName");
		String password = PropertiesFile.GetProperty("ApiCreatorPassword");
		lb.loginToLaunchPad(username, password);
		api.GetStats();
		api.CreatePackage();
		api.SearchPackage();
		api.VerifyPackageBasicDetails();

	}

	@Test(priority = 1,enabled=false)
	public void environmentCreation() {
		try {

			LoginToApplication lb = new LoginToApplication(driver, test);
			Environments env = new Environments(driver, test);
			String username = PropertiesFile.GetProperty("OperationsManagerUserName");
			String password = PropertiesFile.GetProperty("OperationsManagerPassword");
			lb.loginToLaunchPad(username, password);
			env.CreateEnvironment();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test(priority = 0,enabled=false)
	public void quickPublish() throws InterruptedException {

		LoginToApplication lb = new LoginToApplication(driver, test);
		QuickPublish qp = new QuickPublish(driver, test);
		String username = PropertiesFile.GetProperty("ApiCreatorUserName");
		String password = PropertiesFile.GetProperty("ApiCreatorPassword");
		lb.loginToLaunchPad(username, password);
		String Url = "https://gateway-apps.wavemakeronline.com/corridor/index1.html";
		String prefixHostName = "marks";
		String name = "marksTest1";
		qp.createQuickPublish(Url, prefixHostName, name);
		qp.SearchQuickPublish("marks");

	}

	@Test(priority = 2,enabled=false)
	public void DeployPackageToEnvironment() throws InterruptedException {
		Packages api = new Packages(driver, test);
		CommonFunctions act = new CommonFunctions(driver, test);
		LoginToApplication lb = new LoginToApplication(driver, test);
		Deploy dply = new Deploy(driver, test);
		String username = PropertiesFile.GetProperty("OperationsManagerUserName");
		String password = PropertiesFile.GetProperty("OperationsManagerPassword");
		lb.loginToLaunchPad(username, password);
		act.click(PackagesPage.packagesLink);
		api.SearchPackage();
		dply.deploy();

	}

	@Test(priority = 3,enabled=false)
	public void planCreation() throws InterruptedException {
		LoginToApplication lb = new LoginToApplication(driver, test);
		Plans plan = new Plans(driver, test);
		String username = PropertiesFile.GetProperty("ProductOwnerUserName");
		String password = PropertiesFile.GetProperty("ProductOwnerPassword");
		lb.loginToLaunchPad(username, password);
		plan.CreatePlan();

	}

	@Test(priority = 4,enabled=false)
	public void ApprovePlan() throws InterruptedException {
		LoginToApplication lb = new LoginToApplication(driver, test);
		SecurityAdmin sa = new SecurityAdmin(driver, test);
		String username = PropertiesFile.GetProperty("SecurityAdminUserName");
		String password = PropertiesFile.GetProperty("SecurityAdminPassword");
		lb.loginToLaunchPad(username, password);
		sa.ChangeStatusOfPlan();

	}

}
