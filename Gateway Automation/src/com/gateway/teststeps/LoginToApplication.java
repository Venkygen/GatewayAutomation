package com.gateway.teststeps;

import org.openqa.selenium.WebDriver;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.LoginPage;
import com.gateway.utility.PropertiesFile;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginToApplication {

	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;

	public LoginToApplication(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
	}

	public void KillBrowser() {
		driver.close();
		test.log(LogStatus.PASS, "Browser closed");

	}

	public void accessURL(String url) {
		driver.get(url);
		test.log(LogStatus.PASS, "URL accessed");
	}

	public void loginToLaunchPad(String username, String password) {
		try {


			act.setText(LoginPage.LaunchPadusername, username);

			act.setText(LoginPage.launchPadpassword, password);

			act.click(LoginPage.login_button);

			test.log(LogStatus.PASS, "Logged in as ApiCreator");
		} catch (Exception e) {

			test.log(LogStatus.FAIL, "Log in failed for ApiCreator");
			e.printStackTrace();
		}
	}

	public void loginToPortal(String username,String password) {
		try {
			act.click(LoginPage.portal_loginLink);
			act.setText(LoginPage.LaunchPadusername, username);

			act.setText(LoginPage.launchPadpassword, password);

			act.click(LoginPage.portal_login_button);

			test.log(LogStatus.PASS, "Logged in as ApiCreator");
		} catch (Exception e) {

			test.log(LogStatus.FAIL, "Log in failed for ApiCreator");
			e.printStackTrace();
		}
	}
	
	public void logoutFromLaunchpad() {
		try {
			act.click(LoginPage.logout);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ReloginToLaunchpad() {
		try {
			act.click(LoginPage.relogin);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loginAsOperationsManager() {
		try {

			String username = PropertiesFile.GetProperty("OperationsManagerUserName");
			String password = PropertiesFile.GetProperty("OperationsManagerPassword");
			act.setText(LoginPage.LaunchPadusername, username);
			act.setText(LoginPage.launchPadpassword, password);
			act.click(LoginPage.login_button);
			test.log(LogStatus.PASS, "Logged in as OperationsManager");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Login failed");
			e.printStackTrace();
		}
	}

	public void loginAsProductOwner() {
		try {

			String username = PropertiesFile.GetProperty("ProductOwnerUserName");
			String password = PropertiesFile.GetProperty("ProductOwnerPassword");
			act.setText(LoginPage.LaunchPadusername, username);
			act.setText(LoginPage.launchPadpassword, password);
			act.click(LoginPage.login_button);
			test.log(LogStatus.PASS, "Logged in as ProductOwner");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Login failed");
			e.printStackTrace();
		}

	}

	public void loginAsSecurityAdmin() {
		try {
			String username = PropertiesFile.GetProperty("SecurityAdminUserName");
			String password = PropertiesFile.GetProperty("SecurityAdminPassword");
			act.setText(LoginPage.LaunchPadusername, username);
			act.setText(LoginPage.launchPadpassword, password);
			act.click(LoginPage.login_button);
			test.log(LogStatus.PASS, "Logged in as SecurityAdmin");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Login failed");
			e.printStackTrace();
		}

	}

}
