package tests;

import conf.TestManager;

import org.testng.annotations.Test;
import org.testng.Assert;
//import static org.junit.Assert.*;

//import org.junit.*;


public class Login  extends TestManager{


  @Test
  public void LoginTest() {

	  mainPage.clickLogIn().
	  		   enterLogin( getUserName() ).
	  		   pressNext().
	  		   enterPassword( getPass() ).
	  		   checkRememberMe().
	  		   clickSignIn();
	  Assert.assertTrue( mainPage.isLoggedIn(), "Incorrect page is displayed." );
  }
  
  
  

}
