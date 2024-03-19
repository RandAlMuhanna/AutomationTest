package testng.WeekFiveTasks;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import testng.Tests;
import java.io.FileInputStream;
import java.io.IOException;


/*
Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
Add 10 notes using data provider with excel
Run it with 3 different browsers using XML file
Run it parallel with 3 threads
 */


public class Assignment2 extends Tests {



    @Test
    public void excelDataProvider() throws IOException  {
        driver.get("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");

        String filePath = "/Users/randalmuhanna/IdeaProjects/testProject/resources/DataProvider.xlsx";
        Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
        Sheet sheet = workbook.getSheetAt(0);

        By titleTextArea = By.id("note-title-input");
        By noteTextArea = By.id("note-details-input");
        By addButton = By.id("add-note");

        for (int i = 0; i < 10; i++ ){


            driver.findElement(titleTextArea).sendKeys(sheet.getRow(i).getCell(1).toString());
            driver.findElement(noteTextArea).sendKeys(sheet.getRow(i).getCell(2).toString());
            driver.findElement(addButton).click();


        }
    }

}








