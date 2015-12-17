package elements;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		return composeWebElement().getText();
		
	}
	
	public boolean isPresent() {
		
		try {
			
			composeWebElement().isDisplayed();
			return true;
			
		} catch (NoSuchElementException e ) {
			
			return false;
		}
		
	}
	
    public void waitForElementToBeVisible(int secToWait) {
        WebDriverWait wait = new WebDriverWait(getDriver(), secToWait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    
    public void waitForElementToBeClickable() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.ignoring(WebDriverException.class).until(ExpectedConditions.elementToBeClickable(by));
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
