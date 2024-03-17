package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TaskThreeDragAndDrop extends Tests {

     /*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/
    @Test
    public void draggable(){

        driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");

        Actions action = new Actions(driver);
        // Drag and drop the BANK button to the Account section in DEBIT SIDE
        WebElement bankButton = driver.findElement(By.id("credit2"));
        WebElement accountSectionDEBITSIDE = driver.findElement(By.xpath("//ol[@id='bank']"));
        action.dragAndDrop(bankButton , accountSectionDEBITSIDE).perform();


        // Drag and drop the SALES button to the Account section in CREDIT SIDE
        WebElement salesButton = driver.findElement(By.id("credit1"));
        WebElement accountSectionCREDITSIDE = driver.findElement(By.xpath("//ol[@id='loan']"));
        action.dragAndDrop(salesButton , accountSectionCREDITSIDE).perform();


        // Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        WebElement first500Button = driver.findElement(By.xpath("//li[@class='block13 ui-draggable'][1]"));
        WebElement amountSectionDEBITSIDE = driver.findElement(By.xpath("//ol[@id='amt7']"));
        action.dragAndDrop(first500Button , amountSectionDEBITSIDE).perform();

        // Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        WebElement second500Button = driver.findElement(By.xpath("//li[@class='block13 ui-draggable'][2]"));
        WebElement amountSectionCREDITSIDE = driver.findElement(By.xpath("//ol[@id='amt8']"));
        action.dragAndDrop(second500Button , amountSectionCREDITSIDE).perform();

        // Verify the visibility of Perfect text.

       // WebElement perfectText = driver.findElement(By.xpath("//div[@class='table4_result']"));
        //perfectText.isDisplayed();

        Assertions.assertEquals("Perfect!", driver.findElement(By.xpath("//div[@class='table4_result']")).getText());








    }
}
