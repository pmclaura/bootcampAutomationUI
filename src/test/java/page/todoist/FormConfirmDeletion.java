package page.todoist;

import control.Button;
import org.openqa.selenium.By;

public class FormConfirmDeletion {
    public Button confirmDeletionProject =  new Button(By.xpath("//button/span[text()='Eliminar']"));
}
