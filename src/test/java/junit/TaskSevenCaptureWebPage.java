package junit;

import java.io.File;

import com.google.common.io.Files;
import org.apache.logging.log4j.core.util.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.IOException;

public class TaskSevenCaptureWebPage extends Tests {

    // Go to amazon.com
    // Take Full Page Screenshot.
    // Take any specific WebElement ScreenShot


    @Test
    public void takeScreenshot() throws IOException, InterruptedException {

        driver.navigate().to("https://www.amazon.com/");


        //Take full page ScreenShoot
        var takesScreenshot = (TakesScreenshot) driver ;
        File fullScreenShoot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        Files.move(fullScreenShoot, new File("/Users/randalmuhanna/IdeaProjects/testProject/resources/images.png"));
        Thread.sleep(3000);

        //Take any specific WebElement ScreenShot
        WebElement specificElement = driver.findElement(By.xpath("//i[@class='a-icon a-logo']"));
        File specificElementScreenShoot = ((TakesScreenshot)specificElement).getScreenshotAs(OutputType.FILE);
        Files.move(specificElementScreenShoot, new File("/Users/randalmuhanna/IdeaProjects/testProject/resources/images.png"));

        Thread.sleep(3000);



    }






}
