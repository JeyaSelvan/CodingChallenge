package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtils {
	public static void implicitWait(WebDriver driver, long timeout)  {
			driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public static WebElement explicitWait(WebDriver driver, WebElement element, long timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			WebElement foundElement = wait.until(ExpectedConditions.visibilityOf(element));
			return foundElement;
	}	
	
}
