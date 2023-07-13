package com.eduvidya.automationTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eduvidya.Automation.baseClass.BaseClass;

public class AutomationTest extends BaseClass 
{
	public static String baseUrl = "https://www.eduvidya.com/";
	//Method to navigate to the baseUrl
	public void navigateToBaseUrl() throws Exception 
	{
		driver.get(baseUrl);
	}

	// Method to find Colleges element and navigate to Colleges link
	public void navigateToColleges() throws Exception 
	{
		driver.findElement(By.linkText("Colleges")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}

	// Method to select appropriate values for course and city and click search button
	public void searchColleges(String course, String city) throws Exception 
	{
		Select courseElement = new Select(driver.findElement(By.id("ddl_Category")));
		Select cityElement = new Select(driver.findElement(By.id("ddl_City")));
		courseElement.selectByVisibleText(course);
		cityElement.selectByVisibleText(city);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("btnSearch")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}

	//Method to close the ad in the iframe
	// Two types of ad appears when navigating from home page to colleges page
	public void closeAd() 
	{
		// Tries to close the ad having close button inside 1 ancestor iframe
		try 
		{
			driver.switchTo().frame(driver.findElement(By.id("aswift_3")));
			WebElement e = driver.findElement(By.id("dismiss-button"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", e);
			driver.switchTo().defaultContent();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		}
		// Tries to close the ad having close button inside 2 ancestor iframe
		catch (Exception error) 
		{
			try 
			{
				driver.switchTo().frame(driver.findElement(By.id("ad_iframe")));
				WebElement e = driver.findElement(By.id("dismiss-button"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click()", e);
				driver.switchTo().defaultContent();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			} 
			catch (Exception e) 
			{
				// Exception happens if ad did not pop up in the browser
				driver.switchTo().defaultContent();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			}
		}
	}

	// Testing done on the chosen Browser for searching colleges for given Course and City
	@Test(dataProvider = "DropdownData")
	public void Test(String course, String city) 
	{
		try 
		{
			navigateToBaseUrl();
			Reporter.log("EduVidya website is opened", true);

			navigateToColleges();

			closeAd();
			Reporter.log("Colleges webpage is opened", true);

			searchColleges(course, city);
			Reporter.log(String.format("Colleges are searched for course %s and city %s", course, city), true);

			if (!driver.findElement(By.xpath("//div[@class='detail-list']/ul")).getText().isEmpty()) 
			{
				Reporter.log("Search Results are displayed.", true);
			} 
			else 
			{
				Reporter.log("Search Results are not displayed.", true);
			}
		} 
		catch (Exception e) 
		{
			Reporter.log("Testing Failed due to Exception: " + e.toString(), true);
			Assert.fail();
		}
	}
	
	
	// Method to provide to the test to search for colleges
	// Data is in form {<Course Name>,<City Name>}
	@DataProvider(name = "DropdownData")
	public String[][] getData() 
	{

		String[][] data = {{ "Science", "Chennai" }};
		return data;
	}
}
