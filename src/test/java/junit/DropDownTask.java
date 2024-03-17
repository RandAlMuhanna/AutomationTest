package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownTask {


    WebDriver driver ;

    @Test
    public void dropDownCheck(){

        WebElement findOptions = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(findOptions);

        List<WebElement> allOptions = select.getOptions();
        //Options size
       System.out.println("option Size = " + allOptions.size());

        //Get all the options of the dropdown
        System.out.println("All options: ");

        for (WebElement option : allOptions)
        {
            System.out.println(option.getText());

        }

        //Verify the dropdown has option "Black"
        System.out.println("Is Contain Black On List? " + findOptions.getText().contains("Black"));
        //Print FirstSelectedOptionTest
        System.out.println(select.getFirstSelectedOption().getText());
        //Select option "Yellow"
        select.selectByVisibleText("Yellow");

    }


    @BeforeEach
    public void beforeEach(){

        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/select-menu");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void afterEach(){

        driver.quit();
    }
}

