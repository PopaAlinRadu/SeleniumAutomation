package ro.nila.utilities;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Commands extends PropertiesManager {

    public static void clickElement(String locator) {

        driverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(uiLocators.getProperty(locator))));
        driver.findElement(By.cssSelector(uiLocators.getProperty(locator))).click();
        if (test == null) {
            test = report.startTest(Thread.currentThread().getName().toUpperCase());
        } else {
            test.log(LogStatus.INFO, "Clicked on element: " + locator);
        }
    }

}
