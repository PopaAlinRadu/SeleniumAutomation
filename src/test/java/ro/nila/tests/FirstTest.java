package ro.nila.tests;

import org.testng.annotations.Test;
import ro.nila.actions.Checkpoints;
import ro.nila.actions.Commands;
import ro.nila.base.TestBase;
import ro.nila.business.Account;

public class FirstTest extends TestBase {

    @Test
    public void testOne() {
        Account account = new Account();
        String fullName = (account.getFirstName() + " " + account.getSecondName());

//------------------------------------------------------------//
        String methodName = new Object() {
        }                   //
                .getClass()                                   //
                .getEnclosingMethod()                         //
                .getName();                                   //
//------------------------------------------------------------//

        System.out.println("----> INSIDE TEST: " + methodName + " <----");

//      STEPS:
        //  Click on Login button from landing page
        Commands.clickElement("ui.lf.landingPage.loginButton.css");
        //  Click to accept cookies
        Commands.clickElement("ui.lf.cookieButton.accept.css");
        //  Enter username
        Commands.typeValue("ui.lf.loginPage.usernameField.css", account.getUsername());
        //  Enter password
        Commands.typeValue("ui.lf.loginPage.passwordField.css", account.getPassword());
        //  Login
        Commands.clickElement("ui.lf.loginPage.loginButton.css");
        //  Click on Name from Start page
        Commands.clickElement("ui.lf.start.name.css");
        //  Check that we are on the profile page
        Checkpoints.checkElementContainsExactText("ui.lf.profile.name", fullName, "Name is displayed and correct");
        //  Logout
        Commands.clickElement("ui.lf.homePage.logoutButton.css");
        //  Enter username
        Commands.typeValue("ui.lf.loginPage.usernameField.css", account.getUsername());
        //  Enter wrong password
        Commands.typeValue("ui.lf.loginPage.passwordField.css", account.getPassword()+ "wrong");
        //  Login
        Commands.clickElement("ui.lf.loginPage.loginButton.css");
        //  Check that a error message is shown for invalid credentials
        Checkpoints.checkElementContainsExactText("ui.lf.loginPage.login.fail.css", "txt.lf.loginPage.login.fail", "Error message for invalid credentials");

        System.out.println("---> TEST FINISHED <---");
    }
}
