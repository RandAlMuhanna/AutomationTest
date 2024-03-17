package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieTests {

    /**
     * Breakout task: 15 minutes
     * Navigate to <a href="https://kitchen.applitools.com/ingredients/cookie">Cookies</a>
     * print the total number of cookies
     * add a new "fruit=apple" cookie
     * edit the "protein" cookie to have the value "meat"
     * delete the "veggie" cookie
     * print all cookies
     * delete all cookies
     */

    WebDriver driver;
    @Test
    public void cookies(){



        // Print number of cookies
        System.out.println("Initial Size = " + driver.manage().getCookies().size());
        // Print all cookies
        System.out.println("Initial List = ");
        driver.manage().getCookies().forEach(System.out::println);

        // Add new cookie
        driver.manage().addCookie(new Cookie("fruit","apple"));
        driver.manage().addCookie(new Cookie("protein","meat"));

        // Edit the list
        driver.manage().deleteCookieNamed("vegetable");
        driver.manage().getCookies().forEach(System.out::println);

        driver.manage().deleteAllCookies();





    }

    @BeforeEach
    public void beforeEach(){

        driver = new ChromeDriver();
        driver.navigate().to("https://kitchen.applitools.com/ingredients/cookie");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

}
