package ro.nila.actions;

import org.openqa.selenium.By;

import static ro.nila.business.Actions.*;
import static ro.nila.utilities.PropertiesManager.getValue;

public class Commands extends CommonActions {

    //  Search for an element on the page based on locator
    public static void findElement(String locator) {
        waitForElementPresent(By.cssSelector(getValue(locator)), locator);
        pass(locator, null, null, SEARCH);
    }

    //  Search for an element on the page and than click on it
    public static void findElementAndClick(String locator) {
        waitElementToBeClickable(By.cssSelector(getValue(locator)), locator);
        pass(locator, null, null, CLICK);
    }

    //  Method used to type into a input field
    public static void typeValue(String locator, String value) {
        waitElementToType(By.cssSelector(getValue(locator)), locator, value);
        pass(locator, value, null, TYPE);
    }
}
