/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testpackage;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;

import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
/*
 * Following function tests that is the user is able to access user - edit page without logging. 
 * Which should not be able to happen. 
 */
  @Test
  public void testAccessEditsWithoutLogin() throws Exception {
        String urlExpected="http://localhost/Fault/users/edit/4";
        String trueVal="http://localhost/Fault/users/login";
        driver.get(urlExpected);
        assertEquals(trueVal, driver.getCurrentUrl());
        Thread.sleep(5000);
  }
  
  /*
 * Following function tests that is the user is able to access Main page without logging. 
 * Which should not be able to happen. 
 */
  @Test
  public void testAccessMainWithoutLogin() throws Exception {
        String urlExpected="http://localhost/Fault/";
        String trueVal="http://localhost/Fault/users/login";
        driver.get(urlExpected);
        assertEquals(trueVal, driver.getCurrentUrl());
        Thread.sleep(5000);
  }
  
  /*
   * Closing the browser window
   */
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }


}

