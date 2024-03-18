package testng.WeekFiveTasks;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import testng.Tests;

//Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.
public class Assignment4 extends Tests {


    @Test
    @Parameters({ "option-mac", "option-ipad" , "option-samsung" })
    public void searchAssertions(String optionMac , String optionIpad , String optionSamsung ){

        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");
        // Login
        By emailTextArea = By.id("input-email");
        By passwordTextArea = By.id("input-password");
        By submitButton = By.xpath("//input[@class='btn btn-primary']");

        bot.type(emailTextArea, "clarusway@gmail.com");
        bot.type(passwordTextArea , "123456789");
        bot.click(submitButton);

        // Locate the search bar
        By searchBar = By.name("search");

        // Searching using the parameters of three options
        bot.type(searchBar , optionMac + Keys.RETURN);

        bot.type(searchBar , optionIpad + Keys.RETURN);

        bot.type(searchBar , optionSamsung + Keys.RETURN);




    }


}
