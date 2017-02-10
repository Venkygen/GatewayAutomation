package com.gateway.repository;

import org.openqa.selenium.By;

public class CommonPage {
		
	public final static By analytics = By.xpath(".//b[text()='Analytics']");
	public final static By authentication = By.xpath(".//b[text()='Authentication']");
	public final static By appsLimit = By.xpath(".//b[text()='Apps Limit']");
	public final static By usersLimit = By.xpath(".//b[text()='Users Limit']");
	public final static By devicesLimit = By.xpath(".//b[text()='Devices Limit']");
	public final static By hitsMetering = By.xpath(".//b[text()='Hits Metering']");
	public final static By payloadMeteringRequest = By.xpath(".//b[text()='Payload Metering 1']");
	public final static By payloadMeteringResponse = By.xpath(".//b[text()='Payload Metering 1']");
	public final static By FrequencyRateLimit = By.xpath(".//b[text()='Frequency Rate-limit']");
	public final static By PayloadRL_Crequest = By.xpath(".//b[text()='Payload Rate-limit 1']");
	public final static By PayloadRL_Cresponse = By.xpath(".//b[text()='Payload Rate-limit 2']");
	public final static By PayloadRL_Request = By.xpath(".//b[text()='Payload Rate-limit 3']");
	public final static By PayloadRL_Response = By.xpath(".//b[text()='Payload Rate-limit 4']");
	public final static By customRequest = By.xpath(".//b[text()='Custom 1']");
	public final static By customResponse = By.xpath(".//b[text()='Custom 2']");
	public final static By monetization = By.xpath(".//b[text()='Monetization']");
	public final static By messageLog = By.xpath(".//b[text()='Message Log']");
	
}
