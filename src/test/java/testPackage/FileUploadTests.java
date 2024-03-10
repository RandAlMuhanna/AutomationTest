package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadTests extends Tests {

    /**
     * Breakout Activity: 20 minute
     * navigate to <a href="https://the-internet.herokuapp.com/upload">Upload Test</a>
     * uploading any file from your machine (make it small please)
     * checking to see that the file was successfully uploaded
     */
    WebDriver driver;

    @Test
    public void uploadFile (){
        String url = "https://the-internet.herokuapp.com/upload";
        driver.get(url);

        logger.info("Navigating to: " + url);

        By fileUploadInput = By.xpath("//input[@type='file']");

        String filePath = "/Users/randalmuhanna/Desktop/Screenshot 1445-08-25 at 8.40.15 AM.png";
        logger.info("Uploading File" + filePath);
        driver.findElement(fileUploadInput).sendKeys(filePath);
        driver.findElement(fileUploadInput).submit();

        By uploadMessage = By.tagName("h3");
        logger.info("Confirming that the file has been added successfully");

        Assertions.assertEquals("File Uploaded!" , driver.findElement(uploadMessage).getText());




    }

}
