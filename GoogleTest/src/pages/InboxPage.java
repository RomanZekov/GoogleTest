package pages;

import elements.Button;
import elements.Checkbox;
import elements.TextInput;
import elements.TextLabel;

import org.openqa.selenium.By;

import data.EmailData;
import data.Locators;

import static conf.TestManager.getDriver;
import static conf.TestManager.waitInSeconds;
import static conf.TestManager.generateRandomBody;
import static conf.TestManager.getEmail;


/**
 * Created by User on 13.11.2015.
 */
public class InboxPage {
	
	private EmailData emailData;

	private Button composeButton = new Button(By.className( Locators.COMPOSE_NEW_MAIL.getValue()) );
    private Button sendButton = new Button(By.xpath( Locators.SEND_EMAIL.getValue()) );
    private Button body = new Button(By.xpath( Locators.BODY.getValue() ));
    private Button delEmailButton = new Button(By.xpath( Locators.DELETE_EMAIL_BUTTON.getValue() ));

    private TextInput receiverInput = new TextInput(By.xpath( Locators.RECEIVER_INPUT.getValue() ));
    private TextInput subjectInput = new TextInput(By.className( Locators.SUBJECT_INPUT.getValue() ));
    private TextInput bodyInput = new TextInput(By.xpath( Locators.BODY_INPUT.getValue() ));
    private Checkbox checkToDelete;
    
    private TextLabel emptyLabel = new TextLabel(By.xpath("//div[text()='Вкладка \"Основні\" порожня.']"));
    
    

    public InboxPage sendEmail(String address) {
        composeButton.waitForElement();
        composeButton.click();
        
        emailData = new EmailData( getEmail(), generateRandomBody() );
        sendButton.waitForElement();
        receiverInput.type( emailData.getReceiversInString() );
        subjectInput.type( emailData.getSubject() );
        bodyInput.type( emailData.getBody());
        sendButton.click();
        waitInSeconds(3);
        getDriver().navigate().refresh();
        waitInSeconds(2);

        return this;
    }
    
    public InboxPage deleteEmail(String body) {

    	findCheckBoxByEmailBodyAndCheck( emailData.getBody() );
    	waitInSeconds(4);
    	delEmailButton.waitForElement();
   		delEmailButton.click();
    		
    	waitInSeconds(2);

        return this;
    } 
    
    public boolean isEmailPresent(String body) {
        String locator;
        
        locator = "//span[contains(text(),'" + body + "')]";
    	
        Button email = new Button(By.xpath( locator ));
        return email.isPresent();
    }
    
    public boolean isBodyPresent(String s) {
        body.waitForElement();
        return body.isPresent();
    }
    
	public boolean isInboxOpened() {
		
		return getDriver().getTitle().contains("Входящие");
		
	}
	
	public void findCheckBoxByEmailBodyAndCheck(String body){
		String locator;
		
		locator = "//span[contains(text(),'" + body + "')]/../../../../..//div[@role='checkbox']";
		checkToDelete = new Checkbox(By.xpath(locator));
		checkToDelete.waitForElement();
		checkToDelete.check();
		
	}
	
	public EmailData getEmailData() {
		
		return emailData;
	}
	
}