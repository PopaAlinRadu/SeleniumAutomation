package ro.nila.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ro.nila.business.Actions;
import ro.nila.business.ElementsState;

import static ro.nila.business.Actions.*;
import static ro.nila.business.ElementsState.*;
import static ro.nila.utilities.PropertiesManager.*;
import static ro.nila.utilities.Utilities.*;

public abstract class CommonActions {

    //  ---------------------Methods to wait for elements-------------------------------------------//

    //  Method used to wait for a single element to be present on the DOM
    protected static WebElement waitForElementPresent(By by, String locator) {
        try {
            driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
            webElement = webDriver.findElement(by);
            return webElement;
        } catch (Exception e) {
            fail(locator, null, null, SEARCH);
        }
        return null;
    }

    //  Method used to wait for an element to be clickable before click on it
    protected static WebElement waitElementToBeClickable(By by, String locator) {
        try {
            driverWait.until(ExpectedConditions.elementToBeClickable(by));
            webElement = webDriver.findElement(by);
            webElement.click();
            return webElement;
        } catch (Exception e) {
            fail(locator, null, null, CLICK);
        }
        return null;
    }

    //  Method used to wait for an element to be present before type in it
    protected static WebElement waitElementToType(By by, String locator, String value) {
        String element = "";
        try {
            webElement = (WebElement) driverWait.until(ExpectedConditions.presenceOfElementLocated(by)
                    .andThen(
                            webElement -> webElement = webDriver.findElement(by))
            );
//            webElement = webDriver.findElement(by);
            try {
                element = "found";
                webElement.clear();
                webElement.sendKeys(value);
            } catch (Exception e) {
                fail(locator, null, element, TYPE);
            }
            return webElement;
        } catch (Exception e) {
            element = "not found";
            fail(locator, null, element, TYPE);
        }
        return null;
    }

    //  Method used to wait for the URL to be fully loaded
    protected static void waitForUrl(String expectedUrl) {
        String actualUrl;
        try {
            driverWait.until(ExpectedConditions.urlToBe(expectedUrl));
            actualUrl = webDriver.getCurrentUrl();
            pass(null, expectedUrl, actualUrl, COMPARE_URL);
        } catch (Exception e) {
            actualUrl = webDriver.getCurrentUrl();
            fail(null, expectedUrl, actualUrl, COMPARE_URL);
        }
    }

    //  Method used to wait for an element to have the exact text value
    protected static void waitElementTextToBe(By by, String expectedText, String locator) {
        String actualText = "";
        try {
            //  Wait for element to be present or throw Exception that element not found
            waitForElementPresent(by, locator);
            actualText = webDriver.findElement(by).getText();
            //  Wait for element text to be equal with expectedText
            driverWait.until(ExpectedConditions.textToBe(by, expectedText));
            pass(locator, expectedText, actualText, COMPARE_TEXT);
        } catch (Exception e) {
            fail(locator, expectedText, actualText, COMPARE_TEXT);
        }
    }

    protected static void waitElementState(String locator, ElementsState elementsState) {
        webElement = waitForElementPresent(By.cssSelector(getValue(locator)), locator);
        switch (elementsState) {
            case ENABLED:
                if (webElement.isEnabled())
                    pass(locator, ENABLED.getState() , ENABLED.getState(), STATE);
                else
                    fail(locator, ENABLED.getState(), ENABLED.getOppositeState(), STATE);
                break;
            case DISABLED:
                if (!webElement.isEnabled())
                    pass(locator, DISABLED.getState(), DISABLED.getState(), STATE);
                else
                    fail(locator, DISABLED.getState(), DISABLED.getOppositeState(), STATE);
                break;
            case DISPLAYED:
                if (webElement.isDisplayed())
                    pass(locator, DISPLAYED.getState() , DISPLAYED.getState(), STATE);
                else
                    fail(locator, DISPLAYED.getState(), DISPLAYED.getOppositeState(), STATE);
                break;
            case HIDDEN:
                if (!webElement.isDisplayed())
                    pass(locator, HIDDEN.getState(), HIDDEN.getState(), STATE);
                else
                    fail(locator, HIDDEN.getState(), HIDDEN.getOppositeState(), STATE);
                break;
            case SELECTED:
                if (webElement.isSelected())
                    pass(locator, SELECTED.getState() , SELECTED.getState(), STATE);
                else
                    fail(locator, SELECTED.getState(), SELECTED.getOppositeState(), STATE);
                break;
            case DESELECTED:
                if (!webElement.isSelected())
                    pass(locator, DESELECTED.getState(), DESELECTED.getState(), STATE);
                else
                    fail(locator, DESELECTED.getState(), DESELECTED.getOppositeState(), STATE);
                break;
        }
    }


    // ----------------------------------Pass and Fail methods-------------------------------------------//
    protected static void pass(String locator, String expectedValue, String actualValue, Actions action) {
        logSuccessSteps(locator, expectedValue, actualValue, action);
        writeSteps(locator, expectedValue, actualValue, action);
    }

    protected static void fail(String locator, String expectedValue, String actualValue, Actions action) {
        logFailedSteps(locator, expectedValue, actualValue, action);
        writeError(locator, expectedValue, actualValue, action);
    }

}
