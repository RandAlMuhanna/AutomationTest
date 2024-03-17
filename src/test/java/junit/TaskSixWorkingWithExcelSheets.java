package junit;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import java.io.*;

public class TaskSixWorkingWithExcelSheets {


    @Test
    public void AccessExcel() throws IOException {

        FileInputStream fileInputStream = new FileInputStream("/Users/randalmuhanna/IdeaProjects/testProject/resources/RandSheet.xlsx");

        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet("People");

        //Create a cell on the 3rd column (2nd index) on the first row.
        Row rowOne = sheet.getRow(1);
        rowOne.createCell(2).setCellValue("Population");

        //Create a cell on the 2nd row 3rd cell(index2), and write data.
        Row rowTwo = sheet.getRow(2);
        Row rowThree = sheet.getRow(3);
        Row rowFour = sheet.getRow(4);

        rowTwo.createCell(2).setCellValue("Data");
        rowThree.createCell(2).setCellValue("Data");
        rowFour.createCell(2).setCellValue("Data");

        // Execute
        FileOutputStream outputFile = new FileOutputStream("/Users/randalmuhanna/IdeaProjects/testProject/resources/RandSheet.xlsx");
        workbook.write(outputFile);

    }
}