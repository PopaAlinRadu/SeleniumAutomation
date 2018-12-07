package ro.nila.tests;

import org.testng.annotations.Test;
import ro.nila.actions.Checkpoints;
import ro.nila.actions.Commands;
import ro.nila.base.TestBase;
import ro.nila.business.Account;

import static ro.nila.utilities.Utilities.getTestName;

public class CheckUserNameOnProfilePage extends TestBase {

    Account account;
    String fullName;

    @Override
    public void init() {
        account = new Account();
        fullName = (account.getFirstName() + " " + account.getSecondName());
    }

    @Test(description = "On user profile page the name should be displayed and correct")
    public void testToCheckUserNameOnProfilePage() {
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
        //  Click on Name from Start page
        Commands.clickElement("ui.lf.start.name.css");
        //  Check that we are on the profile page
        Checkpoints.checkElementContainsExactText("ui.lf.profile.name", fullName, "Name is displayed and correct");
        //  Logout
        Commands.clickElement("ui.lf.homePage.logoutButton.css");

        System.out.println("---> TEST FINISHED <---");
    }
}