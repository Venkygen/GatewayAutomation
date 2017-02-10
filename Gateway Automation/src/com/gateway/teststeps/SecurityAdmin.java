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
		try {
			act.click(PlansPage.planLink);

			SearchPlans(planName);

			driver.findElement(
					By.xpath(".//*[@id='apiPlansGrid']//div[.//span[text()='" + planName + "']]//i[@name='associate']"))
					.click();

			Select st = new Select(
					driver.findElement(By.xpath(".//form[@name='approvePlanForm']//select[@name='status']")));
			st.selectByVisibleText(status);

			act.click(SecurityAdminPage.btn_Save);

			if (driver.findElement(PackagesPage.toast_error).isDisplayed()) {
				String error = act.getText(PackagesPage.toast);
				test.log(LogStatus.FAIL, "Template Creation Failed: " + error);
				test.log(LogStatus.FAIL, "Tempalte Creation Failed: " + error, test.addScreenCapture(sc.getSnap()));
				act.click(PackagesPage.close);

			} else {
				String msg = act.getText(PackagesPage.toast);
				test.log(LogStatus.PASS, msg);
			}

			act.setText(PlansPage.plan_name, planName);
			test.log(LogStatus.PASS, planName + " status changed to " + status);

		} catch (Exception e) {
			test.log(LogStatus.FAIL, planName + " status change failed ");
			e.printStackTrace();
		}
	}

	public void SearchPlans(String planName) {
		try {

			act.click(PlansPage.planLink);
			act.setText(PlansPage.Search, planName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
