package ro.nila.tests;

import org.testng.annotations.Test;
import ro.nila.actions.Checkpoints;
import ro.nila.actions.Commands;
import ro.nila.base.TestBase;
import ro.nila.business.ElementsState;

import static ro.nila.utilities.Utilities.getTestName;

public class CheckAddRecipeFunctionality extends TestBase {

    String email, password, recipeName, recipeImgUrl, recipeDescription;

    @Override
    public void init() {
        email = "radualinpopa@yahoo.com";
        password = "asd123";
        recipeName = "Paste cu carne tocata";
        recipeImgUrl = "https://retete.unica.ro/wp-content/uploads/2014/04/Paste-cu-carne.jpg";
        recipeDescription = "detalii despre reteta";
    }

    @Test(description = "Check add recipe functionality")
    public void testToCheckAddRecipeFunctionality() throws InterruptedException {
        System.out.println("----> INSIDE TEST: " + getTestName(this.getClass().getDeclaredMethods()) + " <----");

        //  STEPS:

        //  Click on Login button to go to login page
        Commands.findElementAndClick("ui.navbar.loginButton.css");
        //  Enter valid email and password
        Commands.typeValue("ui.registrationPage.emailField.css", email);
        Commands.typeValue("ui.registrationPage.passwordField.css", password);
        //  Click on Sign In button
        Commands.findElementAndClick("ui.loginPage.signIn.button.css");
        //  Check that user is on recipes page
        Checkpoints.checkElementTextToBe("ui.recipesPage.message.css", "txt.recipesPage.message");
        //  Check if a New Recipe button exists and click on it
        Commands.findElementAndClick("ui.recipePage.newRecipeButton.css");
        //  Check that Cancel and Save buttons are displayed
        Commands.findElement("ui.recipePage.form.cancelButton.css");
        Commands.findElement("ui.recipePage.form.saveButton.css");
        //  Check that Save button is disabled
        Checkpoints.checkElementState("ui.recipePage.form.saveButton.css", ElementsState.DISABLED);
        //  Check that a form is displayed and have fields:
        //  Name, Image URL, Description
        Commands.findElement("ui.recipePage.form.name.css");
        Commands.findElement("ui.recipePage.form.url.css");
        Commands.findElement("ui.recipePage.form.description.css");
        //  Enter a recipe details in the fields Name, Image URL, Description
        Commands.typeValue("ui.recipePage.form.name.css", recipeName);
        Commands.typeValue("ui.recipePage.form.url.css", recipeImgUrl);
        Commands.typeValue("ui.recipePage.form.description.css", recipeDescription);
        //  Check that Save button is enabled and click on it
        Checkpoints.checkElementState("ui.recipePage.form.saveButton.css", ElementsState.ENABLED);
        Commands.findElementAndClick("ui.recipePage.form.saveButton.css");
        //  Check that a recipe has been added and contains correct:
        //  Name, Description, Image
        Commands.findElement("ui.recipePage.recipe.css");
        Checkpoints.checkElementTextToBe("ui.recipePage.recipe.name.css", recipeName);
        Checkpoints.checkElementTextToBe("ui.recipePage.recipe.description.css", recipeDescription);
        //  TODO take img atr and compare it
        Commands.findElement("ui.recipePage.recipe.image.css");
        //  Click on Manage button
        Commands.findElementAndClick("ui.navbar.manageButton.css");
        //  Check that a Save Data option is displayed and click on it
        Commands.findElementAndClick("ui.navbar.manage.saveData.css");
        //  Click on Logout button
        Thread.sleep(2000);
        Commands.findElementAndClick("ui.navbar.logoutButton.css");


        System.out.println("---> TEST FINISHED <---");
    }

    @Test(description = "Check fetch data functionality")
    public void testToCheckFetchDataFunctionality() {
        System.out.println("----> INSIDE TEST: " + getTestName(this.getClass().getDeclaredMethods()) + " <----");

        //  STEPS:

        ////  Click on Login button to go to login page
        Commands.findElementAndClick("ui.navbar.loginButton.css");
        //  Enter valid email and password
        Commands.typeValue("ui.registrationPage.emailField.css", email);
        Commands.typeValue("ui.registrationPage.passwordField.css", password);
        //  Click on Sign In button
        Commands.findElementAndClick("ui.loginPage.signIn.button.css");
        //  Check that user is on recipes page
        Checkpoints.checkElementTextToBe("ui.recipesPage.message.css", "txt.recipesPage.message");
        //  Check that no recipe is displayed
        //  TODO
        //  Click on Manage button
        Commands.findElementAndClick("ui.navbar.manageButton.css");
        //  Check that a Fetch Data option is displayed and click on it
        Commands.findElementAndClick("ui.navbar.manage.fetchData.css");
        //  Check that a recipe is displayed and contains correct:
            //  Name, Description, Image
        Commands.findElement("ui.recipePage.recipe.css");
        Checkpoints.checkElementTextToBe("ui.recipePage.recipe.name.css", recipeName);
        Checkpoints.checkElementTextToBe("ui.recipePage.recipe.description.css", recipeDescription);
        //  TODO take img atr and compare it
        Commands.findElement("ui.recipePage.recipe.image.css");
        //  Click on Logout button
        Commands.findElementAndClick("ui.navbar.logoutButton.css");

        System.out.println("---> TEST FINISHED <---");
    }
}
