package com.gateway.repository;

import org.openqa.selenium.By;

public class EnvironmentsPage {
	public static By environments_home = By.xpath(".//div[contains(@class,'gateway-home-container')]");
	public static By environmentsLink = By.linkText("Environments");
	public static By btn_createApiEnvironment = By.xpath(".//*[@id='createApiEnvironment']");
	public static By CreateEnvModal = By.xpath(".//*[@id='apiEnvironmentBasicInfo']");
	public static By Name  = By.xpath(".//*[@id='apiEnvironmentBasicInfo']//input[@placeholder='Environment Name']");
	public static By Desc  = By.xpath(".//*[@id='apiEnvironmentBasicInfo']//textarea[@placeholder='Environment Description']");
	public static By PrefixHostname= By.xpath(".//*[@id='apiEnvironmentBasicInfo']//input[@placeholder='Prefix Host name']");
	public static By AliasHostname= By.xpath(".//*[@id='apiEnvironmentBasicInfo']//input[@placeholder='Alias Host name']");
	public static By btn_PrefixHostname= By.xpath(".//*[@id='apiEnvironmentBasicInfo']//button[@name='usePrefixBtn']");
	public static By btn_AliasHostname= By.xpath(".//*[@id='apiEnvironmentBasicInfo']//button[@name='useAliasBtn']");
	public static By enforce_Secure= By.xpath(".//*[@id='apiEnvironmentBasicInfo']//input[@name='enforceSecurity']");
	public static By user_Type= By.xpath(".//*[@id='apiEnvironmentBasicInfo']//select[@name='targetType']");
	public static By nxtBtn  = By.xpath(".//button[@name='nextBtn']");
	public static By IP_Address= By.xpath(".//*[@id='apiEnvironmentConfigureNodePort']//input[@placeholder='IP Address or Hostname']");			
	public static By Port= By.xpath(".//*[@id='apiEnvironmentConfigureNodePort']//input[@placeholder='Port Number']");
	public static By Is_Secure= By.xpath(".//*[@id='apiEnvironmentConfigureNodePort']//input[@name='secure']");
	public static By headerConstantValue= By.xpath(".//*[@id='apiEnvironmentConfigureHeaders']//input[@placeholder='Header Constant Value']");
	public static By ConfigureHeaders= By.xpath(".//*[@id='apiEnvironmentConfigureHeaders']");
	public static By finishButton  = By.xpath(".//*[@id='apiEnvironmentConfirmDetails']//button[@name='finishBtn']");
	
	
	
	public static By toastContainer  = By.xpath(".//*[@id='toast-container']");
	
}
