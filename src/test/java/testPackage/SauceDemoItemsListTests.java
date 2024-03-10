package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoItemsListTests {

    /**
     * Navigate to <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
     * login as standard_user
     * assert that there are 6 items on the products list page
     * add the first and last items to the cart
     * navigate to the cart and check that both items are listed
     */
    WebDriver driver ;
    String loginPageUrl = "https://www.saucedemo.com/v1/index.html" ;
    String landingPageUrl = "https://www.saucedemo.com/v1/inventory.html" ;
    String standardUser = "standard_user" ;
    String unifiedPassword = "secret_sauce" ;

    // Check the number of products
    @Test
    public void checkThatProductListHas6Items(){
        login(standardUser , unifiedPassword);
        By productItemComponent = By.className("inventory_item");
        int actualNumberOfProducts = driver.findElements(productItemComponent).size();
        Assertions.assertEquals(6 , actualNumberOfProducts);

    }

    @Test
    public void checkThatTheFirstItemIsDisplayedCorrectly(){

        login(standardUser , unifiedPassword);
        addItemToCart(1);
        addItemToCart(6);
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
        Assertions.assertEquals("Sauce Labs Backpack" , getCartItemName(1));
    }

    @Test
    public void checkThatTheLastItemIsDisplayedCorrectly(){

        login(standardUser , unifiedPassword);
        addItemToCart(1);
        addItemToCart(6);
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
        Assertions.assertEquals("Test.allTheThings() T-Shirt (Red)" , getCartItemName(2));
    }
    private void login(String username, String password){
        By userNameTextField = By.id("user-name");
        By passwordTextField = By.id("password");
        By loginButton = By.id("login-button");

        driver.findElement(userNameTextField).sendKeys(username);
        driver.findElement(passwordTextField).sendKeys(password);
        driver.findElement(loginButton).click();

    }

    private void addItemToCart(int itemNumber){
        By AddItemToCartButton = By.xpath("(//button[contains(@class,'btn_inventory')])["+itemNumber+"]");
        driver.findElement(AddItemToCartButton).click();
    }

    private String getCartItemName(int cartItemNumber){
        By cartItemName = By.xpath("(//div[@class='inventory_item_name'])["+cartItemNumber+"]");
        return driver.findElement(cartItemName).getText();
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.navigate().to(loginPageUrl);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach(){
        driver.quit();


    }
}
