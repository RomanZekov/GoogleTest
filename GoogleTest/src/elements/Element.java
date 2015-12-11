package elements;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import static conf.TestManager.getDriver;
import static conf.TestManager.waitInSeconds;


public abstract class Element {
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	protected By by;
	
	public Element (By by) {
		
		this.by = by;
		
	}
	
	protected WebElement composeWebElement() {
		
		return getDriver().findElement(by);
		
	}
	

	public String getText() {
		
		return getDriver().findElement(by).getText();
		
	}
	
	public boolean isPresent() {
		
		try {
			
			composeWebElement();
			return true;
			
		} catch (NoSuchElementException e ) {
			
			return false;
		}
		
	}
	
	public void waitForElement() {
		
		for (int i =0; i < 10; i++) {
			
			if (isPresent()) {
				
				break;
				
			} else {
				
				waitInSeconds(2);
				
			}
		}
	}
	
}
