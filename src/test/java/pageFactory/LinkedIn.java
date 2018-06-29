package pageFactory;//Page factory

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedIn {

    /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;
    
    @FindBy(css="#login-email")
    WebElement loginFieldUserName;  
    
    @FindBy(css="#login-password")
    WebElement loginFieldPassword;
    
    @FindBy(css="#login-submit")
    WebElement loginButton;
    
    
    @FindBy(css=".Sans-17px-black-70\\%")
    WebElement createPostButton;
    
    @FindBy(css=".mentions-texteditor__contenteditable")
    WebElement postField;

    @FindBy(css="button[data-control-name='share.post']")
    WebElement postButton;
    
    public LinkedIn(WebDriver driver){
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
    
    //click on new post button
    public void clickNewPost(){
    	createPostButton.click();
    }
    //Write a post
    public void writeAPost(String tweet){
    	postField.sendKeys(tweet);
    }
    //click on new post button
    public void clickPostButton(){
    	postButton.click();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */

    public void loginToLinkedIn(String strUserName,String strPasword){
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();
    }
    public void createALinkedInPost(String message) {
    	this.clickNewPost();
    	this.writeAPost(message);
    	this.clickPostButton();
    }
}