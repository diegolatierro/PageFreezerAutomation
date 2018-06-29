package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.Facebook;

public class TestCreateFacebookPost {

    WebDriver driver;
    Facebook objFacebook;

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
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
	    String post = "automated post from DiegoBot";
	    //Create Login Page object
	    objFacebook = new Facebook(driver);
	    //login to application
	    objFacebook.loginFacebook("richardho@pagefreezer.com", "1LcDkAFQH5tl");
	    //create a post
	    objFacebook.createAPost(post);
    }
}