package elements;

import org.openqa.selenium.By;

public class TextInput extends Element {
	
	public TextInput (By by) {
		
		super(by);
	}

	public void type(String login) {
		
		composeWebElement().clear();
		composeWebElement().sendKeys(login);
		
	}
	
}
