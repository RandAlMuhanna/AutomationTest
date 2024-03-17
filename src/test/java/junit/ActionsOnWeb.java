package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsOnWeb {

    /*
    navigate to https://www.selenium.dev/selenium/web/droppableItems.html
    drag the draggable, onto the droppable
    check that the text now shows "Dropped!"
     */

    WebDriver driver ;
    @Test
    public void draggable(){

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        new Actions(driver)
                .dragAndDrop(draggable , droppable)
                .perform();

        var dropMessage =  driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();

        Assertions.assertEquals("Dropped!" , dropMessage);


    }

    @BeforeEach
    public void beforeEach(){

        driver = new ChromeDriver();
        driver.navigate().to("https://www.selenium.dev/selenium/web/droppableItems.html");
        driver.manage().window().maximize();


    }


    @AfterEach
    public void afterEach(){

        driver.quit();


    }


}
