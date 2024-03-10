package testPackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

    @Test
    public void testMethod(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/");
        driver.navigate().to("https://stackoverflow.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.quit();
    }




}

