package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * initialize the browser in maximized mode (using options)
 * navigate to <a href="https://www.selenium.dev/selenium/web/web-form.html">web form test page</a>
 * check the box and validate that it is checked
 * select the radio and validate that it is selected
 * choose an item (by value) from the select dropdown menu and validate that it is selected (by text)
 */

public class SpecialElementsTestTaskOne {

    WebDriver driver ;


    @Test
    public void checkBox(){
        By findCheckBox = By.id("my-check");
        driver.findElement(findCheckBox).click();
        boolean isSelected = driver.findElement(findCheckBox).isSelected();
        Assertions.assertTrue(isSelected);

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
