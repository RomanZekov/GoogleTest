package tests;

import conf.TestManager;

import static org.junit.Assert.*;

import org.junit.*;


public class Login  extends TestManager{


  @Test
  public void LoginTest() {

	  mainPage.clickLogIn().
	  		   enterLogin( getUserName() ).
	  		   pressNext().
	  		   enterPassword( getPass() ).
	  		   checkRememberMe().
	  		   clickSignIn();
	  //assertTrue("Incorrect page is displayed.", mainPage.isPresent());
	  assertTrue("Incorrect page is displayed.", mainPage.isLoggedIn());
  }
  
  
  

}
