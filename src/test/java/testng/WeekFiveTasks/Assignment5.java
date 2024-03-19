package testng.WeekFiveTasks;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testng.Tests;

//Go to URL: http://crossbrowsertesting.github.io/
//Click to To-Do App
//Checking Box to do-4 and Checking Box to do-5
//If both clicks worked, then the following List should have length 2.
//Assert that this is correct
//Assert that the to do we added is present in the list
//Archiving old todos
//If our archive link worked, then the following list should have length 4.
//Assert that this is true as well
//Doing Cross Browser Testing.
public class Assignment5 extends Tests {

    ActionsBot bot;
    @Test
    public void toDoCheck(){

        driver.get("http://crossbrowsertesting.github.io/");

        By toDoApp = By.xpath("//a[@href='todo-app.html']");
        driver.findElement(toDoApp).click();

        By toDo4 = By.name("todo-4");
        driver.findElement(toDo4).click();

        By toDo5 = By.name("todo-5");
        driver.findElement(toDo5).click();

        //If both clicks worked, then the following List should have length 2.
        By theCheckBox = By.xpath("//span[@class='done-true']");
        int listSize = driver.findElements(theCheckBox).size();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(listSize , 2);

        //Assert that the to do we added is present in the list
        By textField = By.id("todotext");
        By submitButton = By.id("addbutton");

        driver.findElement(textField).sendKeys("Walk");
        driver.findElement(submitButton).click();

        //Assert that the to do we added is present in the list
        By myNewList = By.xpath("//span[@class='done-false' and text()='Walk']");
        softAssert.assertTrue(driver.findElement(myNewList).isDisplayed());

        //Archiving old todos

        By archiveToDo1 = By.name("todo-1");
        driver.findElement(archiveToDo1).click();

        By archiveToDo2 = By.name("todo-2");
        driver.findElement(archiveToDo2).click();

        By archiveToDo3 = By.name("todo-3");
        driver.findElement(archiveToDo3).click();

        By archiveToDo4 = By.name("todo-4");
        driver.findElement(archiveToDo4).click();

        By archiveToDo5 = By.name("todo-5");
        driver.findElement(archiveToDo5).click();

        By archiveOldToDos = By.xpath("//a[text()='archive']");
        driver.findElement(archiveOldToDos).click();

        //If our archive link worked, then the following list should have length 4.
        By unArchiveList = By.xpath("//span[@class='done-false']");
        int newListSize = driver.findElements(unArchiveList).size();
        softAssert.assertEquals(newListSize , 4);
        softAssert.assertAll();

    }
}
