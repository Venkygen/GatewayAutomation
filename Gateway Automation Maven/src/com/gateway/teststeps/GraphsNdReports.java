package com.gateway.teststeps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gateway.framework.CommonFunctions;
import com.gateway.repository.PackagesPage;
import com.gateway.repository.QuickPublishPage;
import com.gateway.utility.PropertiesFile;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GraphsNdReports {


	private WebDriver driver;
	private ExtentTest test;
	CommonFunctions act;
	private Screenshot sc;

	public GraphsNdReports(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		act = new CommonFunctions(driver, test);
		sc = new Screenshot(driver);
	}

	
	public void verifyGraph() {
		
		WebElement svg = driver.findElement(By.cssSelector("svg"));
		List<WebElement> outertext = svg.findElements(By.cssSelector("text"));

		                for(WebElement texts : outertext)
		                    {
		                        String textcollection = texts.getText();
		                        System.out.println(textcollection);
//		                        if(textcollection.equals("xxxxxx"))
//		                            {
//		                                texts.click();
//		                            }
		                    }
	
		
		
		
	}

}
