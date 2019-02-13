package ro.nila.tests;

import org.testng.annotations.Test;
import ro.nila.actions.Checkpoints;
import ro.nila.actions.Commands;
import ro.nila.base.TestBase;
import ro.nila.business.ElementsState;


import static ro.nila.utilities.Utilities.getTestName;

public class CheckLoginFunctionality extends TestBase {

    private String email, password;

    @Override
    public void init() {
        email = "radualinpopa@yahoo.com";
        password = "asd123";
    }

    @Test(description = "On user profile page the name should be displayed and correct")
    public void testToCheckLoginFunctionality() {
        System.out.println("----> INSIDE TEST: " + getTestName(this.getClass().getDeclaredMethods()) + " <----");

        //  STEPS:

        //  Check that user is on the home page
        Checkpoints.checkUrl("txt.application.home");
        //  Check that a Login button is displayed and click on it
        Commands.clickElement("ui.loginPage.loginButton.css");
        //  Check that form is displayed and contains a email field
        Commands.clickElement("ui.loginPage.emailField.css");
        //  Check that a form contains a password field
        Commands.clickElement("ui.loginPage.passwordField.css");
        //  Check that Sign In button is displayed and is disabled
        Checkpoints.checkElementState("ui.loginPage.signIn.button.css", ElementsState.DISABLED);
        //  Enter invalid email and valid password
        Commands.typeValue("ui.loginPage.emailField.css","invalid");
        Commands.typeValue("ui.loginPage.passwordField.css",password);
        //  Check that Sign In button is enabled
        Checkpoints.checkElementState("ui.loginPage.signIn.button.css", ElementsState.ENABLED);
        //  Click Sign In button
        Commands.clickElement("ui.loginPage.signIn.button.css");
        //  Check if login failed and user is still on login page
        Checkpoints.checkUrl("txt.application.login");
        //  Enter valid email and invalid password
        Commands.typeValue("ui.loginPage.emailField.css",email);
        Commands.typeValue("ui.loginPage.passwordField.css","invalid");
        //  Check that Sign In button is enabled
        Checkpoints.checkElementState("ui.loginPage.signIn.button.css", ElementsState.ENABLED);
        //  Click Sign In button
        Commands.clickElement("ui.loginPage.signIn.button.css");
        //  Check if login failed and user is still on login page
        //  Enter valid email and invalid password
        Commands.typeValue("ui.loginPage.emailField.css",email);
        Commands.typeValue("ui.loginPage.passwordField.css",password);
        //  Click Sign In button
        Commands.clickElement("ui.loginPage.signIn.button.css");
        //  Check if the login was successful and user is on recipes page
        Checkpoints.checkUrl("txt.application.recipes");
        //  Check if a Logout button exists and click on it
        Commands.clickElement("ui.navbar.logoutButton.css");
        //  Check if the logout was successful and you are on home page
        Checkpoints.checkUrl("txt.application.home");

        System.out.println("---> TEST FINISHED <---");
    }
}
