package engine;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver driver ;
    ActionsBot bot ;
    private final String url = "https://www.saucedemo.com/v1/index.html" ;
    private final By userNameTextArea = By.id("user-name");
    private final By passwordTextArea = By.id("password");
    private final By submitButton = By.id("login-button");

    public Login(WebDriver driver , ActionsBot bot){
        this.driver = driver ;
        this.bot = bot ;
    }

    public  void goTo(){
        bot.navigate(url);
    }

    public void login(String username , String password){
        bot.type(userNameTextArea , username);
        bot.type(passwordTextArea , password);
        bot.click(submitButton);

    }

}
