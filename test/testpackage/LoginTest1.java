package testpackage;

import com.thoughtworks.selenium.Selenium;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginTest1 {

    private WebDriver driver;
    private String expected;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testLoginTest1() throws Exception {
        /**
         * This test case is for check that the functionality of user cannot access
         * home page after failed logging in
         */
        String urlExpected="http://localhost/Fault/users/edit/4";
        String trueVal="http://localhost/Fault/users/login";
        driver.get(trueVal);
        driver.findElement(By.id("UserUsername")).sendKeys("chathura");
        driver.findElement(By.id("UserPassword")).sendKeys("passwo");
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        Thread.sleep(5000);
        driver.get(urlExpected);
    
        
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
