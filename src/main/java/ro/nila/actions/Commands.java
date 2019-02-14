package ro.nila.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import ro.nila.business.Actions;

import static ro.nila.business.Actions.*;
import static ro.nila.utilities.PropertiesManager.*;
import static ro.nila.utilities.Utilities.*;

public class Commands extends CommonActions {

    //  Method used to click on elements based on a locator
    public static void findElementAndClick(String locator) {
        try {
            webElement = webDriver.findElement(By.cssSelector(getValue(locator)));
            webElement.click();
            pass(locator, null, null, CLICK);
        } catch (StaleElementReferenceException sere) {
            webElement = waitElementToBeClickable(webDriver.findElement(By.cssSelector(getValue(locator))));
            webElement.click();
            pass(locator, null, null, CLICK);
        } catch (Exception e) {
//            System.out.println("'" + locator + "' element is not found.");
//            logFailedSteps(locator);
            throw (e);
        }
    }

    public static void findElement(String locator) {
        try {
            webElement = webDriver.findElement(By.cssSelector(getValue(locator)));
            pass(locator, null, null, SEARCH);
        } catch (StaleElementReferenceException sere) {
            webElement = waitForElementPresent(By.cssSelector(getValue(locator)), locator);
            pass(locator, null, null, SEARCH);
        } catch (Exception e) {

            throw (e);
        }
    }

    // TODO
    public static void clickElementByContainingText(String locator, String text) {
    }

    // TODO
    public static WebElement findFirstElementByContainingText() {
        return null;
    }

    //  Method used to type into a input field
    public static void typeValue(String locator, String value) {
        try {
            webElement = webDriver.findElement(By.cssSelector(getValue(locator)));
            webElement.clear();
            webElement.sendKeys(value);
            pass(locator, value, null, TYPE);
        } catch (StaleElementReferenceException sere) {
            webElement = waitForElementPresent(By.cssSelector(getValue(locator)), locator);
            webElement.clear();
            webElement.sendKeys(value);
            pass(locator, value, null, TYPE);
        } catch (Exception e) {

            throw (e);
        }
    }


}
