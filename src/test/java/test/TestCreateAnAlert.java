package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.SocialMediaAlertDashboard;
import pageFactory.SocialMediaAlertCreation;
import pageFactory.SocialMediaLogin;

public class TestCreateAnAlert {

    WebDriver driver;
    SocialMediaLogin objLogin;
    SocialMediaAlertDashboard objAlertDashboardPage;
    SocialMediaAlertCreation objAlertCreationPage;

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("https://sm2.pagefreezer.com/login");
    }

    /**
     * This test go to http://login.salesforce.com
     * Login to application
     * create a chatter post
     * 		
     */

    @Test(priority=0)
    public void test_Create_Alert(){
    String name = "automated alert";
    String network = "facebook";
    String keyword  = "diegol,";//separated by coma, for picklist keyworkds use {phone}, {creditcard}, {socialsecurity}, {badwords}
    String email = "dlatierro@dlatierro.com,";
    
    //Create Login Page object
    objLogin = new SocialMediaLogin(driver);
    //login to application
    objLogin.loginToSocialMedia("diegolatierro@gmail.com", "Cohiba3672!");
    objAlertDashboardPage = new SocialMediaAlertDashboard(driver);
    objAlertCreationPage = new SocialMediaAlertCreation(driver);
    //go to alert creation
    objAlertDashboardPage.goToAlertCreation();
    
    //create a chatter post
    objAlertCreationPage.createANetworkAlert(name, network, email);
    //objAlertCreationPage.createAnAccountAlert(name);
    //verify if text is present
    //Assert.assertTrue(objAlertPage.verifyTextPresent(message));
    }
}