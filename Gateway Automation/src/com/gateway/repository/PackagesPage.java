package com.gateway.repository;

import org.openqa.selenium.By;

public class PackagesPage {

	public final static By PolicyTemplateLink = By.linkText("Package Policy Templates");
	public final static By btn_createTemplate = By.id("createApiPolicyTemplate");
	public final static By createApiTemplateModal = By.xpath(".//*[@id='addNewApiPolicyTemplateStepsModal']");
	public final static By apiPolicyName = By.name("apiPolicyTemplate");
	public final static By apiPolicyDesc = By.xpath("//textarea[@name='description']");

	public final static By elem_Analytics = By
			.xpath("//*[@id='addNewApiPolicyTemplateStepsModal']//a[contains(text(),'Analytics')]");
	public final static By elem_Authentication = By
			.xpath("//*[@id='addNewApiPolicyTemplateStepsModal']//a[contains(text(),'Authentication')]");
	public final static By elem_Metering = By
			.xpath("//*[@id='addNewApiPolicyTemplateStepsModal']//a[contains(text(),'Metering')]");
	public final static By elem_RateLimit = By
			.xpath("//*[@id='addNewApiPolicyTemplateStepsModal']//a[contains(text(),'Rate-Limit')]");
	public final static By elem_AppsLimit = By
			.xpath("//*[@id='addNewApiPolicyTemplateStepsModal']//a[contains(text(),'Apps-Limit')]");
	public final static By elem_UsersLimit = By
			.xpath("//*[@id='addNewApiPolicyTemplateStepsModal']//a[contains(text(),'Users-Limit')]");
	public final static By elem_DevicesLimit = By
			.xpath("//*[@id='addNewApiPolicyTemplateStepsModal']//a[contains(text(),'Devices-Limit')]");
	public final static By elem_Custom = By
			.xpath("//*[@id='addNewApiPolicyTemplateStepsModal']//a[contains(text(),'Custom')]");

	public final static By searchApiTemplates = By.xpath(".//*[@id='apiPolicyTemplateGridSearch']//input");
	
	
	public final static By packagesLink = By.linkText("Packages");
	public final static By btn_createApiPackage = By.id("createApiPackage");
	public final static By CreateApiPkgModal = By.xpath(".//*[@id='addNewApiPackageStepsModal']");
	public final static By API_Package_Name = By
			.xpath(".//*[@id='apiPkgDetailsForm']//input[@placeholder='API Package Name']");
	public final static By API_Package_Desc = By
			.xpath(".//*[@id='apiPkgDetailsForm']//textarea[@placeholder='API Package description']");
	public final static By API_Package_Version = By
			.xpath(".//*[@id='apiPkgDetailsForm']//input[@placeholder='API Package version']");
	public final static By nxtBtn = By.xpath(".//button[@name='nextBtn']");
	public final static By uploadButton = By.xpath(".//*[@id='uploadButton']/span");
	public final static By finishButton = By.xpath(".//button[@name='finishBtn']");
	public final static By searchApiPackages = By.xpath(".//*[@id='searchApiPackages']");
	public final static By close = By.xpath(".//span[text()='×']");
	public final static By toast = By.xpath(".//*[@id='toast-container']/div/div[2]/div");
	public final static By toast_error = By.xpath(".//*[@id='toast-container']//div[text()='Error']");
	public final static By apiPackagesTile = By.xpath(".//a[@id='apiPackagesTile']/p");
	public final static By apisListTile = By.xpath(".//a[@id='apisListTile']/p");
	public final static By apiPolicyTemplatesTile = By.xpath(".//a[@id='apiPolicyTemplatesTile']/p");
	public final static By apiPlanSubscribersTile_hits = By.xpath(".//div[@id='apiPlanSubscribersTile']/p[1]");
	public final static By apiPlanSubscribersTile_request = By.xpath(".//div[@id='apiPlanSubscribersTile']/p[3]");
	public final static By apiPlanSubscribersTile_resonse = By.xpath(".//div[@id='apiPlanSubscribersTile']/p[4]");
	public final static By pkgDetails_name = By
			.xpath(".//*[@class='details-sub-container']/div[@id='pkgDetails']//span[1]");
	public final static By pkgDetails_version = By
			.xpath(".//*[@class='details-sub-container']/div[@id='pkgDetails']//span[2]");
	public final static By pkgDetails_desc = By.xpath(".//*[@class='details-sub-container']/div[@id='pkgDetails']//p");
}
