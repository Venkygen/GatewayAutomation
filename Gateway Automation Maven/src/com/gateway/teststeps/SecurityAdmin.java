package com.gateway.teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PackagesPage;
import com.gateway.repository.PlansPage;
import com.gateway.repository.SecurityAdminPage;
import com.gateway.utility.PropertiesFile;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SecurityAdmin {
	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;
	private Screenshot sc;
	String planName = PropertiesFile.GetProperty("planName");
	String status = PropertiesFile.GetProperty("status");

	public SecurityAdmin(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
	}

	public void ChangeStatusOfPlan() {

		act.click(PlansPage.planLink);
		SearchPlans(planName);
		By by = By.xpath(".//*[@id='apiPlansGrid']//div[.//span[text()='" + planName + "']]//i[@name='associate']");
		if (act.isDisplayed(by)) {
			act.click(by);
			act.Select(SecurityAdminPage.status, status);
			act.click(SecurityAdminPage.btn_Save);
			act.VerifyToast();
		} else {
			test.log(LogStatus.FAIL, planName + " Not found");
		}
	}

	public void SearchPlans(String planName) {
		try {

			act.click(PlansPage.planLink);
			act.setText(PlansPage.Search, planName);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
