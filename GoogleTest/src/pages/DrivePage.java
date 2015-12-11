package pages;

import elements.Button;

import java.io.File;
import java.io.IOException;
import static conf.TestManager.waitInSeconds;

import org.openqa.selenium.By;

/**
 * Created by User on 04.12.2015.
 */
public class DrivePage {
    private Button myDrive = new Button(By.xpath("//div[text()='Мой диск']"));
    private Button upload = new Button(By.xpath("//div[contains(text(), 'Загрузить файлы')]/../../.."));

    public DrivePage openUpload(){
        myDrive.waitForElement();
        myDrive.click();
        waitInSeconds(5);
        upload.waitForElement();
        
        upload.click();
        waitInSeconds(5);
        loadOneFileWithAutoIT();
        waitInSeconds(10);
        return this;
    }

    public void loadOneFileWithAutoIT() {
    	
    	File file = new File("");
    	String path = file.getAbsolutePath();
    	String filesFolder = path + "\\src\\main\\resources\\autoitscript\\";
    	String fileName = filesFolder + "upload_file_using_open_window.exe";
    	final String[] stringArgs = {fileName};
    	//"E:/Java/GitRepository/GoogleTest/GoogleTest/src/main/resources/autoitscript/upload_file_using_open_window.exe"
    	try {
    		Runtime.getRuntime().exec(stringArgs);
    	} catch (IOException e) {
    		//"Something went wrong"
    		e.printStackTrace();
    	}
    	
    }

}