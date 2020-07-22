package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtils;

public class HomePagePageObject  extends BasePageObject{
	WaitUtils waitUtil = new WaitUtils();
	public HomePagePageObject(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="create-issue-submit")
	WebElement create;
	
	@FindBy(xpath="//*[@id='demo-dialog']/div/iframe")
	WebElement iFrame;
	
	@FindBy(xpath="//span[text()='Upload a file']/parent::span/parent::button")
	WebElement upload;
	
	@FindBy(xpath="//span[contains(text(),'Insert')]/parent::span/parent::button")
	WebElement insert;
	
	@FindBy(id="createGlobalItem")
	WebElement createButton;
	

	@FindBy(id="summary")
	WebElement summary;
	
	@FindBy(xpath="//button[@class='issue-drop-zone__button']")
	WebElement browse;
	
	@FindBy(xpath="//div[contains(text(),'Upload in progress, please wait.')]")
	WebElement uploading;
	
	public HomePagePageObject clickOnCreateButton(){
		waitUtil.waitForElementToAppear(createButton, driver).click();
		return this;
	}
	
	
	public HomePagePageObject enterSummary(String keysToSend){
		waitUtil.waitForElementToAppear(summary, driver).sendKeys(keysToSend);
		return this;
	}
	
	public HomePagePageObject createJiraTicket(){
		do{
			waitUtil.waitForElementToAppear(create, driver).click();
			System.out.println("still uploading");
		}while(waitUtil.isPresent(uploading));
			
		return this;
	}
	
	public HomePagePageObject clickOnBrowseFile(){
		waitUtil.waitForElementToAppear(browse, driver).click();
		return this;
	}
	
	
	
	
	public HomePagePageObject uploadFile(String path) throws AWTException {
		waitUtil.waitForElementToAppear(iFrame, driver);
		driver.switchTo().frame(iFrame);
		waitUtil.waitForElementToAppear(upload, driver).click();
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(500);
		//Open Goto window
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_G);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_G);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_META);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_META);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2500);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		waitUtil.waitForElementToAppearAndEnable(insert, driver).click();
		driver.switchTo().parentFrame();
		return this;
	}
	
}
