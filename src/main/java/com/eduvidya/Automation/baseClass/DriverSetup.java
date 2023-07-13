package com.eduvidya.Automation.baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSetup 
{
	private static WebDriver driver;
	
	//Method to set up Google Chrome driver
	public static WebDriver setupChromeDriver()
	{
		//Setting system property to set the path of the driver for Chrome browser
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		
		ChromeOptions co = new ChromeOptions();
		
		//To start the browser in maximized window
		co.addArguments("start-maximized");
		
		//Creating WebDriver class for the Chrome browser
		driver = new ChromeDriver(co);
		return driver;
	}
		
	//Method to setup Mozilla Firefox driver
	public static WebDriver setupFirefoxDriver()
	{
		//Setting system property to set the path of the driver for Firefox browser
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		FirefoxBinary fb = new FirefoxBinary();
		FirefoxOptions fo = new FirefoxOptions();	
		fo.setBinary(fb);
		
		//Creating WebDriver class for the Firefox browser
		driver = new FirefoxDriver(fo);
		//To maximize the browser window
		driver.manage().window().maximize();
		return driver;
	}
	
	//Method to setup Microsoft Edge driver
	public static WebDriver setupEdgeDriver() 
	{
		EdgeOptions eo = new EdgeOptions();
			
		//To start the browser in maximized window
		eo.addArguments("start-maximized");

		// Creating WebDriver class for the Edge browser
		driver = new EdgeDriver(eo);
		return driver;
	}	
}


