package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItemToCartTask {

    // navigate to this url https://www.saucedemo.com/v1/inventory.html
    //add the first item you find to your cart
    //open your cart*
    //assert that the item name is correct inside the cart

    WebDriver driver ;

    @Test
    public void addFirstItemToCart(){

        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");

        By addToCartButton = By.xpath("(//button[contains(@class, 'btn_inventory')])[1]");
        driver.findElement(addToCartButton).click();


        // Open Cart Button
        By clickOpenCart = By.xpath("//a[contains(@class,'shopping_cart_link')]");
        driver.findElement(clickOpenCart).click();

        //Assert The item
        By getTheFirstItem = By.xpath("//div[@class='inventory_item_name']");
        var actualItemName = driver.findElement(getTheFirstItem).getText();
        Assertions.assertEquals("Sauce Labs Backpack", actualItemName);

    }

    @BeforeEach
    public void beforeEach(){


        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @AfterEach
    public void afterEach(){

        driver.quit();
    }
}
