package com.gateway.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	public WebDriver driver=null;

	
	 
	
	public WebDriver initializeBrowser(String Url, String Browser) {
	driver=	getBrowser(Browser);
	driver.manage().window().maximize();
		driver.get(Url);
		return driver;
	}
	
	


	public WebDriver getBrowser(String browserName) {
		ThreadLocal<WebDriver> driver=null;
		switch (browserName) {
		case "Firefox":
		
			if (driver == null) {
//				driver = new FirefoxDriver();
				
				
				  driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
						   {
						      @Override
						      protected WebDriver initialValue()
						      {
						         return new FirefoxDriver(); // can be replaced with other browser drivers
						      }
						   };
						   
				
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
			}
//			break;
		case "IE":
			
			if (driver == null) {
				System.setProperty("webdriver.ie.driver", "C:\\Users\\abc\\Desktop\\Server\\IEDriverServer.exe");
				  driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
						   {
						      @Override
						      protected WebDriver initialValue()
						      {
						         return new FirefoxDriver(); // can be replaced with other browser drivers
						      }
						   };
			
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			}
			break;
		case "Chrome":
			
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver.exe");
				  driver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
						   {
						      @Override
						      protected WebDriver initialValue()
						      {
						         return new ChromeDriver(); // can be replaced with other browser drivers
						      }
						   };
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			}
			break;
		}
		return driver.get();
	}

	public void closeAllDriver() {
		driver.quit();

	}

	public WebDriver getDriver() {
		return driver;

	}

}
