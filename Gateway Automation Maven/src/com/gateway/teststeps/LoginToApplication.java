package com.gateway.teststeps;

import org.openqa.selenium.WebDriver;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.LoginPage;
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

	public void loginToLaunchPad(String username, String password) {
		try {
			act.setText(LoginPage.LaunchPadusername, username);
			act.setText(LoginPage.launchPadpassword, password);
			act.click(LoginPage.login_button);
			test.log(LogStatus.PASS,username+ " logged in to API launchpad");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Log in failed ");
			e.printStackTrace();
		}
	}

	public void loginToPortal(String username, String password) {
		try {
			act.click(LoginPage.portal_loginLink);
			act.setText(LoginPage.LaunchPadusername, username);
			act.setText(LoginPage.launchPadpassword, password);
			act.click(LoginPage.portal_login_button);

			test.log(LogStatus.PASS, username +" Logged into Portal");
		} catch (Exception e) {

			test.log(LogStatus.FAIL, "Log in failed ");
			e.printStackTrace();
		}
	}

	public void logoutFromLaunchpad() {
		try {
			act.click(LoginPage.logout);
			test.log(LogStatus.PASS, "User logged out from launchpad");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "log out failed");
			e.printStackTrace();
		}
	}
	
	public void logoutFromPortal() {
		try {
			act.click(LoginPage.portal_userMenu);
			act.click(LoginPage.portal_logout);
			test.log(LogStatus.PASS, "User logged out from Api portal");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "log out failed");
			e.printStackTrace();
		}
	}

	public void ReloginToLaunchpad() {
		try {
			act.click(LoginPage.relogin);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
