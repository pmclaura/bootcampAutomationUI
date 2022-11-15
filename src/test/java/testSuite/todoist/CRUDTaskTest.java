package testSuite.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CRUDTaskTest extends TestBase{

    @Test
    public void verifyCRUDTask() {
        String projectCreated = "MOJIX" + new Date().getTime();
        String taskCreated = "MOJIX-Task" + new Date().getTime();
        String taskUpdated = "QA-task" + new Date().getTime();

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
        taskSection.addTaskButton.click();
        taskSection.nameTask.setText(taskCreated);
        taskSection.saveTaskButton.waitControlIsDisplayedInThePage();
        taskSection.saveTaskButton.click();
        Assertions.assertTrue(taskSection.isTaskDisplayedInList(taskCreated),"ERROR! the task was not created");

        taskSection.clickOnTask(taskCreated);
        taskSection.menuTaskSection.menuIconButton.click();
        taskSection.menuTaskSection.deleteButton.click();
        taskSection.menuTaskSection.formConfirmDeletionTask.confirmDeletionProject.click();
        taskSection.getTask(taskCreated).waitControlIsNotInThePage();
        Assertions.assertFalse(taskSection.isTaskDisplayedInList(taskCreated), "ERROR! the task was not deleted");

        projectSection.clickOnProject(projectCreated);
        taskSection.addTaskButton.click();
        taskSection.nameTask.setText(taskCreated);
        taskSection.saveTaskButton.waitControlIsDisplayedInThePage();
        taskSection.saveTaskButton.click();
        Assertions.assertTrue(taskSection.isTaskDisplayedInList(taskCreated),"ERROR! the task was not created");

        taskSection.clickOnTask(taskCreated);
        taskSection.menuTaskSection.editButton.click();
        //taskSection.nameTask.cleanSetText(taskUpdated);
        taskSection.editTask.cleanSetText("");
        taskSection.editTask.setText(taskUpdated);
        taskSection.saveTaskButton.waitControlIsDisplayedInThePage();
        taskSection.saveTaskButton.click();
        Assertions.assertTrue(taskSection.isTaskDisplayedInList(taskUpdated), "ERROR! the task was not updated");

    }
}
