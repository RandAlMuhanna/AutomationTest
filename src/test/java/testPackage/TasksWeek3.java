package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksWeek3 {

    //Task 1:

      /*
Create main method
Create chrome driver
Open google home page: https://www.google.com
Print Title on page
Print Current URL on page
Close/Quit the browser
     */

    @Test
    public void Task1(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");

        String pageTitle = driver.getTitle();
        System.out.println("Page Title Is :" + pageTitle);

        String pageURL = driver.getCurrentUrl();
        System.out.println("Current URL Is :" + pageURL);

        driver.quit();

    }

//Task 2 : Differences between get() method and navigate to() method?
/*

Differences between get() method and navigate to() method in selenium :
get() is a method of the WebDriver interface used to navigate to a URL directly on the driver instance.
get() navigates to the given URL and waits for the page to load completely before proceeding.

navigate().to() is a method of the WebDriver.Navigation interface used to navigate to a URL using the navigate() method on the driver instance.
navigate().to() navigates to the given URL without waiting for the page to load completely, allowing you to move to another page without waiting for the current page to finish loading.
 */


//Task 3 :
    /*
Invoke Chrome Driver
Navigate to Facebook homepage URL: https://www.facebook.com/
Verify expected URL equals to the actual URL.
Verify  pagesource of FaceBook contains "Facebook" .
    */

    @Test
    public void Task3(){

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.facebook.com/");

        // Verify expected URL
        var expectedURL = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.facebook.com/", expectedURL);

        // Verify  pagesource
        String pagesourceContain = "Facebook" ;

        if(driver.getPageSource().contains(pagesourceContain)){
            System.out.println(pagesourceContain + " is present. ");
        } else {
            System.out.println(pagesourceContain + " is not present. ");
        }


        driver.quit();



    }

// Task 4 :
/*
Navigate to website  https://testpages.herokuapp.com/styled/index.html
Under the Examples Click on Locators - Find By Playground Test Page
Print the URL
Navigate back
Print the URL
Click on WebDriver Example Page
Print the URL
Enter value 🡪 20 and Enter to "Enter Some Numbers inputBox"
And then verify ‘two, zero’ message is displayed on page
Close driver.
*/

    @Test
    public void FindElements(){

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        // Play Ground Page
        By findPlaygroundTestPage = By.xpath(" //a[@id='findbytest']");
        driver.findElement(findPlaygroundTestPage).click();

        var getPlaygroundTestPageURL = driver.getCurrentUrl();
        System.out.println("The Playground Test Page URL :" + getPlaygroundTestPageURL);

        driver.navigate().back();

        // Back To Main Page
        var getMainPageURL = driver.getCurrentUrl();
        System.out.println("The Main Page URL :" + getMainPageURL);

        // Driver Example Page
        By clickDriverExamplePage = By.xpath( "//a[@id='webdriverexamplepage']");
        driver.findElement(clickDriverExamplePage).click();
        var getDriverExamplePageURL = driver.getCurrentUrl();
        System.out.println("The Driver Example Page URL :" + getDriverExamplePageURL);

        // Fill the textField And Submit
        WebElement addNumbersToTextField = driver.findElement(By.id("numentry"));
        addNumbersToTextField.sendKeys("20");

        WebElement submitTheNumber = driver.findElement(By.id("submit-to-server"));
        submitTheNumber.click();

        Assertions.assertEquals("20", addNumbersToTextField);

        driver.quit();

    }
}




