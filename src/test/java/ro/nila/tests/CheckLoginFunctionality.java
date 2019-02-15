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
    public void testToCheckLoginFunctionality() throws InterruptedException {
        System.out.println("----> INSIDE TEST: " + getTestName(this.getClass().getDeclaredMethods()) + " <----");

        //  STEPS:

        //  Check that user is on the home page
        Checkpoints.checkUrl("txt.application.home");
        //  Check that there is a welcome message on the page
        Checkpoints.checkElementTextToBe("ui.homePage.welcome.css", "txt.home.welcome.message");
        //  Check that a Login button is displayed and click on it
        Commands.findElementAndClick("ui.loginPage.loginButton.css");
        //  Check that form is displayed and contains
        //  Email field
        Commands.findElement("ui.loginPage.emailField.css");
        //  Password field
        Commands.findElement("ui.loginPage.passwordField.css");
        //  Check that Sign In button is displayed and is disabled
        Checkpoints.checkElementState("ui.loginPage.signIn.button.css", ElementsState.DISABLED);
        //  Enter invalid email and valid password
        Commands.typeValue("ui.loginPage.emailField.css", "invalid");
        Commands.typeValue("ui.loginPage.passwordField.css", password);
        //  Check that Sign In button is enabled
        Checkpoints.checkElementState("ui.loginPage.signIn.button.css", ElementsState.ENABLED);
        //  Click Sign In button
        Commands.findElementAndClick("ui.loginPage.signIn.button.css");
        //  Check that login failed and user is still on login page
        Checkpoints.checkUrl("txt.application.login");
        //  Enter valid email and invalid password
        Commands.typeValue("ui.loginPage.emailField.css", email);
        Commands.typeValue("ui.loginPage.passwordField.css", "invalid");
        //  Check that Sign In button is enabled
        Checkpoints.checkElementState("ui.loginPage.signIn.button.css", ElementsState.ENABLED);
        //  Click Sign In button
        Commands.findElementAndClick("ui.loginPage.signIn.button.css");
        //  Check that login failed and user is still on login page
        //  Enter valid email and invalid password
        Commands.typeValue("ui.loginPage.emailField.css", email);
        Commands.typeValue("ui.loginPage.passwordField.css", password);
        //  Click Sign In button
        Commands.findElementAndClick("ui.loginPage.signIn.button.css");
        //  Check that the login was successful and there is a message on recipes page 'Please select a Recipe!'
        Checkpoints.checkElementTextToBe("ui.recipesPage.message.css", "txt.recipesPage.message");
        //  Check that URL is the correct one for recipes page
        Checkpoints.checkUrl("txt.application.recipes");
        //  Check that a Logout button exists and click on it
        Commands.findElementAndClick("ui.navbar.logoutButton.css");
        //  Check that after logout there is a welcome message on the page
        Checkpoints.checkElementTextToBe("ui.homePage.welcome.css", "txt.home.welcome.message");
        //  Check that the logout was successful and you are on home page
        Checkpoints.checkUrl("txt.application.home");

        System.out.println("---> TEST FINISHED <---");
    }
}
