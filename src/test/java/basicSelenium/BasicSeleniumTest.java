package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;

public class BasicSeleniumTest {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://todo.ly/");
    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }

    @Test
    public void verifyCRUDProject() throws InterruptedException {

        // login
        driver.findElement(By.xpath("//img[contains(@src,'pagelogin')]")).click();
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("proof@gmail.com");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("123");
        driver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(1000);
        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed()
                                    ,"ERROR login was incorrect");

        // create
        String nameProject="Mojix"+new Date().getTime();
        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        driver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(1000);
        int actualResult=driver.findElements(By.xpath(" //td[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not created");

        nameProject="Update"+new Date().getTime();
        // update
        driver.findElement(By.xpath("//div[contains(@style,'block')]/img")).click();
        driver.findElement(By.xpath("//ul[@id=\"projectContextMenu\"]//a[text()='Edit']")).click();
        driver.findElement(By.xpath("//td/div/input[@id='ItemEditTextbox']")).clear();
        driver.findElement(By.xpath("//td/div/input[@id='ItemEditTextbox']")).sendKeys(nameProject);
        driver.findElement(By.xpath("//td/div/img[@id='ItemEditSubmit']")).click();
        Thread.sleep(1000);
        actualResult=driver.findElements(By.xpath(" //td[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not updated");

        // delete
        driver.findElement(By.xpath("//div[contains(@style,'block')]/img")).click();
        driver.findElement(By.id("ProjShareMenuDel")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        actualResult=driver.findElements(By.xpath(" //td[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult == 0
                ,"ERROR The project was not removed");

        // create Project
        nameProject="BootcampQA"+new Date().getTime();
        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        driver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(1000);
        actualResult=driver.findElements(By.xpath(" //td[text()='"+nameProject+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1
                ,"ERROR The project was not created");

        //create task
        String nameTask = "TaskQA"+new Date().getTime();
        driver.findElement(By.id("NewItemContentInput")).sendKeys(nameTask);
        driver.findElement(By.id("NewItemAddButton")).click();
        Thread.sleep(1000);
        actualResult=driver.findElements(By.xpath(" //div[text()='"+nameTask+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1 ,
                "ERROR The task was not created");

        //update task
        driver.findElement(By.xpath("//ul[@id='mainItemList']/li/div/table/tbody/tr/td/div[text()='"+nameTask+"']")).click();
        String updateNameTask = "UpdateTaskQA" + new Date().getTime();
        driver.findElement(By.xpath("//ul[@id='mainItemList']/li/div/table/tbody/tr/td/div/div/textarea")).clear();
        driver.findElement(By.xpath("//ul[@id='mainItemList']/li/div/table/tbody/tr/td/div/div/textarea")).sendKeys(updateNameTask);
        driver.findElement(By.xpath("//ul[@id='mainItemList']/li/div/table/tbody/tr/td/div/div/textarea")).click();
        Thread.sleep(1000);
        actualResult=driver.findElements(By.xpath(" //div[text()='"+updateNameTask+"'] ")).size();
        Assertions.assertTrue(actualResult >= 1 ,
                "ERROR The task was not updated");

        //delete task
        driver.findElement(By.xpath("//ul[@id='mainItemList']/li/div/table/tbody/tr/td/div[text()='"+updateNameTask+"']")).click();
        driver.findElement(By.xpath("//ul[@id='mainItemList']/li/div/table/tbody/tr/td/div/img")).click();
        driver.findElement(By.xpath("//ul[@id='itemContextMenu']/li/a[text()='Delete']")).click();
        Thread.sleep(1000);
        actualResult=driver.findElements(By.xpath(" //td/div[text()='"+updateNameTask+"'] ")).size();
        Assertions.assertTrue(actualResult == 0 ,
                "ERROR The task was not removed");
    }
}
