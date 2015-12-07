package pages;

import elements.Button;
import org.openqa.selenium.By;

/**
 * Created by User on 04.12.2015.
 */
public class DrivePage {
    private Button myDrive = new Button(By.xpath("//div[text()='��� ����']"));
    private Button upload = new Button(By.xpath("//div[contains(text(), '��������� �����')]/../../.."));

    public DrivePage openUpload(){
        myDrive.waitForElement();
        myDrive.click();
        upload.waitForElement();
        upload.click();
        return this;
    }


}