package conf;

import java.util.Random;

import javax.sql.rowset.WebRowSet;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import data.Locators;
import data.UserData;
import pages.MainPage;



public class TestManager {
	protected static WebDriver driver;
	private String baseUrl = "https://www.google.com.ua/";
	protected static UserData userData = new UserData(Locators.USER_NAME.getValue(), Locators.PASSWORD.getValue());
	private static final WebDriverEventListener eventListener = new LoggingEventListener();
	//protected static EmailData emailData = new EmailData( getEmail(), generateRandomBody() );
	protected MainPage mainPage;
	
	@Before
	public void setUp() {
		driver = new EventFiringWebDriver(new FirefoxDriver()).register(eventListener))
		//driver = new FirefoxDriver();
		getDriver().get(baseUrl);
		mainPage = new MainPage();
	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		
	}
	
	public static WebDriver getDriver () {
		
		return driver;
		
	}
	
	public static void waitInSeconds(int seconds) {
		
		try {
			
			Thread.sleep(seconds*1000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
	
	}
	
	public static String getUserName(){
		
		return userData.getLogin();
		
	}
	
	public static String getPass(){
		
		return userData.getPass();
		
	}
	
	public static String getEmail(){
		
		return userData.getEmail();
		
	}
	
	public static UserData getUserData(){
		
		return userData;
		
	}
	
	/*
	public static String getEmailBody(){
		
		return emailData.getBody();
		
	}
	
	public static String getEmailSubject(){
		
		return emailData.getSubject();
		
	}
	
	public static String getEmailReceiversInStr(){
		
		return emailData.getReceiversInString();
		
	}
	*/
	
	public static String generateRandomBody () {
		
	    StringBuilder initialBody = new StringBuilder("Body ");
	    int randomIntToBody = new Random().nextInt(50);
	    return new String(initialBody.append(randomIntToBody));

	}
	

}
