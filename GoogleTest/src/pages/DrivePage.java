package pages;

import elements.Button;
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
        upload.waitForElement();
        upload.click();
        return this;
    }


}