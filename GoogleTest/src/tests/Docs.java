package tests;

import conf.TestManager;
import org.junit.Test;
import pages.DocsPage;

/**
 * Created by User on 04.12.2015.
 */
public class Docs extends TestManager {

    @Test
    public void goToDocs(){
        DocsPage inbox = mainPage.login().getDocsPage();

    }
}