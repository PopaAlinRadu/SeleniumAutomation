package ro.nila.actions;

import org.openqa.selenium.By;
import ro.nila.business.ElementsState;

import static ro.nila.utilities.PropertiesManager.getValue;
import static ro.nila.utilities.PropertiesManager.*;

public class Checkpoints extends CommonActions {

    //  Check the URL that we pass as parameter with the one that driver get if from browser
    public static void checkUrl(String url) {
        waitForUrl(url);
        checkPathEquality(getValue(url), webDriver.getCurrentUrl());
    }

    public static void checkElementContainsExactText(String locator, String expectedText, String checkpointName) {

        webElement = waitElementTextToBe(By.cssSelector(getValue(locator)), getValue(expectedText));
        String actualText = getTextFromElement(webElement);

        checkEquality(expectedText, actualText, checkpointName, locator);
    }

    //  Check that an element have the following states: Enabled/Disabled, Displayed/Hidden, Selected/Deselected.
    public static void checkElementState(String locator, ElementsState state) {
        webElement = waitForElementPresent(By.cssSelector(getValue(locator)));

        switch (state) {
            case ENABLED:
                if (webElement.isEnabled())
                    statePass(locator, state);
                else
                    stateFail(locator, state);
                break;
            case DISABLED:
                if (!webElement.isEnabled())
                    statePass(locator, state);
                else
                    stateFail(locator, state);
                break;
            case DISPLAYED:
                if (webElement.isDisplayed())
                    statePass(locator, state);
                else
                    stateFail(locator, state);
                break;
            case HIDDEN:
                if (!webElement.isDisplayed())
                    statePass(locator, state);
                else
                    stateFail(locator, state);
                break;
            case SELECTED:
                if (webElement.isSelected())
                    statePass(locator, state);
                else
                    stateFail(locator, state);
                break;
            case DESELECTED:
                if (!webElement.isSelected())
                    statePass(locator, state);
                else
                    stateFail(locator, state);
                break;
        }
    }

    //  Check that a string we pass is equal with the one that a specify element contains
    private static void checkEquality(String expectedText, String actualText, String checkpointName, String locator) {

        String text = getValue(expectedText);

        if (actualText != null && actualText.equals(text)) {
            pass(checkpointName, locator);
        } else {
            fail(expectedText, actualText, locator);
        }
    }

    private static void checkPathEquality(String expectedText, String actualText) {
        if (expectedText.equals(actualText)) {
            pass(expectedText, null);
        } else {
            fail(actualText, expectedText, null);
        }
    }


    private static void pass(String checkpointName, String locator) {
        if (locator != null) {
            System.out.println("Element: " + locator + " contains: " + checkpointName);
        } else
            System.out.println("Expected URL equal: " + checkpointName);
    }

    private static void fail(String expectedText, String actualText, String locator) {
        if (locator != null) {
            assert false : "\nIn Element: " + locator + "\nActual text is: '" + actualText + "'\nShould be: '" + getValue(expectedText) + "'";
        } else {
            assert false : "\nSearched for: '" + actualText + "'\nFound: '" + expectedText + "'";
        }
    }

    private static void statePass(String locator, ElementsState state) {
        System.out.println("Element: " + locator + " state is: " + state.getState());
    }

    private static void stateFail(String locator, ElementsState state) {
        assert false : "\nIn Element: " + locator + "\nActual state is: '" + state.getOppositeState() + "'\nShould be: '" + state.getState() + "'";
    }

}
