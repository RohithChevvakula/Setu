package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
    
    
    public WebElement wait(String xpath, WebDriver driver){
    	wait = new WebDriverWait(driver, explicitWaitDefault);
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    
    public WebElement waitForElementToAppear(WebElement element, WebDriver driver){
    	wait = new WebDriverWait(driver, explicitWaitDefault);
    	return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public boolean waitForElementToDisappear(WebElement element, WebDriver driver){
    	wait = new WebDriverWait(driver, explicitWaitDefault);
    	return wait.until(ExpectedConditions.invisibilityOf(element));
    }
    
    public WebElement waitForElementToAppearAndEnable(WebElement element, WebDriver driver){
    	wait = new WebDriverWait(driver, explicitWaitDefault);
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    	return element;
    }
    
    public boolean isPresent(WebElement element){
    	
    	try {
    		boolean f = element.isDisplayed();}
    	catch(NoSuchElementException e){
    		System.out.println("Element is not on the screen.");
    	}
    	return element.isDisplayed();
    }

}
