package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.security.Key;

public class TaskFourKeyboardActions extends Tests{

    // go to https://www.google.com/
// search for "Scroll Methods" by using an Actions object

    @Test
    public void searchActions() throws InterruptedException {

        driver.navigate().to("https://www.google.com/");
        Actions actions = new Actions(driver);

        WebElement findSearchBar = driver.findElement(By.id("APjFqb"));
        actions.keyDown(Keys.SHIFT).sendKeys(findSearchBar , "S")
                .keyUp(Keys.SHIFT).sendKeys(findSearchBar , "croll").perform();


        actions.keyDown(Keys.SPACE).sendKeys(findSearchBar , "M").perform();
                        actions.sendKeys(findSearchBar , "ethods" + Keys.RETURN)
                        .perform();



        Thread.sleep(5000);


    }

}
