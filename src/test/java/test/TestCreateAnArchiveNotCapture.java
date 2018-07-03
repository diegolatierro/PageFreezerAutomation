package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.SocialMediaAlertDashboard;
import pageFactory.SocialMediaCreateArchiveFrom;
import pageFactory.SocialMediaLogin;
import pageFactory.Gmail;

public class TestCreateAnArchiveNotCapture {

    WebDriver driver;
    SocialMediaLogin objLogin;
    SocialMediaAlertDashboard objAlertDashboardPage;
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
    
    	String URL = "https://twitter.com/DiegoTest3";
    	String email = "diegopagefreezer@gmail.com";
    	//String gmailUser = "";
    	String gmailPass = "latierro050985";
    	objGmail = new Gmail(driver);
	/*	//Create Login Page object
		objLogin = new SocialMediaLogin(driver);
		//login to application
		objLogin.loginToSocialMedia("diegolatierro@gmail.com", "Cohiba3672!");
		objAlertDashboardPage = new SocialMediaAlertDashboard(driver);
		objCreateArchiveFrom  = new SocialMediaCreateArchiveFrom(driver);
		// step 1 and 2 Click on Create Archive and Select Twitter
		objAlertDashboardPage.clickCreateArchiveTwitter();
		// step 3 Write a twitter account
		objCreateArchiveFrom.writeURL(URL);
		//do not check the checkbox
		// step 4 Write an admin email
		objCreateArchiveFrom.writeEmail(email);
		// step 5 Click on Next
		objCreateArchiveFrom.clickOnNext();
		//step 6 Select __TESTGROUP on the group
		objCreateArchiveFrom.selectGroup();
		// step 7 Select Manager on Archive Role
		objCreateArchiveFrom.selectRole();
		// step 8 Click on Save
		objCreateArchiveFrom.clickOnCreate();
		// step 9 Click on Resend the email CAN BE SKIPPED
	*/
		//Email section
		//go to gmail and open the email
		// step  10 Check and click the email to connect the account
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		objGmail.loginGmail(email, gmailPass);
		//step 11 Click on connect button from the email
		objGmail.checkFirstEmailAndClickConnect();//NOT CLICKING NOW!!! FIX THIS
		
		//step 12. Click on Authorize
		//objGmail.clickAuthorizeApp();
		//step 13. Search for the archive recently created
		
		//step 14. Verify Data collection on Social Media Dashboard"
		
		
		//verify if text is present
		//Assert.assertTrue(objAlertPage.verifyTextPresent(message));
		
		//add a final module to delete
		
    }
}