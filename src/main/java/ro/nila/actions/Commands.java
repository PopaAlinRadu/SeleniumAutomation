package ro.nila.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ro.nila.utilities.PropertiesManager.*;

public class Commands extends CommonActions {

    //  Method used to click on elements based on a locator
    public static void clickElement(String locator) {
        try {
            webElement = webDriver.findElement(By.cssSelector(getValue(locator)));
            webElement.click();
            logSteps(locator);
        } catch (StaleElementReferenceException sere) {
            webElement = waitElementToBeClickable(webDriver.findElement(By.cssSelector(getValue(locator))));
            webElement.click();
            logSteps(locator);
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



}
