package ro.nila.actions;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ro.nila.business.Actions;

import static ro.nila.base.TestBase.test;
import static ro.nila.business.Actions.*;
import static ro.nila.utilities.PropertiesManager.*;
import static ro.nila.utilities.Utilities.logFailedSteps;
import static ro.nila.utilities.Utilities.updatedLogSuccessSteps;

public abstract class CommonActions {

    //  ---------------------Methods to waits for elements-------------------------------------------

    //  Method used to wait for an element to be clickable before click on it
    protected static WebElement waitElementToBeClickable(WebElement element) {
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    //  Method used to wait for an element to have the exact text value
    protected static WebElement waitElementTextToBe(By by, String expectedText) {
            driverWait.until(ExpectedConditions.textToBe(by, expectedText));
            webElement = webDriver.findElement(by);
            return webElement;
    }

    //  Method used to wait for multiple elements to be present on the DOM
    protected static WebElement waitForElementsPresent(By by) {
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return webDriver.findElement(by);
    }

    //  Method used to wait for a single element to be present on the DOM
    public static WebElement waitForElementPresent(By by, String locator) {
        try {
            driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
            return webDriver.findElement(by);
        } catch (Exception e){
            fail(locator, null, null, SEARCH);
            return null;
        }
    }

    //  Method used to wait for the URL to be fully loaded
    public static void waitForUrl(String expectedUrl, String actualUrl) {
        try {
            driverWait.until(ExpectedConditions.urlToBe(expectedUrl));
        } catch (Exception e){
            fail(null,expectedUrl, actualUrl, COMPARE_URL);
        }
    }

    //  ---------------------Methods TODO -------------------------------------------

    //  Method that get the text from an WebElement
    static String getTextFromElement(WebElement webElement) {
        return webElement.getText();
    }

    // --------------------
    protected static void pass(String locator, String expectedValue, String actualValue, Actions action) {
        updatedLogSuccessSteps(locator, expectedValue, actualValue, action);
    }

    protected static void fail(String locator, String expectedValue, String actualValue, Actions action) {
        logFailedSteps(locator, expectedValue, actualValue, action);
        switch (action) {
            case SEARCH:
                assert false : "Element [" + locator + "] not found";
                break;
            case CLICK:
                assert false : "Element [" + locator + "] not found. Couldn't clicked on element";
                break;
            case TYPE:
                assert false : "Element [" + locator + "] not found. Couldn't type value";
                break;
            case COMPARE_TEXT:
                assert false : "Element [" + locator + "].Expected text: [" + expectedValue + "] actual text: [" + actualValue + "]";
                break;
            case COMPARE_URL:
                assert false : "Expected URL: [" + expectedValue + "] actual URL: [" + actualValue + "]";
                break;
            case STATE:
                assert false : "Element [" + locator + "]. Expected state: [" + expectedValue + "] actual state: [" + actualValue + "]";
                break;
        }
    }

}
