package testSuite.todoist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.todoist.*;
import session.Session;
import util.GetProperties;

public class TestBase {
    MainPage mainPage = new MainPage();
    LoginSection loginSection = new LoginSection();
    MenuSection menuSection = new MenuSection();
    ProjectSection projectSection = new ProjectSection();
    TaskSection taskSection = new TaskSection();

    String user= GetProperties.getInstance().getUser();
    String password =GetProperties.getInstance().getPwd();

    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get(GetProperties.getInstance().getHost());
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }

}
