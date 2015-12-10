package tests;

import conf.TestManager;
import org.testng.annotations.Test;
import pages.DrivePage;

/**
 * Created by User on 04.12.2015.
 */
public class Drive extends TestManager{

    @Test
    public void openUpload(){
        DrivePage drive = mainPage.login().getDrivePage();
        drive.openUpload();
    }
}