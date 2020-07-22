package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtils;

public class LoginPagePageObject  extends BasePageObject{
	WaitUtils waitUtil = new WaitUtils();
	public LoginPagePageObject(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="username")
	WebElement user;
	
	public LoginPagePageObject enterUserName(String name){
		user.click();
		user.sendKeys(name);
		return this;
	}
	
	@FindBy(id="password")
	WebElement password;
	
	public LoginPagePageObject enterUserPassword(String pwd){
		waitUtil.waitForElementToAppear(password, driver);
		password.click();
		password.sendKeys(pwd);
		return this;
	}
	
	@FindBy(id="login-submit")
	WebElement loginButton;
	
	public LoginPagePageObject clickOnSubmitLogin(){
		loginButton.click();
		return this;
	}
	
	public LoginPagePageObject login(String username,String password) {
		enterUserName(username).clickOnSubmitLogin().enterUserPassword(password).clickOnSubmitLogin();
		return this;
	}
	
}
