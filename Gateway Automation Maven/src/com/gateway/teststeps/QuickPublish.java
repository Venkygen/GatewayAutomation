package com.gateway.teststeps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PackagesPage;
import com.gateway.repository.QuickPublishPage;
import com.gateway.utility.PropertiesFile;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QuickPublish {

	String envName = PropertiesFile.GetProperty("envName");

	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;
	private Screenshot sc;

	public QuickPublish(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
	}

	public void createQuickPublish(String Url, String prefixHostName, String name) {
		try {

			act.click(QuickPublishPage.quickPublish);
			act.click(QuickPublishPage.newService);
			if (driver.findElement(QuickPublishPage.quickLaunchForm).isDisplayed()) {

				act.setText(QuickPublishPage.URL, Url);
				act.click(QuickPublishPage.btn_GO);
				act.setText(QuickPublishPage.name, name);
				act.click(QuickPublishPage.selectMethods);

				act.click(QuickPublishPage.GET);
				// act.Select(QuickPublishPage.selectMethods, "GET");
				act.setText(QuickPublishPage.prefixHostName, prefixHostName);
				act.click(QuickPublishPage.btn_Create);

				if (driver.findElement(PackagesPage.toast_error).isDisplayed()) {
					String error = act.getText(PackagesPage.toast);
					test.log(LogStatus.FAIL, "Package Creation Failed: " + error, test.addScreenCapture(sc.getSnap()));
					test.log(LogStatus.FAIL, "Package Creation Failed: " + error);
					act.click(PackagesPage.close);

				} else {
					String msg = act.getText(PackagesPage.toast);
					test.log(LogStatus.PASS, msg);
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void SearchQuickPublish(String quickPublishName) {
		try {
			act.click(QuickPublishPage.quickPublish);
			act.setText(QuickPublishPage.gridSearch, quickPublishName);

			if (driver
					.findElement(By.xpath(
							".//*[@id='quickPublishItemsGrid']//span[contains(text(), '" + quickPublishName + "')]"))
					.isDisplayed()) {
				test.log(LogStatus.PASS, quickPublishName + " found");
				act.click(By.xpath(
						".//*[@id='quickPublishItemsGrid']//span[contains(text(), '" + quickPublishName + "')]"));
			} else {
				test.log(LogStatus.FAIL, quickPublishName + " not found");
				test.log(LogStatus.FAIL, "quick publish Not found ", test.addScreenCapture(sc.getSnap()));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
