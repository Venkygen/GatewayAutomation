package com.gateway.teststeps;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PackagesPage;
import com.gateway.utility.PropertiesFile;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Packages {

	String pkgName = PropertiesFile.GetProperty("pkgName");
	String pkgDesc = PropertiesFile.GetProperty("pkgDesc");
	String Version = PropertiesFile.GetProperty("Version");
	String policyName = PropertiesFile.GetProperty("apipolicyName");
	String policyDesc = PropertiesFile.GetProperty("apipolicyDesc");
	private Screenshot sc;
	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;
	PolicyElements policy;

	public Packages(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
		policy = new PolicyElements(driver, test);
	}

	public void GetStats() {
		try {
			test.log(LogStatus.INFO, "This Enterprise contains: " + act.getText(PackagesPage.apiPackagesTile));
			test.log(LogStatus.INFO, "This Enterprise contains: " + act.getText(PackagesPage.apiPolicyTemplatesTile));
			test.log(LogStatus.INFO, "This Enterprise contains: " + act.getText(PackagesPage.apisListTile));
			test.log(LogStatus.INFO, "This Enterprise contains total hits since server starts: "
					+ act.getText(PackagesPage.apiPlanSubscribersTile_hits));
			test.log(LogStatus.INFO,
					"This Enterprise contains latenct of " + act.getText(PackagesPage.apiPlanSubscribersTile_request));
			test.log(LogStatus.INFO,
					"This Enterprise contains latenct of " + act.getText(PackagesPage.apiPlanSubscribersTile_resonse));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void createpkgPolicyTemplate() {

		test.log(LogStatus.INFO, "**** Api policy Template creation Started *****");
		act.click(PackagesPage.PolicyTemplateLink);
		act.click(PackagesPage.btn_createTemplate);

		if (driver.findElement(PackagesPage.createApiTemplateModal).isDisplayed()) {
			act.setText(PackagesPage.apiPolicyName, policyName);
			act.setText(PackagesPage.apiPolicyDesc, policyDesc);
			act.click(PackagesPage.elem_Analytics);
			act.click(PackagesPage.elem_Authentication);
			act.click(PackagesPage.elem_Metering);
			act.click(PackagesPage.elem_RateLimit);
			act.click(PackagesPage.nxtBtn);
			policy.Analytics();
			policy.Authentication();
			policy.Metering();
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
		}

	}

	public void CreatePackage() throws InterruptedException {
		try {
			test.log(LogStatus.INFO, "*****package Creation started***");
			act.click(PackagesPage.packagesLink);
			act.click(PackagesPage.btn_createApiPackage);

			if (driver.findElement(PackagesPage.CreateApiPkgModal).isDisplayed()) {
				act.setText(PackagesPage.API_Package_Name, pkgName);
				act.setText(PackagesPage.API_Package_Desc, pkgDesc);
				act.setText(PackagesPage.API_Package_Version, Version);

				act.click(PackagesPage.nxtBtn);
				test.log(LogStatus.PASS, "Step 1 Completed: Basic Package Details provided");
				act.click(PackagesPage.uploadButton);

				try {
					Thread.sleep(5000);
					Runtime.getRuntime()
							.exec("E:\\GatewayAutomation\\Gateway Automation\\AutoItScripts\\UploadJSON.exe");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				act.click(PackagesPage.nxtBtn);
				test.log(LogStatus.PASS, "Step 2 Completed: APIs uploaded");
				act.click(PackagesPage.nxtBtn);
				test.log(LogStatus.PASS, "Step 3 Completed: Policy Template Selection");
				act.click(PackagesPage.nxtBtn);
				test.log(LogStatus.PASS, "Step 4 Completed: Editing Policy Elements");
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

	public void SearchPackage() {
		try {
			// try {
			// System.out.println((PackagesPage.class).getField("packagesLink").getName());
			// } catch (NoSuchFieldException | SecurityException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

			test.log(LogStatus.INFO, "Searching for the package");
			act.click(PackagesPage.packagesLink);

			String pkgName = PropertiesFile.GetProperty("pkgName");

			act.setText(PackagesPage.searchApiPackages, pkgName);

			Thread.sleep(5000);

			List<WebElement> ListOfPkgs = driver.findElements(By.xpath(
					".//*[@id='apiPackagesGrid']//div[contains(@class, 'ng-scope ngRow')]/div[1]/div[2]/div/span"));

			if (ListOfPkgs.size() > 0) {
				for (int i = 0; i <= ListOfPkgs.size(); i++) {

					System.out.println(ListOfPkgs.get(i).getText().toString());
					if (pkgName.equalsIgnoreCase(ListOfPkgs.get(i).getText().toString())) {
						System.out.println("expected" + ListOfPkgs.get(i).getText().toString());
						ListOfPkgs.get(i).click();
						test.log(LogStatus.PASS, pkgName + " Found");
						break;
					}
				}
			} else {
				test.log(LogStatus.FAIL, pkgName + " Not Found");
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void VerifyPackageBasicDetails() {
		try {
			test.log(LogStatus.INFO, "Verifying Package Basic Details");
			act.clickOnTab("Summary");
			act.verifyActualExpected(driver.findElement(PackagesPage.pkgDetails_name).getText().toString(), pkgName);
			act.verifyActualExpected(driver.findElement(PackagesPage.pkgDetails_version).getText().toString(), Version);
			act.verifyActualExpected(driver.findElement(PackagesPage.pkgDetails_desc).getText().toString(), pkgDesc);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void SearchapiTemplate(String templateName) {
		try {
			act.click(PackagesPage.PolicyTemplateLink);

			act.setText(PackagesPage.searchApiTemplates, templateName);

			Thread.sleep(5000);

			if (driver.findElement(By.xpath(".//*[@id='apiPolicyTemplateGrid']//span[text()='" + policyName + "']"))
					.isDisplayed()) {
				test.log(LogStatus.PASS, policyName + " found");
				act.click(By.xpath(".//*[@id='apiPolicyTemplateGrid']//span[text()='" + policyName + "']"));
			} else {
				test.log(LogStatus.FAIL, policyName + " not found");
				test.log(LogStatus.FAIL, "policy template Not found ", test.addScreenCapture(sc.getSnap()));
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void VerifyPackagepolicyTemplate() {
		try {
			test.log(LogStatus.INFO, "Verifying Package policy template Details");
			act.clickOnTab("Summary");
			act.verifyActualExpected(driver.findElement(PackagesPage.pkgDetails_name).getText().toString(), pkgName);
			act.verifyActualExpected(driver.findElement(PackagesPage.pkgDetails_version).getText().toString(), Version);
			act.verifyActualExpected(driver.findElement(PackagesPage.pkgDetails_desc).getText().toString(), pkgDesc);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void verifyPolicyElements(){
		
	}

}
