package testng;

import engine.Login;
import org.testng.annotations.Test;

public class SauceDemoLoginTests extends Tests {

    @Test
    public void successfulLoginTest(){
        Login loginPage = new Login(driver , bot);
        loginPage.goTo();
        loginPage.login("standard_user" , "secret_sauce");
    }
}
