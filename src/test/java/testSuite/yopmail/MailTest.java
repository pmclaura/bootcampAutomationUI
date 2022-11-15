package testSuite.yopmail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.util.Date;

public class MailTest extends TestBase {

    @Test
    public void verifyMailSent() {
        String subject = "MOJIX" + new Date().getTime();
        String body = "Hello...!!!!";

        mainPage.emailTxtBox.setText(user);
        mainPage.emailTxtBox.enter();
        Assertions.assertTrue(menuSection.isUsernameDisplayed(user), "ERROR! username is not shown");

        mailSection.newMailButton.click();
        Session.getInstance().switchToIFrame("ifmail");
        sendMessageSection.msgTo.waitControlIsDisplayedInThePage();
        sendMessageSection.msgTo.setText(user);
        sendMessageSection.msgSubject.setText(subject);
        sendMessageSection.msgBody.setText(body);
        sendMessageSection.mstSendButton.click();
        Session.getInstance().switchToDefaultContent();
        mailSection.refreshPage.waitControlIsDisplayedInThePage();
        mailSection.refreshPage.click();
        Session.getInstance().switchToIFrame("ifinbox");
        Assertions.assertTrue(mailSection.messageSection.isMessageDisplayed(user,subject), "ERROR! message is not shown");


    }
}
