package page.todoist;

import control.Button;
import org.openqa.selenium.By;

public class MenuTaskSection {
    public Button menuIconButton= new Button(By.xpath("//button[@aria-label='M\u00E1s acciones']"));
    public Button editButton= new Button(By.xpath("//div[@aria-label='Nombre de la tarea']"));
    public Button deleteButton= new Button(By.xpath("//button[contains(@aria-label,'Eliminar tarea')]"));
    public FormConfirmDeletion formConfirmDeletionTask= new FormConfirmDeletion();
}
