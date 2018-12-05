package ro.nila.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ro.nila.utilities.PropertiesManager.*;

public class Commands {

    //  Method used to click on elements based on a locator
    public static void clickElement(String locator) {
        try {
            webElement = webDriver.findElement(By.cssSelector(getValue(locator)));
            webElement.click();
            System.out.println("Element '" + locator + "' found and clicked");
        } catch (StaleElementReferenceException sere) {
            webElement = waitElementToBeClickable(webDriver.findElement(By.cssSelector(getValue(locator))));
            webElement.click();
            System.out.println("Element '" + locator + "' found and clicked");
        } catch (Exception e) {
            System.out.println("'" + locator + "' element is not found.");
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
            webElement.sendKeys(value);
            System.out.println("Entered value: " + value + " into element: " + locator);
        } catch (StaleElementReferenceException sere) {
            webElement = waitForElementPresent(By.cssSelector(getValue(locator)));
            webElement.sendKeys(value);
            System.out.println("Entered value: " + value + " into element: " + locator);
        } catch (Exception e) {
            System.out.println(locator + " element is not found. Cannot Type into field ");
            throw (e);
        }
    }

    //  ---------------------Methods to waits for elements-----------------------

    //  Method used to wait for an element to be clickable before click on it
    protected static WebElement waitElementToBeClickable(WebElement element) {
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    //  Method used to wait for an element to have the exact text value
    protected static WebElement waitElementTextToBe(By by, String value) {
        driverWait.until(ExpectedConditions.textToBe(by, value));
        return webDriver.findElement(by);
    }

    //  Method used to wait for multiple elements to be present on the DOM
    protected static WebElement waitForElementsPresent(By by) {
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return webDriver.findElement(by);
    }

    //  Method used to wait for a single element to be present on the DOM
    public static WebElement waitForElementPresent(By by) {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        return webDriver.findElement(by);
    }

    // ----------------------------------------------------------------------

    //  Method that get the text from an WebElement
    static String getTextFromElement(WebElement webElement) {
        return webElement.getText();
    }

}
