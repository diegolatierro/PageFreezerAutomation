package pageFactory;//Page factory

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Gmail {

    /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;
    
    @FindBy(css="#identifierId")
    WebElement loginFieldUserName;  
    
    @FindBy(css="#identifierNext")
    WebElement loginUserNextButton;
    
    @FindBy(css="input[autocomplete='current-password']")
    WebElement loginFieldPassword;
    
    @FindBy(css="#passwordNext")
    WebElement loginPassNextButton;
    
    @FindBy(css="colgroup+tbody>tr:first-child")
    WebElement firstEmail;
    
    @FindBy(css="#allow")
    WebElement authorizeAppButton;
    
    @FindBy(css=".m_5105465818631813422mcnButton")
    WebElement connectToPageFreezerEmailButton;
    
    public Gmail(WebDriver driver){
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
    
    //Click on next user button
    public void clickNextUser(){
    	loginUserNextButton.click();
    }
    
    //Click on next user button
    public void clickNextPass(){
    	loginPassNextButton.click();
    }
    
    //click on the first email
    public void clickFirstEmail() {
    	firstEmail.click();
    }
    
    public void clickConnectToPageFreezer() {
    	connectToPageFreezerEmailButton.click();
    }
    
    public void clickAuthorizeApp() {
    	authorizeAppButton.click();
    }
    

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */

    public void loginGmail(String strUserName,String strPasword){
        //Fill user name
        this.setUserName(strUserName);
        // click on next
        this.clickNextUser();
        this.pause();
        //Fill password
        this.setPassword(strPasword);
        //Click on next
        this.clickNextPass();
    }
    public void checkFirstEmailAndClickConnect() {
    	this.pause();
    	this.clickFirstEmail();
    	this.clickConnectToPageFreezer();
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