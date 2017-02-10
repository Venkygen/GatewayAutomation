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

	private WebDriver driver;
	private Screenshot sc;
	private ExtentTest test;
	CommonFunctions act;

	public Environments(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
	}

	public void waitForPageToLoad(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(by)).isEnabled();
	}

	public void CreateEnvironment() throws Exception {
		try {

			Thread.sleep(5000);
			test.log(LogStatus.PASS, "*****Environment Creation Started****");
			act.click(EnvironmentsPage.environmentsLink);
			act.click(EnvironmentsPage.btn_createApiEnvironment);

			if (driver.findElement(EnvironmentsPage.CreateEnvModal).isDisplayed()) {

				act.setText(EnvironmentsPage.Name,envName);
				act.setText(EnvironmentsPage.Desc,envDesc);
				

				if (hostnameType.equalsIgnoreCase("Use Prefix")) {
					act.setText(EnvironmentsPage.PrefixHostname,hostnameValue);
					
				} else {
					act.click(EnvironmentsPage.btn_AliasHostname);
					act.setText(EnvironmentsPage.AliasHostname,hostnameValue);
					}

				if (enforceSecure.equalsIgnoreCase("True")) {
					act.click(EnvironmentsPage.enforce_Secure);
					
				}

				Select oSelect = new Select(driver.findElement(EnvironmentsPage.user_Type));
				oSelect.selectByVisibleText(userType);

				
				
				driver.findElement(By.xpath(".//*[@id='apiEnvironmentBasicInfo']//span[text()='" + envTpe + "']"))
						.click();

				act.click(PackagesPage.nxtBtn);
				
				test.log(LogStatus.PASS, "Step 1 Completed: Provided Basic Info ");
				
				waitForPageToLoad(EnvironmentsPage.Port);
				act.setText(EnvironmentsPage.IP_Address, node);
				act.setText(EnvironmentsPage.Port, port);
				act.click(PackagesPage.nxtBtn);
				test.log(LogStatus.PASS, "Step 2 Completed: Provided Node Port details ");
				waitForPageToLoad(EnvironmentsPage.ConfigureHeaders);

				if (header.equals("Constant Value")) {
					driver.findElement(
							By.xpath(".//*[@id='apiEnvironmentConfigureHeaders']//label[text()='" + header + "']"))
							.click();
				act.setText(EnvironmentsPage.headerConstantValue, node);
					
				} else {
					driver.findElement(
							By.xpath(".//*[@id='apiEnvironmentConfigureHeaders']//label[text()='" + header + "']"))
							.click();
				}

				act.click(PackagesPage.nxtBtn);
				test.log(LogStatus.PASS, "Step 3 Completed: Configured Headers details ");
				act.click(PackagesPage.nxtBtn);
				test.log(LogStatus.PASS, "Step 4 Completed: Policy Template selection");
				act.click(PackagesPage.nxtBtn);
				test.log(LogStatus.PASS, "Step 5 Completed: Editing Policy Elements");
				act.click(PackagesPage.finishButton);				

				if (driver.findElement(PackagesPage.toast_error).isDisplayed()) {
					String error = act.getText(PackagesPage.toast);
					test.log(LogStatus.FAIL, "Package Creation Failed: " + error);
					test.log(LogStatus.FAIL, "Package Creation Failed: " + error, test.addScreenCapture(sc.getSnap()));
					act.click(PackagesPage.close);

				} else {
					String msg = act.getText(PackagesPage.toast);
					test.log(LogStatus.PASS, msg);
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void SearchEnvironments() {
		try {
			driver.findElement(By.linkText("Environments")).click();
			driver.findElement(By.xpath(".//*[@id='apiEnvironmentsGridSearch']//input[@placeholder='Search']"))
					.sendKeys(envName);
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
