package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.SocialMediaDashboard;
import pageFactory.SocialMediaCreateArchiveFrom;
import pageFactory.SocialMediaLogin;
import pageFactory.Gmail;

public class TestCreateArchiveValidateNoEmailError {

    WebDriver driver;
    SocialMediaLogin objLogin;
    SocialMediaDashboard objDashboardPage;
    SocialMediaCreateArchiveFrom objCreateArchiveFrom;
    Gmail objGmail;

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("https://sm2.pagefreezer.com/login");
    }

    /**
     * "1. Click on Create Archive
		2. Select Twitter
		3. Click Next
		4. fill out email field and click next
		5. empty email field
		6. fill out url field and click next"
     * 		
     */

    @Test(priority=0)
    public void test_Create_Archive_Validate_No_Email(){
    
    	String URL = "https://twitter.com/DiegoTest3";
    	String email = "";
    	
    	objGmail = new Gmail(driver);
		//Create Login Page object
		objLogin = new SocialMediaLogin(driver);
		//login to application
		objLogin.loginToSocialMedia("diegolatierro@gmail.com", "Cohiba3672!");
		objDashboardPage = new SocialMediaDashboard(driver);
		objCreateArchiveFrom  = new SocialMediaCreateArchiveFrom(driver);
		// step 1 and 2 Click on Create Archive and Select Twitter
		objDashboardPage.clickCreateArchiveTwitter();
		// step 3 Write a twitter account
		objCreateArchiveFrom.writeURL(URL);
		// step 4 Write an admin email
		objCreateArchiveFrom.writeEmail(email);
		// step 5 Click on Next
		objCreateArchiveFrom.clickOnNext();
		//CAPTURE THE ERROR
		Assert.assertTrue(objCreateArchiveFrom.getEmailErrorMessage().equals("Required field"));
    }
}