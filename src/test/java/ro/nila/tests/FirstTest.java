package ro.nila.tests;

import org.testng.annotations.Test;
import ro.nila.base.TestBase;
import ro.nila.utilities.Commands;
import ro.nila.utilities.PropertiesManager;

public class FirstTest extends TestBase {

    @Test
    public void firstTest() {
        System.out.println("\nInside FIRST test\n");
        //  Go to login page
        Commands.clickElement("ui.lf.landingPage.loginButton.css");
        //  Accept Cookies
        Commands.clickElement("ui.lf.cookieButton.accept.css");
        //  Type username
        Commands.typeValue("ui.lf.loginPage.usernameField.css", USERNAME);
        //  Type password
        Commands.typeValue("ui.lf.loginPage.passwordField.css", PASSWORD);
        //  Login to Lebensfreunde
        Commands.clickElement("ui.lf.loginPage.loginButton.css");
        //  Logout from Lebensfreunde
        Commands.clickElement("ui.lf.homePage.logoutButton.css");
        //  Type username
        Commands.typeValue("ui.lf.loginPage.usernameField.css", USERNAME);
        //  Type password
        Commands.typeValue("ui.lf.loginPage.passwordField.css", PASSWORD + "wrong");
        //  Check that a error message is displayed

    }
}
