package page.yopmail;

import control.Label;
import org.openqa.selenium.By;

public class MenuSection {

    public boolean isUsernameDisplayed(String username){
        Label usernameDisplayed = new Label(By.xpath("//div[contains(text(),'"+username+"')]"));
        return usernameDisplayed.isControlDisplayed();
    }
}
