package testSuite.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CRUDProjectTest extends TestBase {

    @Test
    public void verifyCRUDProject() {
        String projectCreated = "MOJIX" + new Date().getTime();
        String projectUpdated = "QA" + new Date().getTime();

        mainPage.loginLabel.click();
        loginSection.emailTxtBox.setText(user);
        loginSection.passwordTxtBox.setText(password);
        loginSection.loginButton.click();
        Assertions.assertTrue(menuSection.settingButton.isControlDisplayed(), "ERROR! the login was faield");

        projectSection.selectProjectLabel.click();
        projectSection.addNewProjecButton.click();
        projectSection.formProject.nameProjectTxtBox.setText(projectCreated);
        projectSection.formProject.addProjectButoon.click();
        Assertions.assertTrue(projectSection.isProjectDisplayedInList(projectCreated), "ERROR! the project was not created");

        projectSection.clickOnProject(projectCreated);
        projectSection.menuProjectSection.menuIconButton.click();
        projectSection.menuProjectSection.editButton.click();
        projectSection.formProject.nameProjectTxtBox.cleanSetText(projectUpdated);
        projectSection.formProject.editProjectButton.click();
        Assertions.assertTrue(projectSection.isProjectDisplayedInList(projectUpdated), "ERROR! the project was not updated");

        projectSection.clickOnProject(projectUpdated);
        projectSection.menuProjectSection.menuIconButton.click();
        projectSection.menuProjectSection.deleteButton.click();
        projectSection.menuProjectSection.formConfirmDeletionProject.confirmDeletionProject.click();
        projectSection.getProject(projectUpdated).waitControlIsNotInThePage();
        Assertions.assertFalse(projectSection.isProjectDisplayedInList(projectUpdated), "ERROR! the project was not deleted");

    }
}
