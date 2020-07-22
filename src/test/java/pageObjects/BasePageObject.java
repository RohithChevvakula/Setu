package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyUtils;
import utils.WaitUtils;

public class BasePageObject {
	public final static int IMPLICIT_WAIT = Integer.parseInt(PropertyUtils.getProperty("implicitWait", "30"));
    WaitUtils waitUtils;
    protected final WebDriver driver;

    protected BasePageObject(WebDriver driver){
        this.driver = driver;
        initElements();
        loadProperties();
        waitUtils = new WaitUtils();
    }

    private void initElements() {
        PageFactory.initElements(driver, this);
        System.out.println("init elements");
    }

    private void loadProperties() {
     System.out.println("load prop");
    }
}
