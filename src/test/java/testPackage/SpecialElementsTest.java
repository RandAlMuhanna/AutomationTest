package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SpecialElementsTest {

    WebDriver driver ;

    @Test
    public void checkTheBoxes(){

        By checkBox = By.id("my-check-2");
        driver.findElement(checkBox).click();
        // Check is it selected or not
        boolean isChecked = driver.findElement(checkBox).isSelected();
        Assertions.assertTrue(isChecked);

    }

    @Test
    public void radioButtonsTest(){

        By radioButton = By.id("my-radio-2");
        driver.findElement(radioButton).click();
        // Check is it selected or not
        boolean isSelected = driver.findElement(radioButton).isSelected();
        Assertions.assertTrue(isSelected);

    }

    @Test
    public void selectFromDropDownTest(){

        By dropDown = By.name("my-select");
        Select select = new Select(driver.findElement(dropDown));
        select.selectByValue("2");
        String actualText = select.getAllSelectedOptions().getFirst().getText();
        Assertions.assertEquals("Two", actualText);


    }


    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");


    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
