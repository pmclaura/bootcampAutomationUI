package page.yopmail;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class SendMessageSection {

    public TextBox msgTo = new TextBox(By.id("msgto"));
    public TextBox msgSubject = new TextBox(By.id("msgsubject"));
    public TextBox msgBody = new TextBox(By.id("msgbody"));
    public Button mstSendButton = new Button(By.id("msgsend"));

}
