package page.todoist;

import control.Button;
import control.CheckBox;
import control.Label;
import control.TextBox;
import org.openqa.selenium.By;

public class FormProject {
    public TextBox nameProjectTxtBox = new TextBox(By.id("edit_project_modal_field_name"));
    public Button colorButton = new Button(By.xpath("//button[@aria-labelledby='edit_project_modal_field_color_label']"));
    public Label selectColorLabel =  new Label(By.id("dropdown-select-8-option-green"));
    public CheckBox addFavoriteCheckBox = new CheckBox(By.xpath("//input[@name='is_favorite']"));
    public Label viewListLabel = new Label(By.id("project_list_view_style_option"));
    public Label viewPanelLabel = new Label(By.id("project_list_board_style_option"));
    public Button addProjectButoon = new Button(By.xpath("//button[text()='A\u00f1adir']"));
    public Button editProjectButton = new Button(By.xpath("//button[text()='Guardar']"));
}
