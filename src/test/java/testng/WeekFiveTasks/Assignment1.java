package testng.WeekFiveTasks;

import org.testng.annotations.Test;
import testng.Tests;

/*
   Create tests that depend on each other
   Create beforeClass and set up settings.
   By creating interdependent tests;
   First go to Facebook.
   Then go to Google depending on Facebook,
   Then go to Amazon depending on Google
   Close the driver.
    */

public class Assignment1 extends Tests {

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
