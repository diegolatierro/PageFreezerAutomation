package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.SocialMediaAlertDashboard;
import pageFactory.SocialMediaLogin;

public class TestCreateAnArchiveNotCapture {

    WebDriver driver;
    SocialMediaLogin objLogin;
    SocialMediaAlertDashboard objAlertDashboardPage;

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("https://sm2.pagefreezer.com/login");
    }

    /**
     * "1. Click on Create Archive
		2. Select Twitter
		3. Write a twitter account
		4. Write an admin email
		5. Click on Next
		6. Select __TESTGROUP on the group
		7. Select Manager on Archive Role
		8. Click on Save
		9. Click on Resend the email
		10. Check and click the email to connect the account
		11. Click on connect button from the email
		12. Click on Authorize
		13. Search for the archive recently created
		14. Verify Data collection on Social Media Dashboard"
     * 		
     */

    @Test(priority=0)
    public void test_Create_Archive_No_Capture(){
    
    //Create Login Page object
    objLogin = new SocialMediaLogin(driver);
    //login to application
    objLogin.loginToSocialMedia("diegolatierro@gmail.com", "Cohiba3672!");
    objAlertDashboardPage = new SocialMediaAlertDashboard(driver);
    
    
    //create a chatter post
    //objAlertCreationPage.createANetworkAlert(name, network, email);
    //verify if text is present
    //Assert.assertTrue(objAlertPage.verifyTextPresent(message));
    }
}