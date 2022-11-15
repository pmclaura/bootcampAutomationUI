package page.yopmail;

import control.Label;
import org.openqa.selenium.By;

public class MessageSection {

    public boolean isMessageDisplayed(String from, String subject){
        Label message = new Label(By.xpath("//div[@currentmail]/button"));
        message.waitControlIsDisplayedInThePage();
        Label fromFound = new Label(By.xpath("//span[@class='lmf' and contains(text(),'"+from+"')]"));
        fromFound.isControlDisplayed();
        Label subjectFound = new Label(By.xpath("//div[@class='lms' and contains(text(),'"+subject+"')]"));
        subjectFound.isControlDisplayed();
        return fromFound.isControlDisplayed() && subjectFound.isControlDisplayed();
    }
}
