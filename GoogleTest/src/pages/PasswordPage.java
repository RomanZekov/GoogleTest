package pages;

//import static conf.TestManager.getDriver;

import org.openqa.selenium.By;
import data.Locators;
import elements.Button;
import elements.Checkbox;
import elements.TextInput;

public class PasswordPage {
	
	private TextInput passwordInput = new TextInput(By.id( Locators.PASSWD_INPUT.getValue() ));
	private Button signInButton = new Button(By.id( Locators.SIGN_IN_BUTTON.getValue() ));
	private Checkbox rememberMeCheckbox = new Checkbox(By.id( Locators.PERSISTENT_COOKIE.getValue() ));
	
	
	public PasswordPage enterPassword (String password) {
		
		passwordInput.waitForElement();
		passwordInput.type(password);
		return this;
	
	}

	public PasswordPage checkRememberMe() {
	
		rememberMeCheckbox.check();
		return this;
	
	}

	public MainPage clickSignIn() {
	
		signInButton.click();
		return new MainPage();
	
	}

}
