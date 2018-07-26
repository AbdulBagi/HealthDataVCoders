package gov.healthdata.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class BrowserUtils {
	
	public static void hover(WebElement element) {
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(element).perform();
	}
	
	public static List<String> getElementsText(List<WebElement> list) {
		List<String> elemTexts = new ArrayList<>();
		for (WebElement el : list) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}
	
	public static List<String> getElementsText(By locator) {

		List<WebElement> elems = Driver.getDriver().findElements(locator);
		List<String> elemTexts = new ArrayList<>();

		for (WebElement el : elems) {
			if (!el.getText().isEmpty()) {
				elemTexts.add(el.getText());
			}
		}
		return elemTexts;
	}
	
	 public static String getScreenshot(String name) throws IOException {
		    // name the screenshot with the current date time to avoid duplicate name
		    String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		    
		    // TakesScreenshot ---> interface from selenium which takes screenshots
		    TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
		    File source = ts.getScreenshotAs(OutputType.FILE);
		    // full path to the screenshot location
		    String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";

		    File finalDestination = new File(target);
		    
		    // save the screenshot to the path given
		    FileUtils.copyFile(source, finalDestination);
		    return target;
		  }

}
