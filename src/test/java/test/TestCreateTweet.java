package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.Twitter;

public class TestCreateTweet {

    WebDriver driver;
    Twitter objTwitter;

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://twitter.com/login?lang=en");
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
	    String tweet = "automated tweet from DiegoBot";
	    //Create Login Page object
	    objTwitter = new Twitter(driver);
	    //login to application
	    objTwitter.loginTwitter("richardho@pagefreezer.com", "T57QeRrvxhL8");
	    //create a tweet
	    objTwitter.createATweet(tweet);
    }
}