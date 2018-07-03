package pageFactory;//Page factory

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMediaCreateArchiveFrom {

    /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;
    
    @FindBy(css="input[vurl='']")
    WebElement createArchiveURLField;
    
    @FindBy(css="div.archive-form-control:nth-child(2) > div:nth-child(3) > label:nth-child(1) > input")
    WebElement createArchiveGetMessagesCheckbox;
    
    @FindBy(css="input[placeholder='Admin Email']")
    WebElement createArchiveEmailField;
    
    @FindBy(css="button.btn:nth-child(4)")
    WebElement createArchiveNextButton;
    
    @FindBy(css="select[aria-label='select group']")
    WebElement createArchiveGroupPicklist;
    
    @FindBy(css="select.ng-touched > option:nth-child(2)")
    WebElement createArchiveGroupPicklistTestGroup;
    
    @FindBy(css="select[ng-model='access_item.role']")
    WebElement createArchiveRolePicklist;
    
    @FindBy(css="option[value='Manager']")
    WebElement createArchiveRolePicklistManager;
    
    @FindBy(css="button[class='btn btn-success']")
    WebElement createArchiveCreateButton;
    
    
    public SocialMediaCreateArchiveFrom(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
    //Write a URL
    public void writeURL(String URL){
    	pause();
    	createArchiveURLField.sendKeys(URL);
    }    
    
    //check get messages
    public void checkGetMessages(){
    	pause();
    	createArchiveGetMessagesCheckbox.click();
    }
	
    //Write an email
    public void writeEmail(String email){
    	pause();
    	createArchiveEmailField.sendKeys(email);
    }  
    
    //Click on next
    public void clickOnNext() {
    	createArchiveNextButton.click();
    }    
    
    //Select __TestGroup on Group
    public void selectGroup() {
    	createArchiveGroupPicklist.click();
    	createArchiveGroupPicklistTestGroup.click();
    }
    
    //Select Manager on Role
    public void selectRole() {
    	createArchiveRolePicklist.click();
    	createArchiveRolePicklistManager.click();
    }
    
    //click on Create
    public void clickOnCreate() {
    	createArchiveCreateButton.click();
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