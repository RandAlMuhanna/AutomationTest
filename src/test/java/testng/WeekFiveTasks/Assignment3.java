package testng.WeekFiveTasks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testng.Tests;


/* go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!"
*/
public class Assignment3 extends Tests {

    @Test
    public void loginAssertion(){
        bot.navigate("https://practicetestautomation.com/practice-test-login/");

        // Do the login
        By usernameTextarea = By.id("username");
        By passwordTextarea = By.id("password");
        By submitButton = By.id("submit");

        bot.type(usernameTextarea , "student");
        bot.type(passwordTextarea , "incorrectPassword");
        bot.click(submitButton);

        // SOFT ASSERT the error message shown
        SoftAssert softAssert = new SoftAssert();
        By errorMessage = By.id("error");
        softAssert.assertTrue(driver.findElement(errorMessage).isDisplayed());

        // SOFT ASSERT the error message is "Your password is invalid!"
        softAssert.assertEquals(driver.findElement(errorMessage).getText(), "Your password is invalid!");
        softAssert.assertAll();






    }

}
