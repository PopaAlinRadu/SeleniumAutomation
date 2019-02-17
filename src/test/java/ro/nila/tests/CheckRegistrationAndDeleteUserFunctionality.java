package ro.nila.tests;

import org.testng.annotations.Test;
import ro.nila.actions.Checkpoints;
import ro.nila.actions.Commands;
import ro.nila.base.TestBase;
import ro.nila.business.Account;
import ro.nila.business.ElementsState;

import static ro.nila.utilities.Utilities.getTestName;

public class CheckRegistrationAndDeleteUserFunctionality extends TestBase {

    private String email, password;

    @Override
    public void init() {
        email = "radualinpopaTEST@yahoo.com";
        password = "asd123";
    }

    @Test(description = "Check Registration and Delete user functionality")
    public void testToCheckRegistrationAndDeleteUser() {
        System.out.println("----> INSIDE TEST: " + getTestName(this.getClass().getDeclaredMethods()) + " <----");

        //  STEPS:

        //  Go to application URL (http://localhost:4200) and check if its correct
        Checkpoints.checkUrl("txt.application.home");
        //  Check if a Register button exist and click on it
        Commands.findElementAndClick("ui.navbar.registerButton.css");
        //  Check if a Registration form is displayed
        Checkpoints.checkElementTextToBe("ui.registrationPage.title.css", "txt.registrationPage.title");
        //  Check if the Registration form contains a field for email
        Commands.findElement("ui.registrationPage.emailField.css");
        //  Check if the Registration form contains a password field
        Commands.findElement("ui.registrationPage.passwordField.css");
        //  Check if a Sign Up button is displayed and is disable
        Checkpoints.checkElementState("ui.registrationPage.signUp.button.css", ElementsState.DISABLED);
        //  Enter valid email and valid password
        Commands.typeValue("ui.registrationPage.emailField.css", email);
        Commands.typeValue("ui.registrationPage.passwordField.css", password);
        //  Check if a Sign Up button is displayed and is enabled
        Checkpoints.checkElementState("ui.registrationPage.signUp.button.css", ElementsState.ENABLED);
        //  Click on Sign Up button
        Commands.findElementAndClick("ui.registrationPage.signUp.button.css");
        //  Click on Login button
        Commands.findElementAndClick("ui.navbar.loginButton.css");
        //  Enter the username and password from registration and click Sign In button
        Commands.typeValue("ui.loginPage.emailField.css", email);
        Commands.typeValue("ui.loginPage.passwordField.css", password);
        Commands.findElementAndClick("ui.loginPage.signIn.button.css");
        //  Check if the Registration process worked and user is logged in
            //  ->Check that there is a message on recipes page 'Please select a Recipe!'
            //  ->Check that URL is the correct one for recipes page
        Checkpoints.checkElementTextToBe("ui.recipesPage.message.css", "txt.recipesPage.message");
        Checkpoints.checkUrl("txt.application.recipes");
        //  Check if a Manage button is displayed and click on it
        Commands.findElementAndClick("ui.navbar.manageButton.css");
        //  Check if a Settings option is displayed and click on it
        Commands.findElementAndClick("ui.navbar.settingsButton.css");
        //  Check if user is on Settings Page
        Checkpoints.checkUrl("txt.application.settings");
        //  Check if a Delete User button is displayed and click on it
        Commands.findElementAndClick("ui.settingsPage.deleteButton.css");
        //  Check if user is redirected to Home Page
        Checkpoints.checkUrl("txt.application.home");
        Checkpoints.checkElementTextToBe("ui.homePage.welcome.css", "txt.home.welcome.message");
        //  Click on Login button
        Commands.findElementAndClick("ui.navbar.loginButton.css");
        //  Enter the username and password from registration and click Sign In button
        Commands.typeValue("ui.loginPage.emailField.css", email);
        Commands.typeValue("ui.loginPage.passwordField.css", password);
        Commands.findElementAndClick("ui.loginPage.signIn.button.css");
        //  Check if the user is not logged in and still on Login Page
        Checkpoints.checkElementTextToBe("ui.loginPage.title.css", "txt.loginPage.title");
        Checkpoints.checkUrl("txt.application.login");


        System.out.println("---> TEST FINISHED <---");
    }
}
