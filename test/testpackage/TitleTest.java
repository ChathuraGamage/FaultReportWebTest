/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

/**
 *
 * @author Dell PC
 */
public class TitleTest {
    
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    
    
    public TitleTest() {
    }
       
    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }   
    
    @Test
    public void testUsersTitle() {
        String titleExpected="FaultReportApplication: Users";
        driver.get(baseUrl + "/Fault/users/");
        titleExpected=driver.getTitle();
        Assert.assertEquals(titleExpected, driver.getTitle());    
    
    }
    
   @Test
    public void testReportsTitle() {
        String titleExpected="FaultReportApplication: Reports";
        driver.get(baseUrl + "/Fault/reports/");
        titleExpected=driver.getTitle();
        Assert.assertEquals(titleExpected, driver.getTitle());    
    
    }
    
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();        
    }
}
