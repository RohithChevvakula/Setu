package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    public final int explicitWaitDefault = Integer.parseInt(PropertyUtils.getProperty("explicitWait", "10"));
    WebDriverWait wait ;
    public void staticWait(final long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (final InterruptedException e) {
        }
    }
    
    public WebElement waitForElementToAppear(WebElement element, WebDriver driver){
    	wait = new WebDriverWait(driver, explicitWaitDefault);
    	return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public WebElement waitForElementToAppearAndEnable(WebElement element, WebDriver driver){
    	wait = new WebDriverWait(driver, explicitWaitDefault);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    	return element;
    }

}
