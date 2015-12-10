package tests;

import conf.TestManager;
//import org.junit.Test;
import pages.InboxPage;
import org.testng.annotations.Test;
import org.testng.Assert;


//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;


/**
 * Created by User on 13.11.2015.
 */
public class Email extends TestManager {
    InboxPage inbox;

    @Test
    public void firstEmail(){
        InboxPage inbox = mainPage.login().getInboxPage();
        inbox.sendEmail( getEmail() );
        Assert.assertTrue(inbox.isBodyPresent( inbox.getEmailData().getBody() ));
    }
 
   
    @Test
    public void useAppMenu(){
        InboxPage inbox = mainPage.login().getInboxPage();
        inbox.sendEmail( getEmail() ).deleteEmail( inbox.getEmailData().getBody());
        waitInSeconds(5);
        Assert.assertFalse( inbox.isEmailPresent( inbox.getEmailData().getBody() ), "Email is not present. " );
    }
    
}