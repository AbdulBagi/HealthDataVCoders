package gov.healthdata.tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import gov.healthdata.pages.HealthDataMainPage;
import gov.healthdata.pages.HealthDataSearchResultPage;
import gov.healthdata.utilities.BrowserUtils;
import gov.healthdata.utilities.ConfigurationReader;
import gov.healthdata.utilities.Driver;

/*
 * This class will have all the TestNG TestCases.
 */
public class HealthDataTests {

	WebDriver driver;
	HealthDataMainPage mainPage;
	HealthDataSearchResultPage secondPage;
	String data1 = "Health";

	@BeforeMethod
	public void setUp() {
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.get(ConfigurationReader.getProperty("url"));
		mainPage = new HealthDataMainPage();
		secondPage = new HealthDataSearchResultPage();
	}

	@Test(priority = 1, description = "T003 by Khaliunaa")
	public void positiveSearch() {
		mainPage.searchField.sendKeys(data1);
		mainPage.searchButton.click();
		int count = Integer.parseInt(secondPage.searchResultNumber.getText().split(" ")[0]);
		assertTrue(count > 1, "Search result is not more than 1");
	}
	
	@Test(priority = 2, description = "T013 by Khaliunaa")
	public void tagOptions() {
		mainPage.searchField.sendKeys(data1);
		mainPage.searchButton.click();
		
		assertFalse(secondPage.medicaidLink.isDisplayed(),"Tags options are displayed");
		secondPage.tags.click();
		assertTrue(secondPage.medicaidLink.isDisplayed(), "Tags options are not displayed");
		secondPage.tags.click();
		BrowserUtils.waitFor(2);
		assertFalse(secondPage.medicaidLink.isDisplayed(),"Tags options are displayed");
	}
	
	

	// @AfterMethod
	public void tearDown() {
		Driver.closeDriver();
	}

}
