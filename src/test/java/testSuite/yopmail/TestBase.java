package testSuite.yopmail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.yopmail.MailSection;
import page.yopmail.MainPage;
import page.yopmail.MenuSection;
import page.yopmail.SendMessageSection;
import session.Session;
import util.GetProperties;

public class TestBase {
    MainPage mainPage = new MainPage();
    MenuSection menuSection = new MenuSection();
    MailSection mailSection = new MailSection();
    SendMessageSection sendMessageSection = new SendMessageSection();

    String user= GetProperties.getInstance().getUser();

    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
