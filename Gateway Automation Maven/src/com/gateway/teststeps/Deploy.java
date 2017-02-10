package com.gateway.teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.DeployPackagePage;
import com.gateway.repository.PackagesPage;
import com.gateway.utility.PropertiesFile;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Deploy {

	String envName = PropertiesFile.GetProperty("envName");

	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;
	private Screenshot sc;

	public Deploy(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
	}

	public void deploy() {
		try {

			test.log(LogStatus.INFO, "Package deployment started");
			act.click(DeployPackagePage.deployBtn);
			act.click(By.xpath(".//*[@id='selectApiEnvironments']//span[text()='" + envName + "']"));
			act.click(PackagesPage.nxtBtn);
			act.click(PackagesPage.nxtBtn);
			act.click(PackagesPage.finishButton);

			if (driver.findElement(PackagesPage.toast_error).isDisplayed()) {
				String error = act.getText(PackagesPage.toast);
				test.log(LogStatus.FAIL, "Template Creation Failed: " + error);
				test.log(LogStatus.FAIL, "Tempalte Creation Failed: " + error, test.addScreenCapture(sc.getSnap()));
				act.click(PackagesPage.close);

			} else {
				String msg = act.getText(PackagesPage.toast);
				test.log(LogStatus.PASS, msg);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
