package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.LinkedIn;

public class TestCreateLinkedInPost {

    WebDriver driver;
    LinkedIn objLinkedIn;

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.linkedin.com/");
    }

    /**
     * This test go to http://login.salesforce.com
     * Login to application
     * create a chatter post
     * 		
     */

    @Test(priority=0)
    public void test_Create_Chatter_Post(){
    	//CREATE A PARAMETER THAT CREATE DIFFERENT TWEETS WITH THE KEYWORDS
	    String message = "automated post from DiegoBot";
	    //Create Login Page object
	    objLinkedIn = new LinkedIn(driver);
	    //login to application
	    objLinkedIn.loginToLinkedIn("richardho@pagefreezer.com", "yPKxLojil32N");
	    //create a linkedin post
	    objLinkedIn.createALinkedInPost(message);
    }
}