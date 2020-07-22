package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.PropertyUtils;
import utils.ScreenshotUtility;
import utils.WaitUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

@Listeners({ScreenshotUtility.class})
public abstract class BaseTest {
	public static WebDriver driver;
    public final static int IMPLICIT_WAIT = Integer.parseInt(PropertyUtils.getProperty("implicitWait", "30"));
    public static WaitUtils waitUtils = new WaitUtils();
    
    
    @BeforeClass
    public void setUpAppium() throws MalformedURLException {
    		driver = new ChromeDriver();
    		driver.manage().window().maximize();
//    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    	
    @BeforeTest
    public abstract void setUpPage();

    @AfterMethod(alwaysRun = true)
    public void afterMethod(final ITestResult result) throws IOException {
        String fileName = result.getTestClass().getName() + "_" + result.getName();
        System.out.println("Test Case: [" + fileName + "] executed..!");
    }

    @AfterClass
    public void afterClass() {
    }

    @AfterSuite
    public void tearDown() {
        quitDriver();
    }

    private void quitDriver() {
        try {
            this.driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}