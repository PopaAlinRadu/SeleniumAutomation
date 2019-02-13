package ro.nila.actions;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ro.nila.base.TestBase.test;
import static ro.nila.utilities.PropertiesManager.*;

public abstract class CommonActions {

    //  ---------------------Method that chose between logger or extent reports-----------------------

    protected static void logSteps(String locator){
        if(test != null){
            System.out.println("LoggerInfo: inside test not null should log in extent");
            test.log(LogStatus.INFO, "-> Element " + locator + " found and clicked");
        } else{
            // TODO - implement logger
            System.out.println("LoggerInfo: inside test equal null should write in console");
            System.out.println("-> Element '" + locator + "' found and clicked");
        }
    }

    //  ---------------------Methods to waits for elements-------------------------------------------

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

    //  Method used to wait for the URL to be fully loaded
    public static void waitForUrl(String url) {
        driverWait.until(ExpectedConditions.urlToBe(getValue(url)));
    }

    //  ---------------------Methods TODO -------------------------------------------

    //  Method that get the text from an WebElement
    static String getTextFromElement(WebElement webElement) {
        return webElement.getText();
    }
}
