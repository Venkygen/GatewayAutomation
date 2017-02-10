package com.gateway.repository;

import org.openqa.selenium.By;

public class LoginPage {

	/* LaunchPad */
	public static By LaunchPadusername = By.xpath(".//*[@id='email']");
	public static By launchPadpassword = By.xpath(".//*[@id='password']");
	public static By login_button = By.xpath(".//*[@id='loginrow']");
	public static By signinPage = By.xpath(".//form[@id='signin']");
	public static By logout = 	By.xpath(".//*[@id='logout']");
	public static By relogin = 	By.xpath(".//*[@id='relogin']");
	public static By LoggedInUser = 	By.xpath(".//p[@class='profileName']/span");
	
	/* Portal*/
	public static By portal_login_button = By.xpath(".//*[@id='loginBtn']");
	public static By portal_loginLink = By.xpath(".//*[@id='loginLink']");
	
}
