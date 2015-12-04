package tests;

import conf.TestManager;
import org.junit.Test;
import pages.InboxPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Created by User on 13.11.2015.
 */
public class Email extends TestManager {
    InboxPage inbox;

    @Test
    public void firstEmail(){
        InboxPage inbox = mainPage.login().getInboxPage();
        inbox.sendEmail( getEmail() );
        assertTrue(inbox.isBodyPresent( inbox.getEmailData().getBody() ));
    }
  
   
    @Test
    public void useAppMenu(){
        InboxPage inbox = mainPage.login().getInboxPage();
        inbox.sendEmail( getEmail() ).deleteEmail( inbox.getEmailData().getBody());
        waitInSeconds(5);
        assertFalse("Email is not present. ", inbox.isEmailPresent( inbox.getEmailData().getBody() ));
    }
    
}