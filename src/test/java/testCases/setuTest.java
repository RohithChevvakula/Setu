package testCases;

import java.awt.AWTException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePagePageObject;
import pageObjects.LoginPagePageObject;
import utils.BrowserUtils;
import utils.PropertyUtils;

public class setuTest extends BaseTest{

	
	@Test(priority=1)
	void login(){
		BrowserUtils.openUrl(PropertyUtils.getProperty("url"), driver);
		LoginPagePageObject login = new LoginPagePageObject(driver);
		login.login(PropertyUtils.getProperty("user"),PropertyUtils.getProperty("password"));
	}
	
	
	@Test(priority=2)
	void testCaseOne() throws AWTException, InterruptedException{
		HomePagePageObject home = new HomePagePageObject(driver);
		home.clickOnCreateButton().enterSummary(PropertyUtils.getProperty("summary"));
		home.clickOnBrowseFile();
		home.uploadFile(System.getProperty("user.dir")+"/Skype.dmg");
		home.selectUser("rohith chevvakula");
		home.createJiraTicket();
		
	}


	@BeforeTest
	@Override
	public void setUpPage() {
		
		
	}
	
	
}
