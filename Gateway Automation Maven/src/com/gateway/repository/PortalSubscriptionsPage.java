package com.gateway.repository;

import org.openqa.selenium.By;

public class PortalSubscriptionsPage {

	public static By mySubscriptions = By.id("mySubscriptions");
	public static By unsubscribeform = By.xpath(".//h3[text()='Unsubscribe API Plan']");
	public static By btn_confirm = By.name("confirmBtn");
	public static By btn_cancel = By.name("cancelBtn");
}
