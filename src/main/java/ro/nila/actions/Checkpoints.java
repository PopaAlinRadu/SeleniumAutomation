package ro.nila.actions;

import org.openqa.selenium.By;
import ro.nila.business.ElementsState;

import static ro.nila.utilities.PropertiesManager.getValue;

public class Checkpoints extends CommonActions {

    //  Check the URL that we pass as parameter with the one that webDriver get if from browser
    public static void checkUrl(String expectedUrl) {
        expectedUrl = getValue(expectedUrl);
        waitForUrl(expectedUrl);
    }

    //  Check that webElement innerText equals expectedText
    public static void checkElementTextToBe(String locator, String expectedText) {
        expectedText = getValue(expectedText);
        waitElementTextToBe(By.cssSelector(getValue(locator)), expectedText, locator);
    }

    //  Check webElement states(Enable/Disable, Displayed/Hidden, Selected/Deselected)
    public static void checkElementState(String locator, ElementsState elementsState) {
        waitElementState(locator, elementsState);
    }
}
