package com.gateway.repository;

import org.openqa.selenium.By;

public class PolicyElementsPage {
		
	
	public static By policyElementsList = By.xpath(".//*[@id='policyElementsList']");
	public static By policyElementPane = By.xpath(".//*[@id='policyElementAttrs']");
	public static By btn_Clear = By.xpath(".//*[@id='policyElementAttrs']//button[@name='clearBtn']");
	public static By btn_addPolicyElement = By.xpath(".//*[@id='policyElementAttrs']//button[@name='addPolicyBtn']");
	public static By btn_Save = By.xpath(".//*[@id='policyElementAttrs']//button[@name='saveBtn']");
	public static By btn_showAll = By.xpath(".//*[@id='policyElementAttrs']//button[@name='showAllBtn']");
	
	
	public static By analytics = By.xpath(".//*[@id='policyElementsList']//a[@name='Analytics']");
	public static By btn_YES = By.xpath(".//*[@id='policyElementAttrs']//button[text()='YES']");
	public static By btn_NO = By.xpath(".//*[@id='policyElementAttrs']//button[text()='NO']");
	public static By dropDown_authProvider = By.xpath(".//*[@id='policyElementAttrs']//select[@name='authProvider']");
	public static By dropDown_authenticationType = By.xpath(".//*[@id='policyElementAttrs']//select[@name='authenticationType']");
	
	public static By authentication = By.xpath(".//*[@id='policyElementsList']//a[@name='Authentication']");
	
	public static By metering = By.xpath(".//*[@id='policyElementsList']//a[@name='Metering']");
	public static By btn_Hits = By.xpath(".//*[@id='policyElementAttrs']//button[@name='hitsBtn']");
	public static By btn_PayLoad = By.xpath(".//*[@id='policyElementAttrs']//button[@name='payloadBtn']");
	
		
	public static By rateLimit = By.xpath(".//*[@id='policyElementsList']//a[@name='Rate-Limit']");
	public static By frequency = By.xpath(".//*[@id='policyElementAttrs']//input[@name='frequency']");
	public static By notifyEmailAddresses = By.xpath(".//*[@id='policyElementAttrs']//input[@name='notifyEmailAddresses']");
	public static By addEmailAddress = By.xpath("	.//*[@id='policyElementAttrs']//a[@ng-click='control.addEmailAddress()']");
	public static By btn_enableSoft = By.xpath(".//*[@id='policyElementAttrs']//button[@name='enableSoftBtn']");
	public static By btn_disableSoft = By.xpath(".//*[@id='policyElementAttrs']//button[@name='disableSoftBtn']");
	






	 

	
	
	
	public static By appsLimit = By.xpath(".//*[@id='policyElementsList']//a[@name='Apps-Limit']");
	public static By userLimit = By.xpath(".//*[@id='policyElementsList']//a[@name='Users-Limit']");
	public static By deviceLimit = By.xpath(".//*[@id='policyElementsList']//a[@name='Devices-Limit']");
	public static By custom = By.xpath(".//*[@id='policyElementsList']//a[@name='Custom']");
	public static By messageLog = By.xpath(".//*[@id='policyElementsList']//a[@name='Message-Log']");
	public static By mediation = By.xpath(".//*[@id='policyElementsList']//a[@name='Mediation-Policy']");
	public static By monetization = By.xpath(".//*[@id='policyElementsList']//a[@name='Monetization-Policy']");
	
	
	
}
