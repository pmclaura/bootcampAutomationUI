package page.yopmail;

import control.Button;
import org.openqa.selenium.By;

public class MailSection {
    public Button newMailButton = new Button(By.id("newmail"));
    public Button refreshPage = new Button(By.id("refresh"));
    public MessageSection messageSection = new MessageSection();
}
