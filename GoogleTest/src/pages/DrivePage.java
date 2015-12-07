package pages;

import elements.Button;
import org.openqa.selenium.By;

/**
 * Created by User on 04.12.2015.
 */
public class DrivePage {
    private Button myDrive = new Button(By.xpath("//div[text()='Мій диск']"));
    private Button upload = new Button(By.xpath("//div[contains(text(), 'Завантажити файли')]/../../.."));

    public DrivePage openUpload(){
        myDrive.waitForElement();
        myDrive.click();
        upload.waitForElement();
        upload.click();
        return this;
    }


}