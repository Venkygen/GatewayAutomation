package com.gateway.repository;

import org.openqa.selenium.By;

public class SecurityAdminPage {
		
	public static By apiPlansPane = By.xpath(".//*[@id='apiPlans']");
	
	public static By approvePlanForm = By.xpath(".//form[@name='approvePlanForm']");
	public static By btn_Save = By.xpath(".//form[@name='approvePlanForm']//button[text()='Save']");
	public static By status =By.xpath(".//form[@name='approvePlanForm']//select[@name='status']");
}
