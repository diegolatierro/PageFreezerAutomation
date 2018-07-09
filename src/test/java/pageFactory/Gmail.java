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
    
    @FindBy(css="table+table>tbody>tr:nth-child(1)>td:nth-child(3)>a:nth-child(1)>span")
    WebElement firstEmail;
    
    @FindBy(css="#allow")
    WebElement authorizeAppButton;
    
    @FindBy(css="a[title='  Login to PageFreezer  ']")
    WebElement connectToPageFreezerEmailButton;
    
    @FindBy(css=".msg > div:nth-child(2) > center:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > p:nth-child(6) > a:nth-child(2)")
    WebElement connectToPageFreezerLink;
    
    @FindBy(css="#username_or_email")
    WebElement twitterEmailUserField;

    @FindBy(css="#password")
    WebElement twitterEmailPassField;
    
    public Gmail(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    //Set user name in textbox twitter email name
    public void setUserNameTwitterEmail(String strUserName){
    	twitterEmailUserField.sendKeys(strUserName);      
    } 
    
    //Set pass in textbox twitter email pass
    public void setUserPassTwitterEmail(String strUserName){
    	twitterEmailPassField.sendKeys(strUserName);      
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
    	this.pause();
    	firstEmail.click();
    }
    
    //get the connect to page freezer link
    public String getConnectPageFreezerLink() {
    	return connectToPageFreezerLink.getText();
    }
    
    //modify this method to copy the url and redirect to avoid multiple tabs
    public void clickConnectToPageFreezer() {
    	//connectToPageFreezerEmailButton.click();
    	driver.get(getConnectPageFreezerLink());
    }
    
    public void clickAuthorizeApp() {
    	this.pause();
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
	public void completeTwDataOnEmail(String twitterUser, String twitterPass) {
    	this.setUserNameTwitterEmail(twitterUser);
    	this.setUserPassTwitterEmail(twitterPass);
	}
}