package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class TaskFiveCookies extends Tests {

    /*   Go to URL: http://facebook.com
     getCookies,
     addCookie,
     deleteCookieNamed,
     deleteAllCookies
*/
    @Test
    public void cookiesManipulating(){
        driver.navigate().to("http://facebook.com");

        //getCookies
        System.out.println("Number of Cookies in FaceBook = " + driver.manage().getCookies().size());

        //addCookie
        driver.manage().addCookie(new Cookie("My Name" ,"Rand"));
        System.out.println("Cookies Now: ");
        driver.manage().getCookies().forEach(System.out::println);

        //deleteCookieNamed
        driver.manage().deleteCookieNamed("My Name");

        //deleteAllCookies
        driver.manage().deleteAllCookies();

    }
}
