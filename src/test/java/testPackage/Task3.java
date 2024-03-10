package testPackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Task3 {

    @Test
     public void TC3(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        String title = driver.getTitle();

        // Verify the Title
        System.out.println(" Title is " + title);
        Assertions.assertEquals(title, "Google");

        driver.quit();

    }


}

