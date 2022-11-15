package page.todoist;

import control.Button;
import control.Label;
import org.openqa.selenium.By;

public class ProjectSection {
    public MenuProjectSection menuProjectSection= new MenuProjectSection();
    public Label selectProjectLabel = new Label(By.xpath("//a[@href='/app/projects']"));
    public Button addNewProjecButton = new Button(By.xpath("//button[@aria-label='A\u00f1adir proyecto']"));
    public FormProject formProject = new FormProject();

    public ProjectSection(){}

    public void clickOnProject(String nameProject){
        Label projectCreated = new Label(By.xpath("//a[contains(@aria-label,'"+nameProject+"')]"));
        projectCreated.click();
    }

    public boolean isProjectDisplayedInList(String nameProject){
        Label projectCreated = new Label(By.xpath("//a[contains(@aria-label,'"+nameProject+"')]"));
        return projectCreated.isControlDisplayed();
    }

    public Label getProject(String nameProject){
        Label projectCreated = new Label(By.xpath("//a[contains(@aria-label,'"+nameProject+"')]"));
        return projectCreated;
    }

}
