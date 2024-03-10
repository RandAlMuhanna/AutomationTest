package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class radioButtonTask {

     /*Task 1:
   Go to URL: https://demoqa.com/radio-button
   Verify whether all 3 options given to the question can be selected.
   When each option is selected, print the following texts on the console.*/

    WebDriver driver;

    @Test
    public void radioButton(){

        // First Radio
        WebElement firstRadio = driver.findElement(By.id("yesRadio"));
        boolean isFirstSelected = firstRadio.isEnabled();
        Assertions.assertTrue(isFirstSelected);


        // Second Radio
        WebElement secondRadio = driver.findElement(By.id("impressiveRadio"));
        boolean isSecondSelected = firstRadio.isEnabled();
        Assertions.assertTrue(isSecondSelected);

        // Third Radio
        WebElement thirdElement = driver.findElement(By.id("noRadio"));
        boolean isThirdSelected = firstRadio.isEnabled();
        Assertions.assertTrue(isThirdSelected);


    }


    @BeforeEach
    public void beforeEach(){

        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
