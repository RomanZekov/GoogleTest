package conf;

import data.Locators;
import data.UserData;
import pages.MainPage;
import java.util.Random;
import org.openqa.selenium.WebDriver;

import conf.report.CaptureScreenShotOnFailureListener;
import conf.report.LoggingEventListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;


@Listeners(CaptureScreenShotOnFailureListener.class)
public class TestManager {
	protected static WebDriver driver;
	private String baseUrl = "https://www.google.com.ua/";
	protected static UserData userData = new UserData(Locators.USER_NAME.getValue(), Locators.PASSWORD.getValue());
	private static final WebDriverEventListener eventListener = new LoggingEventListener();
	protected MainPage mainPage;
	
	@BeforeMethod
	public void setUp() {
		driver = new EventFiringWebDriver(new FirefoxDriver()).register(eventListener);
		//driver = new EventFiringWebDriver (new HtmlUnitDriver(BrowserVersion.FIREFOX_38)).register(eventListener);
		getDriver().get(baseUrl);
		mainPage = new MainPage();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
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
	
	public static String generateRandomBody () {
		
	    StringBuilder initialBody = new StringBuilder("Body ");
	    int randomIntToBody = new Random().nextInt(50);
	    return new String(initialBody.append(randomIntToBody));

	}
	

}