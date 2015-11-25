package pages;

//import static conf.TestManager.getDriver;

import org.openqa.selenium.By;

import elements.Button;
import elements.Checkbox;
import elements.TextInput;
import static conf.TestManager.waitInSeconds;

public class PasswordPage {
	
	private TextInput passwordInput = new TextInput(By.id("Passwd"));
	private Button signInButton = new Button(By.id("signIn"));
	private Checkbox rememberMeCheckbox = new Checkbox(By.id("PersistentCookie"));
	
	
	public PasswordPage enterPassword (String password) {
		
		for (int i = 0; i < 10; i++) {
			
			if (passwordInput.isPresent()) {
				
				break;
				
			} else {
				
				waitInSeconds(2);
				
			}
			
		}

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
