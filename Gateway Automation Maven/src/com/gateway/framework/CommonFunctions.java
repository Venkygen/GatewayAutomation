package com.gateway.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gateway.repository.PackagesPage;
import com.gateway.utility.Screenshot;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CommonFunctions {
	private WebDriver driver;
	private ExtentTest test;
	private Screenshot sc;

	public CommonFunctions(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		sc = new Screenshot(driver);
	}

	public void waitForPageToLoad(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(by)).isEnabled();
		} catch (Exception e) {
 
			e.printStackTrace();
		}
	}

	
	public void waitForPageToLoad(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element)).isEnabled();
		} catch (Exception e) {
 
			e.printStackTrace();
		}
	}
	
	public void click(By by) {

		try {

			waitForPageToLoad(by);
			WebElement element = driver.findElement(by);
			String textOnElement = element.getText();
			element.click();
			test.log(LogStatus.PASS, "Clicked on the " + textOnElement);

		} catch (Exception e) {

			test.log(LogStatus.FAIL, "Element Click failed", test.addScreenCapture(sc.getSnap()));
			e.printStackTrace();
		}
	}

	public void setText(By by, String text) {
		try {
			waitForPageToLoad(by);
			driver.findElement(by).sendKeys(text);
			// test.log(LogStatus.PASS, "Entered " + text);
		} catch (Exception e) {

			test.log(LogStatus.FAIL, "Unable to Enter the text " + text);
			test.log(LogStatus.FAIL, "Unable to Enter the text " + text, test.addScreenCapture(sc.getSnap()));
			e.printStackTrace();
		}
	}

	public void setTextAndEnter(By by, String text) {
		try {

			WebElement element = driver.findElement(by);
			driver.findElement(by).sendKeys(text);
			element.sendKeys(Keys.ENTER);
			test.log(LogStatus.PASS, "Entered " + text);
		} catch (Exception e) {

			test.log(LogStatus.FAIL, "Unable to Enter the text " + text);
			test.log(LogStatus.FAIL, "Unable to Enter the text " + text, test.addScreenCapture(sc.getSnap()));
			e.printStackTrace();
		}
	}
	
	
	public void verifyActualExpected(String Actual, String Expected) {

		try {
			Assert.assertEquals(Actual, Expected);
			test.log(LogStatus.PASS, Expected + " Found");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, Expected + " didnot Found");
			test.log(LogStatus.FAIL, Expected + " didnot Found", test.addScreenCapture(sc.getSnap()));
			e.printStackTrace();
		}

	}

	public void clickOnTab(String TabName) {
		try {
			waitForPageToLoad(By.xpath(".//div[@class='details-sub-container']"));
			driver.findElement(By.xpath(".//div[@class='details-sub-container']//span[text()='" + TabName + "']"))
					.click();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, TabName + " Not Found");
			test.log(LogStatus.FAIL, TabName + " Not Found", test.addScreenCapture(sc.getSnap()));
			e.printStackTrace();
		}

	}

	public void Select(By by, String text) {
		try {
			WebElement element = driver.findElement(by);
			waitForPageToLoad(element);
			Select oSelect = new Select(element);
			oSelect.selectByVisibleText(text);

		} catch (Exception e) {
			test.log(LogStatus.FAIL, text + " Not Found");
			test.log(LogStatus.FAIL, text + " Not Found", test.addScreenCapture(sc.getSnap()));
			e.printStackTrace();
		}

	}

	public String getText(By by) {
		waitForPageToLoad(by);
		return driver.findElement(by).getText().toString();
	}
	
	public boolean isDisplayed(By by) {
		boolean isVisible=false;
		try {
			waitForPageToLoad(by);
			if(driver.findElement(by).isDisplayed()){
				 isVisible = true;	
			}else{
				isVisible= false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isVisible;
	}
	
	public boolean isEnabled(By by) {
		waitForPageToLoad(by);
		if(driver.findElement(by).isEnabled()){
			return true;	
		}else{
			return false;
		}
		
	}

	public void VerifyToast() {
		if (driver.findElement(PackagesPage.toast_Success).isDisplayed()) {
			String msg = getText(PackagesPage.toast);
			test.log(LogStatus.PASS, msg);
		} else if (driver.findElement(PackagesPage.toast_error).isDisplayed()) {
			String error = getText(PackagesPage.toast);
			test.log(LogStatus.FAIL,  error);
			test.log(LogStatus.FAIL, "Tempalte Creation Failed: " + error, test.addScreenCapture(sc.getSnap()));
			click(PackagesPage.close);

		}
		
	}

}
