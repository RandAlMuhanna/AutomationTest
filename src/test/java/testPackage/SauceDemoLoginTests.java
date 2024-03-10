package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoLoginTests {

    /**

     *  * breakout task:
     *  * <br/> - navigate to this url <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
     *  * <br/> - do a successful login
     *  * <br/> - assert that the login is successful

     *  * breakout task:

     *  * <br/> - navigate to this url <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
     *  * <br/> - do a locked_out_user login
     *  * <br/> - assert that the login was not successful (do a negative test, and a positive test)
     *  */

    WebDriver driver ;
    String pageUrl = "https://www.saucedemo.com/v1/index.html" ;
    String landingPageUrl = "https://www.saucedemo.com/v1/inventory.html" ;
    String standardUser = "standard_user" ;
    String unifiedPassword = "secret_sauce" ;
    String lockedOutUser = "locked_out_user" ;


    @Test
    public void successfulLogin(){

        // Login
        login(standardUser , unifiedPassword);

        // Check and make assertion between the urls
        var currentPageUrl = driver.getCurrentUrl();
        Assertions.assertEquals(landingPageUrl , currentPageUrl);
    }

    @Test
    public void lockedOutErrorMessage(){

        login(lockedOutUser , unifiedPassword);
        By errorMessage =  By.xpath("//h3[@data-test='error']");
        var errorMessageText = driver.findElement(errorMessage).getText();
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out." , errorMessageText);

    }

    @Test
    public void lockedOutNotRedirectedToLandingPage(){
        login(lockedOutUser , unifiedPassword);
        var getCurrentUrl = driver.getCurrentUrl();
        Assertions.assertNotEquals(landingPageUrl , getCurrentUrl);

    }
    private void login(String userName , String password){

        By userNameTextArea = By.id("user-name");
        By passwordTextArea = By.id("password");
        By loginButton = By.id("login-button");

        driver.findElement(userNameTextArea).sendKeys(userName);
        driver.findElement(passwordTextArea).sendKeys(password);
        driver.findElement(loginButton).click();

    }
    @BeforeEach
    public void beforeEach(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(pageUrl);
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
