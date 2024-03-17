package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TaskOneJScript extends Tests {

    //Go to URL: https://api.jquery.com/dblclick/
//Double click on the blue square at the bottom of the page and then write the changed color.
//Go top of the page and sendKeys "Thanks to JavascriptExecutor"
//Go to the bottom of the page and click the book, name"jQuery in Action"

    @Test
    public void doubleClick(){

        Actions actions = new Actions(driver);
        driver.navigate().to("https://api.jquery.com/dblclick/");
        WebElement findTheBoxFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(findTheBoxFrame);

        //Double click on the blue square at the bottom of the page and then write the changed color.
        WebElement findTheBlueBox = driver.findElement(By.cssSelector("body>div"));
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        js.executeScript("arguments[0].scrollIntoView();" , findTheBlueBox);
        actions.doubleClick(findTheBlueBox).perform();

        String colorAfterClick = findTheBlueBox.getCssValue("background-color");
        System.out.println("The color is: " + colorAfterClick);

        driver.switchTo().defaultContent();

        //Go top of the page and sendKeys "Thanks to JavascriptExecutor"
        WebElement sendKeysToSearchBar = driver.findElement(By.name("s"));
        sendKeysToSearchBar.sendKeys("Thanks to JavascriptExecutor");

        //Go to the bottom of the page and click the book, name"jQuery in Action"
        WebElement findTheBook = driver.findElement(By.xpath("//a[@href='https://www.manning.com/books/jquery-in-action-third-edition']"));
        js.executeScript("arguments[0].scrollIntoView();" , findTheBook);
        findTheBook.click();

        // Do assertion
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.manning.com/books/jquery-in-action-third-edition" , currentUrl);



    }

}
