package pageFactory;//Page factory

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMediaAlertCreation {

    /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;
    
    @FindBy(css="input[name='name']")
    WebElement alertNameField;   
   
    @FindBy(css="table[class='table table-striped ng-isolate-scope']>tbody>tr>td>input:nth-of-type(1)")
    WebElement networkFacebookCheckbox;
    @FindBy(css="table[class='table table-striped ng-isolate-scope']>tbody>tr>td>input:nth-of-type(2)")
    WebElement networkWorkplaceCheckbox;
    @FindBy(css="table[class='table table-striped ng-isolate-scope']>tbody>tr>td>input:nth-of-type(3)")
    WebElement networkTwitterCheckbox;
    @FindBy(css="table[class='table table-striped ng-isolate-scope']>tbody>tr>td>input:nth-of-type(4)")
    WebElement networkInstagramCheckbox;
    @FindBy(css="table[class='table table-striped ng-isolate-scope']>tbody>tr>td>input:nth-of-type(5)")
    WebElement networkLinkedinCheckbox;
    @FindBy(css="table[class='table table-striped ng-isolate-scope']>tbody>tr>td>input:nth-of-type(6)")
    WebElement networkYoutubeCheckbox;
    
    @FindBy(css="ul[class='tag-editor']:nth-of-type(1)")
    WebElement alertKeywordField; 
    
    //CANNOT GET THIS FIELD YET!!
    @FindBy(css="")
    WebElement alertKeywordTextField;
    
    //@FindBy(css="div[class='form-group afade ng-scope']>textarea[aria-label='emails']")
    @FindBy(css="div.form-group:nth-child(4) > ul:nth-child(2) > li:nth-child(2)")
    WebElement alertEmailField; 
    
    @FindBy(css="button.ng-binding:nth-child(2)")
    WebElement alertSaveButton; 
    
    @FindBy(css="select.form-control")
    WebElement keywordPicklist;
    
    @FindBy(css="option[value='{phone}']")
    WebElement keywordPicklistPhone;
    
    @FindBy(css="option[value='{creditcard}']")
    WebElement keywordPicklistCreditCard;
    
    @FindBy(css="option[value='{socialsecurity}']")
    WebElement keywordPicklistSocialSecurity;
    
    @FindBy(css="option[value='{badwords}']")
    WebElement keywordPicklistBadWords;
    
    public SocialMediaAlertCreation(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    //Set alert name in textbox
    public void setAlertName(String alertName){
    	alertNameField.sendKeys(alertName);      
    } 

    //Select a social network
    public void selectSocialNetwork (String network) {
    	//1 - Facebook, 2 - Workplace, 3 - Twitter, 4 - Instagram, 5 - Linkedin, 6 - Youtube
    	switch (network.toLowerCase()) {
    		case "facebook": networkFacebookCheckbox.click();
    			break;
    		case "workplace": networkWorkplaceCheckbox.click();
				break;
    		case "twitter": networkTwitterCheckbox.click();
				break;
    		case "instagram": networkInstagramCheckbox.click();
				break;
    		case "linkedin": networkLinkedinCheckbox.click();
				break;
    		case "youtube": networkYoutubeCheckbox.click();
				break;
    	}
    }

    
    /**
     * Method to create a Social Network alert with parameters
     * @param alertName
     * @param network
     * @param email
     * SHOULD ADD PARAMETERS FOR KEYWORDS
     */
	public void createANetworkAlert(String alertName,String network, String email) {
		this.pause();
		// write the alert name
		this.setAlertName(alertName);
		// select a social network
		this.selectSocialNetwork(network);
		//add all in keywords
		this.keywordsSelectPhone();
		this.keywordsSelectCreditCard();
		this.keywordsSelectSocialSecurty();
		this.keywordsSelectBadWord();
		//add an email
		this.writeEmail(email);
		//click on save
		this.clickOnSave();
	}
	
	private void clickOnSave() {
		alertSaveButton.click();		
	}

	private void writeEmail(String email) {
		alertEmailField.click();
		alertEmailField.sendKeys(email);
	}

	private void keywordsSelectPhone() {
		keywordPicklist.click();
		keywordPicklistPhone.click();
	}

	private void keywordsSelectCreditCard() {
		keywordPicklist.click();
		keywordPicklistCreditCard.click();
	}
	
	private void keywordsSelectSocialSecurty() {
		keywordPicklist.click();
		keywordPicklistSocialSecurity.click();
	}
	
	private void keywordsSelectBadWord() {
		keywordPicklist.click();
		keywordPicklistBadWords.click();
	}
	
	public void createAnAccountAlert(String alertName) {
		this.setAlertName(alertName);
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