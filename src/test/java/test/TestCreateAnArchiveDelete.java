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

public class TestCreateAnArchiveDelete {

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
		3. Write a twitter account
		4. Check the get messages option
		5. Write an admin email
		6. Click on Next
		7. Select __TESTGROUP on the group
		8. Select Manager on Archive Role
		9. Click on Save
		10. Click on delete link
		11. Type delete on the field
		12. Click on Delete button"
     * 		
     */

    @Test(priority=0)
    public void test_Create_Archive_Delete(){
    
    	String URL = "https://twitter.com/DiegoTest3";
    	String email = "diegopagefreezer@gmail.com";
    	String twitterUser = "@DiegoTest3";
    	String twitterPass = "latierro050985";
    	String gmailPass = "latierro050985";
    	String archive = "DiegoTest";
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
		//CHECK THE CHECKBOX
		objCreateArchiveFrom.checkGetMessages();
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
	
		//Email section
		//go to gmail and open the email
		// step  10 Check and click the email to connect the account (BASIC HTML)
		driver.get("https://mail.google.com/mail/u/0/h/1isycmedm1c6q/?&");
		objGmail.loginGmail(email, gmailPass);
		//step 11 Click on connect button from the email
		objGmail.checkFirstEmailAndClickConnect();
		
		//step 12. Click on Authorize
		//it will ask for user and pass from twitter
		objGmail.completeTwDataOnEmail(twitterUser, twitterPass);
		objGmail.clickAuthorizeApp();
		
		//assert success lightbox and close it
		Assert.assertTrue(objDashboardPage.getSuccessModalAlert().equals("You have been successfully authenticated"));
		//I should close the modal but since html is complicated is easier to reload the page
		driver.get("https://sm2.pagefreezer.com/dashboard");
		
		//step 13. Search for the archive recently created
		objDashboardPage.searchArchive(archive);
		//step 14. Verify Data collection on Social Media Dashboard"
		Assert.assertTrue(objDashboardPage.getArchiveDataCollectionStatus().equals("Public, Private"));
		
		//add a final module to delete
		//after the validation the test must destroy the objects
		objDashboardPage.deleteArchive();
    }
}