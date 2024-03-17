package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TaskTwoSoftAssertions extends Tests {

    //Go to URL: https://the-internet.herokuapp.com/windows
//Verify the text: “Opening a new window”
//Verify the title of the page is “The Internet”
//Click on the “Click Here” button
//Verify the new window title is “New Window”
//Go back to the previous window and then verify the title: “The Internet”
    @Test
    public void softAsser(){
        driver.navigate().to("https://the-internet.herokuapp.com/windows");
        SoftAssert softAssert = new SoftAssert();

        //Verify the text: “Opening a new window”
        WebElement findTheHeader = driver.findElement(By.tagName("h3"));
        softAssert.assertEquals("Opening a new window" , findTheHeader);

        //Verify the title of the page is “The Internet”
        String findTheTitle = driver.getTitle();
        softAssert.assertEquals("The Internet" , findTheTitle);

        //Click on the “Click Here” button
        WebElement findTheButton = driver.findElement(By.xpath("//a[@href='/windows/new']"));
        findTheButton.click();

        //Verify the new window title is “New Window”
        String findTheNewTitle = driver.getTitle();
        softAssert.assertEquals("New Window" , findTheNewTitle);

        //Go back to the previous window and then verify the title: “The Internet”
        driver.navigate().back();
        String findTheTitleAgain = driver.getTitle();
        softAssert.assertEquals("The Internet" , findTheTitleAgain);



    }

}
