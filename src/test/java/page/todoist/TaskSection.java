package page.todoist;

import control.Button;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class TaskSection {
    public MenuTaskSection menuTaskSection = new MenuTaskSection();
    public Button addTaskButton = new Button(By.xpath("//button[@class='plus_add_button']"));
    public TextBox nameTask =  new TextBox(By.xpath("//div[contains(@class,'public-DraftStyleDefault-block')]"));
    public TextBox descriptionTask = new TextBox(By.xpath("//textarea[contains(@class,'task_editor__description_field')]"));
    public Button saveTaskButton = new Button(By.xpath("//button[contains(@data-testid,'task-editor-submit-button')]"));
    public TextBox editTask = new TextBox(By.xpath("//div[contains(@class,'public-DraftStyleDefault-block')]/span/span"));

    public TaskSection(){}

    public void clickOnTask(String nameTask){
        Label taskCreated = new Label(By.xpath("//div[text()='"+nameTask+"']"));
        taskCreated.click();
    }

    public boolean isTaskDisplayedInList(String nameTask){
        Label taskCreated = new Label(By.xpath("//div[text()='"+nameTask+"']"));
        return taskCreated.isControlDisplayed();
    }

    public Label getTask(String nameTask){
        Label taskCreated = new Label(By.xpath("//div[text()='"+nameTask+"']"));
        return taskCreated;
    }
}
