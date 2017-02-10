package com.gateway.repository;

import org.openqa.selenium.By;

public class QuickPublishPage {

	public final static By quickPublish = By.xpath(".//p[text()='Quick Publish']");
	public final static By newService = By.id("addURL");
	public final static By quickLaunchForm = By.xpath("//*[@id='quickLaunchAddUrlModalForm']");
	public final static By URL = By.id("fullURL");
	public final static By btn_GO = By.xpath("//*[@id='quickLaunchAddUrlModalForm']//button[contains(text(), 'Go')]");
	public final static By name = By.id("name");
	public final static By gridSearch = By.name("gridSearch");

	public final static By selectMethods = By
			.xpath("//*[@id='quickLaunchAddUrlModalForm']//button[contains(text(), 'Select Methods')]");
	public final static By GET = By.xpath("//*[@id='quickLaunchAddUrlModalForm']//input[@name='GET']");

	public final static By prefixHostName = By
			.xpath("//*[@id='quickLaunchAddUrlModalForm']//input[@name='prefixHostName']");

	public final static By btn_Create = By
			.xpath("//*[@id='quickLaunchAddUrlModalForm']//span[contains(text(), 'Create')]");

	// *[@id='quickPublishItemsGrid']//span[contains(text(),
	// '${quickPubHostName}.${LaunchPadHost}')]

}
