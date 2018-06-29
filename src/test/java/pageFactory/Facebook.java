package pageFactory;//Page factory

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facebook {

    /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;
    
    @FindBy(css="#email")
    WebElement loginFieldUserName;  
    
    @FindBy(css="#pass")
    WebElement loginFieldPassword;
    
    @FindBy(css="#u_0_2")
    WebElement loginButton;
    
    @FindBy(css=".notranslate")
    WebElement postField;
    
    //find a better selector
    @FindBy(css="._1mf7")
    WebElement postButton;
    
    @FindBy(css="#u_0_1g")
    WebElement activationPost;
    
    @FindBy(css="html>body")
    WebElement activation;
    
    public Facebook(WebDriver driver){
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
    
    //click on post for activation
    public void activatePostField() {
    	activation.click();
    	activationPost.click();
    }
    
    //Write a post
    public void writeAPost(String message){
    	postField.click();
    	postField.sendKeys(message);
    }
    //click on post button
    public void clickOnPost(){
    	postButton.click();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */

    public void loginFacebook(String strUserName,String strPasword){
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();
    }
    public void createAPost(String post) {
    	pause();
    	this.activatePostField();
    	pause();
    	this.writeAPost(post);
    	pause();
    	this.clickOnPost();
    }
    
  //NOT WRITE BUT THE ONLY WORKAROUND THAT I FOUND
  	public void pause() {
  		try {
  			Thread.sleep(5000);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	}
}