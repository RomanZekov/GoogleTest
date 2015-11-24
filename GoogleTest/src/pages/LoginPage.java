package pages;

import org.openqa.selenium.By;

import data.Locators;
import elements.Button;
import elements.TextInput;

//import static conf.TestManager.getDriver;

public class LoginPage {
	
	private Button nextButton = new Button(By.id( Locators.LOGIN_NEXT_BUTTON.getValue() ));
	private TextInput loginInput = new TextInput(By.id( Locators.LOGIN_INPUT.getValue() ));

	public LoginPage enterLogin (String login) {
		
		loginInput.type(login);
		return this;
	}
	
	public PasswordPage pressNext () {
		
		nextButton.click();
		return new PasswordPage();
		
	}

}
