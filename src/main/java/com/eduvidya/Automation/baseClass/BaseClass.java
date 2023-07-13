package com.eduvidya.Automation.baseClass;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseClass 
{
	public static WebDriver driver;
	Scanner sc = new Scanner(System.in);
	
	//Method to start the browser before starting the test 
	// Available choices for browsers are "Chrome", "Edge", "Firefox"
	@BeforeMethod
	public void startBrowser() 
	{
		try
		{
			//Asking the user for input in the to choose the browser for running the test
			System.out.println("Enter the choice of browser to run the automation as per below choices:");
			System.out.println("Chrome\nEdge\nFirefox");
			String browser = sc.next();
			
			// Browser is opened as per the input
			if (browser.equalsIgnoreCase("Edge")) 
			{
				driver = DriverSetup.setupEdgeDriver();
				Reporter.log("Edge browser is opened", true);
			} 
			else if (browser.equalsIgnoreCase("Firefox")) 
			{
				driver = DriverSetup.setupFirefoxDriver();
				Reporter.log("Firefox browser is opened", true);
			} 
			else 
			{
				driver = DriverSetup.setupChromeDriver();
				Reporter.log("Chrome browser is opened", true);
			}
		}
		catch (Exception e) 
		{
			Reporter.log("Testing Failed due to Exception: " + e.toString(), true);
			Assert.fail();
		}
		
	}

	// Method to close driver after test is completed
	@AfterMethod
	public void closeDriver() 
	{
		try 
		{
			driver.close();
			Reporter.log("Browser is closed", true);
		} 
		catch (Exception e) 
		{
			Reporter.log("Testing Failed due to Exception: " + e.toString(), true);
			Assert.fail();
		}
	}
	
	//Method to close the Scanner after the whole test suite is completed
	@AfterSuite
	public void closeScanner() 
	{
		sc.close();
	}
}
