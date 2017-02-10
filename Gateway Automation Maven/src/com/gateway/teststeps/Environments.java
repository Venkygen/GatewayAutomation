package com.gateway.teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.EnvironmentsPage;
import com.gateway.repository.PackagesPage;
import com.gateway.utility.PropertiesFile;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Environments {
	String envTpe = PropertiesFile.GetProperty("envTpe");
	String envName = PropertiesFile.GetProperty("envName");
	String envDesc = PropertiesFile.GetProperty("envDesc");
	String hostnameType = PropertiesFile.GetProperty("hostnameType");
	String hostnameValue = PropertiesFile.GetProperty("hostnameValue");
	String enforceSecure = PropertiesFile.GetProperty("enforceSecure");
	String userType = PropertiesFile.GetProperty("userType");
	String node = PropertiesFile.GetProperty("node");
	String port = PropertiesFile.GetProperty("port");
	String header = PropertiesFile.GetProperty("header");

	String policyName = "Low Throughput Env template";
	String policyDesc = "Low Throughput Env template";
	String HitsRateLimit = PropertiesFile.GetProperty("HitsRateLimit");

	private WebDriver driver;
	private Screenshot sc;
	private ExtentTest test;
	CommonFunctions act;
	PolicyElements policy;

	public Environments(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
		policy = new PolicyElements(driver, test);
	}

	public void createEnvironment() throws Exception {
		try {
			test.log(LogStatus.INFO, "*****Environment Creation Started****");

			act.click(EnvironmentsPage.environmentsLink);
			act.click(EnvironmentsPage.btn_createApiEnvironment);

			if (driver.findElement(EnvironmentsPage.CreateEnvModal).isDisplayed()) {

				basicInfoCreateEnvironment(envName, envDesc, hostnameType, hostnameValue, enforceSecure, userType,
						envTpe);

				act.click(PackagesPage.nxtBtn);

				test.log(LogStatus.PASS, "Step 1 Completed: Provided Basic Info ");

				act.setText(EnvironmentsPage.IP_Address, node);
				act.setText(EnvironmentsPage.Port, port);
				act.click(PackagesPage.nxtBtn);

				test.log(LogStatus.PASS, "Step 2 Completed: Provided Node Port details ");

				if (header.equals("Constant Value")) {
					act.click(By.xpath(".//*[@id='apiEnvironmentConfigureHeaders']//label[text()='" + header + "']"));
					act.setText(EnvironmentsPage.headerConstantValue, node);

				} else {
					act.click(By.xpath(".//*[@id='apiEnvironmentConfigureHeaders']//label[text()='" + header + "']"));
				}

				act.click(PackagesPage.nxtBtn);
				test.log(LogStatus.PASS, "Step 3 Completed: Configured Headers details ");
				act.click(PackagesPage.nxtBtn);
				test.log(LogStatus.PASS, "Step 4 Completed: Policy Template selection");
				act.click(PackagesPage.nxtBtn);
				test.log(LogStatus.PASS, "Step 5 Completed: Editing Policy Elements");
				act.click(PackagesPage.finishButton);

				act.VerifyToast();

			}
			test.log(LogStatus.INFO, "*****Environment Creation Completed****");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void basicInfoCreateEnvironment(String envName, String envDesc, String hostnameType, String hostnameValue,
			String enforceSecure, String userType, String envTpe) {
		act.setText(EnvironmentsPage.Name, envName);
		act.setText(EnvironmentsPage.Desc, envDesc);
		if (hostnameType.equalsIgnoreCase("Use Prefix")) {
			act.setText(EnvironmentsPage.PrefixHostname, hostnameValue);

		} else {
			act.click(EnvironmentsPage.btn_AliasHostname);
			act.setText(EnvironmentsPage.AliasHostname, hostnameValue);
		}

		if (enforceSecure.equalsIgnoreCase("True")) {
			act.click(EnvironmentsPage.enforce_Secure);
		}
		act.Select(EnvironmentsPage.user_Type, userType);
		act.click(By.xpath(".//*[@id='apiEnvironmentBasicInfo']//span[text()='" + envTpe + "']"));
	}

	public void searchEnvironments() {
		try {
			act.click(EnvironmentsPage.environmentsLink);
			act.setText(EnvironmentsPage.EnvSearch, envName);
			Thread.sleep(2500);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void createEnvPolicyTemplate() {
		test.log(LogStatus.INFO, "**** Api policy Template creation Started *****");
		act.click(EnvironmentsPage.EnvPolicyTemplateLink);
		act.click(PackagesPage.btn_createTemplate);

		if (driver.findElement(PackagesPage.createApiTemplateModal).isDisplayed()) {
			act.setText(PackagesPage.apiPolicyName, policyName);
			act.setText(PackagesPage.apiPolicyDesc, policyDesc);
			act.click(PackagesPage.elem_RateLimit);
			act.click(PackagesPage.nxtBtn);

			policy.RatelimitForTemplate(HitsRateLimit);

			act.click(PackagesPage.nxtBtn);
			act.click(PackagesPage.finishButton);

			act.VerifyToast();

		}

	}

}
