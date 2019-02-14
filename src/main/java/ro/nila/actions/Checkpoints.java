package ro.nila.actions;

import org.openqa.selenium.By;
import ro.nila.business.Actions;
import ro.nila.business.ElementsState;

import static ro.nila.business.Actions.*;
import static ro.nila.business.ElementsState.*;
import static ro.nila.utilities.PropertiesManager.getValue;
import static ro.nila.utilities.PropertiesManager.*;
import static ro.nila.utilities.Utilities.*;

public class Checkpoints extends CommonActions {

    //  Check the URL that we pass as parameter with the one that driver get if from browser
    public static void checkUrl(String expectedUrl) {
        expectedUrl = getValue(expectedUrl);            // http://localhost:4200/homed
        String actualUrl = webDriver.getCurrentUrl();  // http://localhost:4200/home
        waitForUrl(expectedUrl, actualUrl);
        checkPathEquality(expectedUrl, actualUrl);
    }

    //  Check that inner text of an element match the exact expectedText
    public static void checkElementContainsExactText(String locator, String expectedText) {
        expectedText = getValue(expectedText);
//        webElement = waitElementTextToBe(By.cssSelector(getValue(locator)), expectedText);
        webElement = waitForElementPresent(By.cssSelector(getValue(locator)), locator);
        String actualText = getTextFromElement(webElement);
        checkEquality(locator, expectedText, actualText);
    }

    //  Check that an element have the following states: Enabled/Disabled, Displayed/Hidden, Selected/Deselected.
    public static void checkElementState(String locator, ElementsState state) {
        webElement = waitForElementPresent(By.cssSelector(getValue(locator)), locator);
        switch (state) {
            case ENABLED:
                if (webElement.isEnabled())
                    updatedLogSuccessSteps(locator, ENABLED.getState() , ENABLED.getState(), STATE);
                else
                    stateFail(locator, state);
                break;
            case DISABLED:
                if (!webElement.isEnabled())
                    updatedLogSuccessSteps(locator, ENABLED.getOppositeState() , ENABLED.getOppositeState(), STATE);
                else
                    stateFail(locator, state);
                break;
            case DISPLAYED:
                if (webElement.isDisplayed())
                    updatedLogSuccessSteps(locator, DISPLAYED.getState() , DISPLAYED.getState(), STATE);
                else
                    stateFail(locator, state);
                break;
            case HIDDEN:
                if (!webElement.isDisplayed())
                    updatedLogSuccessSteps(locator, DISPLAYED.getOppositeState() , DISPLAYED.getOppositeState(), STATE);
                else
                    stateFail(locator, state);
                break;
            case SELECTED:
                if (webElement.isSelected())
                    updatedLogSuccessSteps(locator, SELECTED.getState() , SELECTED.getState(), STATE);
                else
                    stateFail(locator, state);
                break;
            case DESELECTED:
                if (!webElement.isSelected())
                    updatedLogSuccessSteps(locator, DESELECTED.getOppositeState() , DESELECTED.getOppositeState(), STATE);
                else
                    stateFail(locator, state);
                break;
        }
    }

    //  Check that a string we pass is equal with the one that a specify element contains
    private static void checkEquality(String locator, String expectedText, String actualText) {
        if (expectedText.equals(actualText)) {
            pass(locator, expectedText, actualText, Actions.COMPARE_TEXT);
        } else {
            fail(locator, expectedText, actualText, COMPARE_TEXT);
        }
    }

    private static void checkPathEquality(String expectedText, String actualText) {
        if (expectedText.equals(actualText)) {
            pass(null, expectedText, actualText, COMPARE_URL);
        } else {
            fail(null, expectedText, actualText, COMPARE_URL);
        }
    }


    private static void statePass(String locator, ElementsState state) {
//        System.out.println("Element: " + locator + " state is: " + state.getState());
    }

    private static void stateFail(String locator, ElementsState state) {
//        assert false : "\nIn Element: " + locator + "\nActual state is: '" + state.getOppositeState() + "'\nShould be: '" + state.getState() + "'";
    }

}
