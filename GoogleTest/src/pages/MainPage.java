package pages;

import elements.Button;
import elements.Link;
import org.openqa.selenium.By;

import data.Locators;
import elements.TextLabel;

import static conf.TestManager.getDriver;
import static conf.TestManager.getUserName;
import static conf.TestManager.waitInSeconds;
import static conf.TestManager.getPass;

public class MainPage {
	
	private Button signInButton = new Button(By.id(Locators.GOOGLE_SIGN_IN.getValue()));
	private Button mailButton = new Button(By.xpath(Locators.GMAIL_LINK.getValue()));
	private TextLabel nameLabel = new TextLabel(By.cssSelector(Locators.NAME_LABEL.getValue()));
	private Link googleApps = new Link(By.xpath(Locators.GOOGLE_APPS_MENU.getValue()));
	private Button confirmationButton = new Button(By.xpath(Locators.CONFIRMATION_BUTTON.getValue()));

	
    public LoginPage clickLogIn(){
        signInButton.click();
        return new LoginPage();
    }

    public MainPage login(){
        clickLogIn().
                enterLogin( getUserName() ).
                pressNext().
                enterPassword( getPass() ).
                checkRememberMe().
                clickSignIn();
        return this;
    }
    
    //Created by Sergey M.
    public InboxPage getInboxPage(){
        waitInSeconds(1);
        if(confirmationButton.isPresent()){	confirmationButton.click(); }
        googleApps.click();
        mailButton.waitForElement();
        mailButton.click();
        return new InboxPage();
    }
    
	public boolean isPresent() {
		
		return getDriver().getTitle().contains("Google");
		
	}
	
	public boolean isLoggedIn() {
		
		return nameLabel.getText().contains("Roman");
		
	}

}
