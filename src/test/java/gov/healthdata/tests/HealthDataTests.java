package gov.healthdata.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import gov.healthdata.utilities.Driver;


/*
 * This class will have all the TestNG TestCases.
 */
public class HealthDataTests {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver=Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		Driver.closeDriver();
	}
	
	
}
