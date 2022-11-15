package page.todoist;

import control.Button;
import org.openqa.selenium.By;

public class MenuProjectSection {
    public Button menuIconButton= new Button(By.xpath("//button[@aria-label='M\u00E1s acciones de proyecto']"));
    public Button editButton= new Button(By.xpath("//div[text()='Editar proyecto']"));
    public Button deleteButton= new Button(By.xpath("//div[text()='Eliminar proyecto']"));
    public FormConfirmDeletion formConfirmDeletionProject= new FormConfirmDeletion();

}
