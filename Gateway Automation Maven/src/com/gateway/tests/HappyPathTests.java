package com.gateway.tests;

import org.testng.annotations.Test;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PackagesPage;
import com.gateway.teststeps.Deploy;
import com.gateway.teststeps.Environments;
import com.gateway.teststeps.GraphsNdReports;
import com.gateway.teststeps.LoginToApplication;
import com.gateway.teststeps.Packages;
import com.gateway.teststeps.Plans;
import com.gateway.teststeps.QuickPublish;
import com.gateway.teststeps.SecurityAdmin;
import com.gateway.utility.PropertiesFile;

public class HappyPathTests extends BaseClass {

//	@Test(priority = 0)
//	public void packageTemplateCreation() throws InterruptedException {
//		String templateName = "two";
//		LoginToApplication lb = new LoginToApplication(driver, test);
//		Packages api = new Packages(driver, test);
//		
//		String username = PropertiesFile.GetProperty("ApiCreatorUserName");
//		String password = PropertiesFile.GetProperty("ApiCreatorPassword");
//
//		lb.loginToLaunchPad(username, password);
//		api.createpkgPolicyTemplate();
//		api.SearchapiTemplate(templateName);
//		api.VerifyPackagepolicyTemplate();
//		lb.logoutFromLaunchpad();
//	}
//	
//	@Test(priority = 0)
//	public void EnvironmentTemplateCreation() throws Exception  {
//		LoginToApplication lb = new LoginToApplication(driver, test);
//		Environments env = new Environments(driver, test);
//		String username = PropertiesFile.GetProperty("OperationsManagerUserName");
//		String password = PropertiesFile.GetProperty("OperationsManagerPassword");
//		lb.loginToLaunchPad(username, password);
//		env.createEnvPolicyTemplate();
//		lb.logoutFromLaunchpad();
//	}

	@Test(priority = 0)
	public void packageCreation() throws InterruptedException {

		LoginToApplication lb = new LoginToApplication(driver, test);
		Packages api = new Packages(driver, test);
		String username = PropertiesFile.GetProperty("ApiCreatorUserName");
		String password = PropertiesFile.GetProperty("ApiCreatorPassword");
		lb.loginToLaunchPad(username, password);
		api.getStats();
		api.createPackage();
		api.searchPackage();
		api.verifyPackageBasicDetails();
		lb.logoutFromLaunchpad();
	}

//	@Test(priority = 1)
//	public void environmentCreation() {
//		try {
//
//			LoginToApplication lb = new LoginToApplication(driver, test);
//			Environments env = new Environments(driver, test);
//			String username = PropertiesFile.GetProperty("OperationsManagerUserName");
//			String password = PropertiesFile.GetProperty("OperationsManagerPassword");
//			lb.loginToLaunchPad(username, password);
//			env.CreateEnvironment();
//			lb.logoutFromLaunchpad();
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//	}
//
//	@Test(priority = 0,enabled=false)
//	public void quickPublish() throws InterruptedException {
//
//		LoginToApplication lb = new LoginToApplication(driver, test);
//		QuickPublish qp = new QuickPublish(driver, test);
//		String username = PropertiesFile.GetProperty("ApiCreatorUserName");
//		String password = PropertiesFile.GetProperty("ApiCreatorPassword");
//		lb.loginToLaunchPad(username, password);
//		String Url = "https://gateway.wavemakeronline.com/corridor/index.html";
//		String prefixHostName = "marks12";
//		String name = "marksTest12";
//		qp.createQuickPublish(Url, prefixHostName, name);
//		qp.SearchQuickPublish("marks");
//		lb.logoutFromLaunchpad();
//
//	}
//
//	@Test(priority = 2)
//	public void DeployPackageToEnvironment() throws InterruptedException {
//		Packages api = new Packages(driver, test);
//		CommonFunctions act = new CommonFunctions(driver, test);
//		LoginToApplication lb = new LoginToApplication(driver, test);
//		Deploy dply = new Deploy(driver, test);
//		String username = PropertiesFile.GetProperty("OperationsManagerUserName");
//		String password = PropertiesFile.GetProperty("OperationsManagerPassword");
//		lb.loginToLaunchPad(username, password);
//		act.click(PackagesPage.packagesLink);
//		api.SearchPackage();
//		dply.deploy();
//		lb.logoutFromLaunchpad();
//
//	}
//
//	@Test(priority = 3)
//	public void planCreation() throws InterruptedException {
//		LoginToApplication lb = new LoginToApplication(driver, test);
//		Plans plan = new Plans(driver, test);
//		String username = PropertiesFile.GetProperty("ProductOwnerUserName");
//		String password = PropertiesFile.GetProperty("ProductOwnerPassword");
//		lb.loginToLaunchPad(username, password);
//		plan.CreatePlan();
//		lb.logoutFromLaunchpad();
//
//	}
//
//	@Test(priority = 4)
//	public void ApprovePlan() throws InterruptedException {
//		LoginToApplication lb = new LoginToApplication(driver, test);
//		SecurityAdmin sa = new SecurityAdmin(driver, test);
//		String username = PropertiesFile.GetProperty("SecurityAdminUserName");
//		String password = PropertiesFile.GetProperty("SecurityAdminPassword");
//		lb.loginToLaunchPad(username, password);
//		sa.ChangeStatusOfPlan();
//		lb.logoutFromLaunchpad();
//
//	}
//	
//	@Test(priority = 0)
//	public void VerifyGraphs() throws Exception {
//		LoginToApplication lb = new LoginToApplication(driver, test);
//		Plans plan = new Plans(driver, test);
//		GraphsNdReports gr = new GraphsNdReports(driver, test);
//
//		String username = PropertiesFile.GetProperty("ProductOwnerUserName");
//		String password = PropertiesFile.GetProperty("ProductOwnerPassword");
//		lb.loginToLaunchPad(username, password);
//
//		gr.verifyGraph();
//	}
	
		
}
