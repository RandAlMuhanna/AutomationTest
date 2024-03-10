package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertTask {


//Go to URL: http://demo.automationtesting.in/Alerts.html
//Click "Alert with OK" and click 'click the button to display an alert box:’
//Accept Alert(I am an alert box!) and print alert on console.
//Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
//Cancel Alert (Press a Button !)
//Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
//And then sendKeys «Bootcamp» (Please enter your name)
//Finally print on console this message "Hello Bootcamp How are you today" assertion these message.

    WebDriver driver ;
    @Test
    public void check(){

        // Click On Alert Box
        By findAlertWithOK = By.xpath("//a[@href='#OKTab']");
        driver.findElement(findAlertWithOK).click();

        // Click On Display Alert Box
        By clickButtonToDisplayAlertBox = By.xpath("(//button[contains(@class,'btn-danger')])");
        driver.findElement(clickButtonToDisplayAlertBox).click();

        // Print The Alert Message
        var alertPrintText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
       System.out.println(alertPrintText);

        // Click On Alert with OK & Cancel
        By AlertWithOKAndCancel = By.xpath("//a[@href='#CancelTab']");
        driver.findElement(AlertWithOKAndCancel).click();

        By clickButtonToDisplayConfirmBox= By.xpath("(//button[contains(@class,'btn-primary')])");
        driver.findElement(clickButtonToDisplayConfirmBox).click();
        driver.switchTo().alert().dismiss();

        // Click On Alert with Textbox
        By clickOnAlertWithTextbox = By.xpath("//a[@href='#Textbox']");
        driver.findElement(clickOnAlertWithTextbox).click();
        By clikOnPromptBox = By.xpath("(//button[contains(@class,'btn-info')])");
        driver.findElement(clikOnPromptBox).click();
        driver.switchTo().alert().sendKeys("«Bootcamp»");
        driver.switchTo().alert().accept();

        //Print on console this message "Hello Bootcamp How are you today" assertion these message.

        By printHelloMessage = By.xpath("//p[@id='demo1']");
        String actualMessage = driver.findElement(printHelloMessage).getText();
        System.out.println(actualMessage);
        Assertions.assertEquals( "Hello «Bootcamp» How are you today",actualMessage);



    }

    @BeforeEach
    public void beforeEach(){

        driver = new ChromeDriver();
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }


}
