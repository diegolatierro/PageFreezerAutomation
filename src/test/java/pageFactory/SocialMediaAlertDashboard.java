package pageFactory;//Page factory

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMediaAlertDashboard {

    /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;
    
    @FindBy(css="a[href='/alerts/result?alertId=all']")//(css="#bs-example-navbar-collapse-1 > ul:nth-child(1) > li:nth-child(4) > a")//
    WebElement alertHeaderButton;   
    @FindBy(css="button[href='/alerts/new/settings']")
    WebElement createNewAlertButton;


    public SocialMediaAlertDashboard(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Click on alert header button
    public void clickAlertHeaderButton(){
    	pause();
    	alertHeaderButton.click();
    }

    //Click on alert header button
    public void clickNewAlertButton(){
    	pause();
    	createNewAlertButton.click();
    }

	public void goToAlertCreation() {
		this.clickAlertHeaderButton();
		this.clickNewAlertButton();
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