package ro.nila.tests;

import org.testng.annotations.Test;
import ro.nila.actions.Checkpoints;
import ro.nila.actions.Commands;
import ro.nila.base.TestBase;
import ro.nila.business.Account;

import static ro.nila.utilities.Utilities.getTestName;

public class LoginWithValidAndInvalidCredentials extends TestBase {

    Account account;
    String fullName;

    @Override
    public void init() {
        account = new Account();
        fullName = (account.getFirstName() + " " + account.getSecondName());
    }

    @Test(description = "Check that can login with valid credential and not with invalid")
    public void testToCheckLogin() {
        System.out.println("----> INSIDE TEST: " + getTestName(this.getClass().getDeclaredMethods()) + " <----");

        //  STEPS:
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
        //  Logout
        Commands.clickElement("ui.lf.homePage.logoutButton.css");
        //  Enter username
        Commands.typeValue("ui.lf.loginPage.usernameField.css", account.getUsername());
        //  Enter wrong password
        Commands.typeValue("ui.lf.loginPage.passwordField.css", account.getPassword() + "wrong");
        //  Login
        Commands.clickElement("ui.lf.loginPage.loginButton.css");
        //  Check that a error message is shown for invalid credentials
        Checkpoints.checkElementContainsExactText("ui.lf.loginPage.login.fail.css", "txt.lf.loginPage.login.fail", "Error message for invalid credentials");

        System.out.println("---> TEST FINISHED <---");
    }
}
