package com.gateway.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	WebDriver driver;
	File file;

	public Screenshot(WebDriver driver) {
		this.driver = driver;
	}

	public String getSnap() {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			file = new File("E:/GatewayAutomation/Screenshots/" + System.currentTimeMillis() + ".png");
			FileUtils.copyFile(src, file);

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return file.toString();

	}

}
