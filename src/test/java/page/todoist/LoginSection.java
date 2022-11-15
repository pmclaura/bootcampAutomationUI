package page.todoist;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class LoginSection {
    public TextBox emailTxtBox = new TextBox(By.id("element-0"));
    public TextBox passwordTxtBox = new TextBox(By.id("element-3"));
    public Button loginButton= new Button(By.xpath("//button[@aria-disabled='false']"));


    public void login(String user, String pwd){
        emailTxtBox.setText(user);
        passwordTxtBox.setText(pwd);
        loginButton.click();
    }
}
