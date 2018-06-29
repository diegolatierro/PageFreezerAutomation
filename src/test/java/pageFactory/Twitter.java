package pageFactory;//Page factory

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Twitter {

    /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;
    
    @FindBy(css=".js-username-field")
    WebElement loginFieldUserName;  
    
    @FindBy(css=".js-password-field")
    WebElement loginFieldPassword;
    
    @FindBy(css="button.submit")
    WebElement loginButton;
    
    @FindBy(css="#global-new-tweet-button")
    WebElement createTweetButton;
    
    @FindBy(css=".is-fakeFocus > div:nth-child(2) > div:nth-child(2) > div:nth-child(1)")
    WebElement tweetField;
    
    //find a better selector
    @FindBy(css="html body.three-col.logged-in.user-style-smc2_test.ms-windows.enhanced-mini-profile.no-nav-banners.supports-drag-and-drop.modal-enabled div#Tweetstorm-dialog.TweetstormDialog.modal-container div#Tweetstorm-dialog-dialog.modal div.modal-content.TweetstormDialog-content div.modal-body div#Tweetstorm-tweet-box-0.TweetstormDialog-tweet-box.t1-form.tweet-form.initialized.is-tweet-box-focus div.tweet-box-content div.TweetBoxToolbar div.TweetBoxToolbar-tweetButton span.buttons button.SendTweetsButton.EdgeButton.EdgeButton--primary.EdgeButton--medium.js-send-tweets")
    WebElement tweetButton;
    
    public Twitter(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    //Set user name in textbox
    public void setUserName(String strUserName){
    	loginFieldUserName.sendKeys(strUserName);      
    } 

    //Set password in password textbox
    public void setPassword(String strPassword){
    	loginFieldPassword.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
    	loginButton.click();
    }
    
    //click on new tweet button
    public void clickNewTweet(){
    	createTweetButton.click();
    }
    //Write a tweet
    public void writeATweet(String tweet){
    	tweetField.sendKeys(tweet);
    }
    //click on tweet button
    public void clickTweet(){
    	tweetButton.click();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */

    public void loginTwitter(String strUserName,String strPasword){
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();
    }
    public void createATweet(String tweet) {
    	this.clickNewTweet();
    	this.writeATweet(tweet);
    	this.clickTweet();
    }
}