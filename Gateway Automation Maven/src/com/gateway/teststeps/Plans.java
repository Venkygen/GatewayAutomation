package com.gateway.teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PackagesPage;
import com.gateway.repository.PlansPage;
import com.gateway.utility.PropertiesFile;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Plans {
	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;
	PolicyElements policy;
	private Screenshot sc;
	String envName = PropertiesFile.GetProperty("envName");
	String planName = PropertiesFile.GetProperty("planName");
	String planDesc = PropertiesFile.GetProperty("planName");
	String Subscriptions = PropertiesFile.GetProperty("Subscriptions");
	String Analytics = PropertiesFile.GetProperty("Analytics");
	String Authentication = PropertiesFile.GetProperty("Authentication");
	String AuthProvider = PropertiesFile.GetProperty("AuthProvider");
	String ConfigureFlows = PropertiesFile.GetProperty("ConfigureFlows");
	String MeteringPayload = PropertiesFile.GetProperty("MeteringPayload");
	String HitsRateLimit = PropertiesFile.GetProperty("HitsRateLimit");

	public Plans(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		policy = new PolicyElements(driver, test);
		sc = new Screenshot(driver);
	}

	public void CreatePlan() {
		try {
			
			test.log(LogStatus.INFO, "****Plan creation started****");
			act.click(PlansPage.planLink);
			act.click(PlansPage.btn_CreateApiPlan);
			act.setText(PlansPage.plan_name, planName);
			act.setText(PlansPage.plan_desc, planDesc);
			act.setText(PlansPage.Subscriptions, Subscriptions);
			act.click(PackagesPage.nxtBtn);
			test.log(LogStatus.PASS, "Step 1 Completed: Basic Information provided");
			act.click(By.xpath(".//*[@id='selectApiEnvironments']//span[text()='" + envName + "']"));

			act.click(PackagesPage.nxtBtn);
			test.log(LogStatus.PASS, "Step 2 Completed: API Environment selected");
			act.click(PackagesPage.nxtBtn);
			test.log(LogStatus.PASS, "Step 3 Completed: Policy Template Selection");
			policy.Analytics(Analytics);
			policy.Authentication(Authentication, AuthProvider);
			policy.Metering(null, MeteringPayload);
			policy.Ratelimit(HitsRateLimit);
			act.click(PackagesPage.nxtBtn);
			test.log(LogStatus.PASS, "Step 3 Completed: Editing Policy Elements");
			
			act.click(PackagesPage.finishButton);
			
			if (driver.findElement(PackagesPage.toast_error).isDisplayed()) {
				String error = act.getText(PackagesPage.toast);
				test.log(LogStatus.FAIL, "Template Creation Failed: " + error);
				test.log(LogStatus.FAIL, "Tempalte Creation Failed: " + error, test.addScreenCapture(sc.getSnap()));
				act.click(PackagesPage.close);

			} else if (driver.findElement(PackagesPage.toast_Success).isDisplayed()){
				String msg = act.getText(PackagesPage.toast);
				test.log(LogStatus.PASS, msg);
			}
			
			test.log(LogStatus.INFO, "****Plan creation completed****");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
