package ro.nila.utilities;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ro.nila.utilities.PropertiesManager.*;

public class Commands{

    /*
    Method that click on a specify element
    @param locator - element to clicked
     */
    public static void clickElement(String locator) {

        waitElementToBeClickable(locator);
        driver.findElement(By.cssSelector(uiLocators.getProperty(locator))).click();
        if (test == null) {
            //TODO
            System.out.println("Clicked on element: " + locator);
        } else {
            test.log(LogStatus.INFO, "Clicked on element: " + locator);
        }
    }

    /*
    TypeValue -  Method that type @value into a input field represented by @locator
    @param locator - element that contain the input field
    @param value - value to be passed into the input field
     */
    public static void typeValue(String locator, String value) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(uiLocators.getProperty(locator))));
        driver.findElement(By.cssSelector(uiLocators.getProperty(locator))).sendKeys(value);
        if (test == null) {
            //TODO
            System.out.println("Typing into: " + locator + "value: " + value);
        } else {
            test.log(LogStatus.INFO, "Typing into: " + locator + "value: " + value);
        }

    }

    /*
    elementToBeClickable -  Method that is used to wait for elements to be visible and enabled before we used them
    @param locator - element to be checked
     */
    public static void waitElementToBeClickable(String locator) {
        driverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(uiLocators.getProperty(locator))));
    }



}
