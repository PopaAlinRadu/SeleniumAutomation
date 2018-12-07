package ro.nila.actions;

import org.openqa.selenium.By;

import static ro.nila.actions.Commands.getTextFromElement;
import static ro.nila.actions.Commands.waitElementTextToBe;
import static ro.nila.utilities.PropertiesManager.getValue;
import static ro.nila.utilities.PropertiesManager.webElement;

public class Checkpoints extends CommonActions {

    public static void checkElementContainsExactText(String locator, String expectedText, String checkpointName) {

        webElement = waitElementTextToBe(By.cssSelector(getValue(locator)), getValue(expectedText));
        String actualText = getTextFromElement(webElement);

        checkEquality(expectedText, actualText, checkpointName, locator);
    }

    private static void checkEquality(String expectedText, String actualText, String checkpointName, String locator) {

        String text = getValue(expectedText);

        if (actualText != null && actualText.equals(text)) {
            pass(checkpointName, locator);
        } else {
            fail(expectedText, actualText, locator);
        }
    }


    public static void pass(String checkpointName, String locator) {
        System.out.println("Element: " + locator + " contains: " + checkpointName);
    }

    public static void fail(String expectedText, String actualText, String locator) {
        assert false : "\nIn Element: " + locator + "\nActual text is: '" + actualText + "'\nShould be: '" + getValue(expectedText) + "'";
    }
}
