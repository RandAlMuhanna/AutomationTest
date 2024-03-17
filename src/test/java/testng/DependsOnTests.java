package testng;

import org.testng.annotations.Test;

public class DependsOnTests extends Tests{

    @Test
    public void goToFacebook(){
        bot.navigate("https://www.facebook.com");

    }

    @Test(dependsOnMethods = "goToFacebook")
    public void goToGoogle(){

        bot.navigate("https://www.google.com");
    }

    @Test(dependsOnMethods = "goToGoogle")
    public void goToAmazon(){
        bot.navigate("https://www.amazon.com");
    }


}
