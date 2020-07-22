package utils;

import org.openqa.selenium.WebDriver;

public class BrowserUtils {
	
	public static void openUrl(String url, WebDriver driver) {
		driver.get(url);
	}
}
