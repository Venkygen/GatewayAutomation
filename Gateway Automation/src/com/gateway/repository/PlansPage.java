package com.gateway.repository;

import org.openqa.selenium.By;

public class PlansPage {
		
	public static By CreateApiPkgModal = By.xpath(".//*[@id='addNewApiPackageStepsModal']");
	public static By nxtBtn  = By.xpath(".//button[@name='nextBtn']");
	public static By finishButton  = By.xpath(".//button[@name='finishBtn']");
	public static By packagesLink  =By.linkText("Packages");
	public static By planLink  =By.linkText("API Plans");	
	public static By btn_CreateApiPlan  =By.xpath(".//button[@title='Create API Plan']");
	public static By plan_name  =By.xpath(".//*[@id='apiPlanBasicInfoModalForm']//input[@placeholder='API Plan Name']");
	public static By plan_desc  =By.xpath(".//*[@id='apiPlanBasicInfoModalForm']//textarea[@placeholder='API Plan Description']");
	public static By Subscriptions  =By.xpath(".//*[@id='apiPlanBasicInfoModalForm']//input[@placeholder='# Subscriptions']");
	public static By Search  =By.xpath(".//*[@id='apiPlansGridSearch']//input[@placeholder='Search']");
}
