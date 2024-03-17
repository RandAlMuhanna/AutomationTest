package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * Use Google Chrome
 * Navigate to <a href="https://www.google.com/">Google.com</a>
 * Search for "Selenium"
 * Check that results stats is not empty
 * Change to using Firefox
 */

public class SynchronizationTest extends Tests {

    WebDriver driver;
    Wait <WebDriver> wait;
    @Test
    public void googleSearchTests(){

        driver.navigate().to("https://www.google.com/");
        By searchBarTextArea = By.id("APjFqb");
        driver.findElement(searchBarTextArea).sendKeys("Selenium" , Keys.RETURN);

        wait = new WebDriverWait(driver , Duration.ofSeconds(5));

        // Now im in the target page
        By resultStats = By.id("result-stats");

      //  wait.until(d -> driver.findElement(resultStats).isDisplayed());
        // Best practice
        wait.until(d -> !driver.findElement(resultStats).getText().isEmpty());
        String actualText = driver.findElement(resultStats).getText();
        Assertions.assertNotEquals("" , actualText);

    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

    }


    @AfterEach
    public void afterEach(){
        driver.quit();
    }

}
