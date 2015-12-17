package pages;

import elements.Button;

import java.io.File;
import java.io.IOException;
import static conf.TestManager.waitInSeconds;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;

/**
 * Created by User on 04.12.2015.
 */
public class DrivePage {
	
	private Log log = LogFactory.getLog(this.getClass());
	
    private Button myDrive = new Button(By.xpath("//div[text()='Мой диск']"));
    private Button upload = new Button(By.xpath("//div[contains(text(), 'Загрузить файлы')]/.."));

    public DrivePage openUpload(){
    	waitInSeconds(5);
    	myDrive.waitForElementToBeVisible(10);
        myDrive.click();
        //upload.waitForElement();
        upload.waitForElementToBeVisible(10);
        upload.click();
        loadOneFileWithAutoIT();
        waitInSeconds(10);
        return this;
    }

    public void loadOneFileWithAutoIT() {
    	
    	File file = new File("");
    	String path = file.getAbsolutePath();
    	String filesFolder = path + "\\src\\main\\resources\\autoitscript\\";
    	String fileName = filesFolder + "upload_file_using_open_window.exe";
    	log.info("Prepare to run the script " + fileName);
    	final String[] stringArgs = {fileName};

    	try {
    		Runtime.getRuntime().exec(stringArgs);
    	} catch (IOException e) {
    		//"Something went wrong"
    		e.printStackTrace();
    	}
    	
    }

}