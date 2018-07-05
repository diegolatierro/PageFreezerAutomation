package demoTests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.SalesForceLogin;
import pageFactory.SalesforceChatter;

public class TestCreatePoll {

    WebDriver driver;
    SalesForceLogin objLogin;
    SalesforceChatter objChatterPage;

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://na72.lightning.force.com/lightning/page/chatter");
    }

    /**
     * This test go to http://login.salesforce.com
     * Login to application
     * create a chatter post
     * 		
     */

    @Test(priority=0)
    public void test_Create_Chatter_Post(){
    String message = "automated message poll from DiegoBot4";
    String choice1 = "choice1 auto message";
    String choice2 = "choice2 auto message";
    //Create Login Page object
    objLogin = new SalesForceLogin(driver);
    //login to application
    objLogin.loginToSalesforce("diegolatierro@pf.com", "latierro050985");
    objChatterPage = new SalesforceChatter(driver);
    //create a chatter post
    objChatterPage.createChatterPoll(message, choice1, choice2);
    //verify if text is present
    Assert.assertTrue(objChatterPage.verifyTextPresent(message));
    }
}