package com.gateway.repository;

import org.openqa.selenium.By;

public class PortalDevelopersPage {

	public static By developersHeader = By.id("developersHeader");
	public static By email = By.xpath("//div[@id='s2id_select2TagOptions']//input");
	public static By selectApplication = By.xpath("//select[@name='selectApplication']");
	public static By btn_addDeveloper = By.id("addDeveloper");
	public static By developersList = By.id("developersList");
	public static By removeDeveloperMsg = By.id("removeDeveloperMsg");
	public static By btn_confirm = By.name("confirmBtn");
	public static By btn_cancel = By.name("cancelBtn");
}
