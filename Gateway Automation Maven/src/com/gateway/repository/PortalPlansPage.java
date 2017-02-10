package com.gateway.repository;

import org.openqa.selenium.By;

public class PortalPlansPage {

	public static By apiPlans = By.id("apiPlans");
	public final static By apiPlansList = By.xpath(".//*[@id='apiPlansList']");
	public final static By plan_name = By.xpath(".//div[contains(@class,'entity-details')]/p[1]");
	public final static By planQuota = By.xpath(".//div[contains(@class,'entity-details')]//div[@id='planQuota']");
	public final static By envAPIs = By.xpath(".//div[contains(@class,'entity-details')]//div[@id='envAPIs']");
	public final static By registeredApps = By
			.xpath(".//div[contains(@class,'entity-details')]//div[@id='registeredApps']");
	public final static By subscribe = By
			.xpath(".//div[contains(@class,'entity-details')]//div[@id='registeredApps']//button");
	public final static By appRegForm = By.xpath(".//form[@name='appRegForm']");
	public final static By appName = By.xpath(".//form[@name='appRegForm']//input[@id='appName']");
	public final static By appType = By.xpath(".//form[@name='appRegForm']//input[@id='appType']");
	public final static By appUri = By.xpath(".//form[@name='appRegForm']//input[@id='appUri']");
	public final static By appDescription = By.xpath(".//form[@name='appRegForm']//textarea[@id='appDescription']");
	public final static By redirectUri = By
			.xpath(".//div[@name='redirectUri']//input[contains(@class, 'select2-input')]");
	public final static By verifyAppName = By.xpath(".//label[@name='appName']");
	public final static By verifyAppDesc = By.xpath(".//label[@name='appDescription']");
	public final static By verifyAppUri = By.xpath(".//label[@name='appUri']");
	public final static By verifyAppClientID = By.xpath(".//label[@name='clientId']");
	public final static By verifyAppClientSecret = By.xpath(".//label[@name='clientSecret']");

	public final static By btn_RegisterApp = By.name("register");
	public final static By btn_cancel = By.name("cancel");
}
