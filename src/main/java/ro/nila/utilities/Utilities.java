package ro.nila.utilities;

import com.relevantcodes.extentreports.LogStatus;
import ro.nila.business.Actions;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

import static ro.nila.base.TestBase.test;

public class Utilities {

    public static String getTestName(Method[] methods) {
        String testName;
        int numberOfMethods;
        numberOfMethods = methods.length;

        if (numberOfMethods % 2 != 0) {
            // daca nr de metode = 1, 3, 5, 7
            testName = Array.get(methods, 0).toString();
            testName = testName.substring(11, Array.get(methods, 0).toString().length() - 2);
            return testName;
        } else {
            // daca nr de metode = 2, 4, 6, 8
            testName = Array.get(methods, 1).toString();
            testName = testName.substring(11, Array.get(methods, 1).toString().length() - 2);
            return testName;
        }
    }

    //  -------------------------------------Method that write in extent reports-----------------------------------------------//

    public static void logSuccessSteps(String locator, String expectedValue, String actualValue, Actions action) {
        if (test != null) {
            switch (action) {
                case SEARCH:
                    test.log(LogStatus.PASS, "Element [" + locator + "] found");
                    break;
                case CLICK:
                    test.log(LogStatus.PASS, "Element [" + locator + "] found and clicked");
                    break;
                case TYPE:
                    test.log(LogStatus.PASS, "Element [" + locator + "] found and typed value: [" + expectedValue + "]");
                    break;
                case COMPARE_TEXT:
                    test.log(LogStatus.PASS, "Element [" + locator + "] found. Compared: [" + expectedValue + "] with: [" + actualValue + "]");
                    break;
                case COMPARE_URL:
                    test.log(LogStatus.PASS, "Expected URL: [" + expectedValue + "] equal actual URL: [" + actualValue + "]");
                    break;
                case STATE:
                    test.log(LogStatus.PASS, "Element [" + locator + "] found. Expected state: [" + expectedValue + "] equal actual state: [" + actualValue + "]");
                    break;
            }
        }
    }

    public static void logFailedSteps(String locator, String expectedValue, String actualValue, Actions action) {
        if (test != null) {
            switch (action) {
                case SEARCH:
                    test.log(LogStatus.FAIL, "Element [" + locator + "] not found");
                    break;
                case CLICK:
                    test.log(LogStatus.FAIL, "Element [" + locator + "] not found. Couldn't clicked on element");
                    break;
                case TYPE:
                    test.log(LogStatus.FAIL, "Element [" + locator + "] " + actualValue + ". Couldn't type value");
                    break;
                case COMPARE_TEXT:
                    test.log(LogStatus.FAIL, "Element [" + locator + "].Expected text: [" + expectedValue + "] actual text: [" + actualValue + "]");
                    break;
                case COMPARE_URL:
                    test.log(LogStatus.FAIL, "Expected URL: [" + expectedValue + "] actual URL: [" + actualValue + "]");
                    break;
                case STATE:
                    test.log(LogStatus.FAIL, "Element [" + locator + "]. Expected state: [" + expectedValue + "] actual state: [" + actualValue + "]");
                    break;
            }
        }
    }

    //  -------------------------------------Method that write in console-----------------------------------------------//
    public static void writeSteps(String locator, String expectedValue, String actualValue, Actions action) {
        switch (action) {
            case SEARCH:
                System.out.println("Element [" + locator + "] found");
                break;
            case CLICK:
                System.out.println("Element [" + locator + "] found and clicked");
                break;
            case TYPE:
                System.out.println("Element [" + locator + "] found and typed value: [" + expectedValue + "]");
                break;
            case COMPARE_TEXT:
                System.out.println("Element [" + locator + "] found. Compared: [" + expectedValue + "] with: [" + actualValue + "]");
                break;
            case COMPARE_URL:
                System.out.println("Expected URL: [" + expectedValue + "] equal actual URL: [" + actualValue + "]");
                break;
            case STATE:
                System.out.println("Element [" + locator + "] found. Expected state: [" + expectedValue + "] equal actual state: [" + actualValue + "]");
                break;
        }
    }

    public static void writeError(String locator, String expectedValue, String actualValue, Actions action) {
        switch (action) {
            case SEARCH:
                assert false : "Element [" + locator + "] not found.";
                break;
            case CLICK:
                assert false : "Element [" + locator + "] not found. Couldn't clicked on element.";
                break;
            case TYPE:
                assert false : "Element [" + locator + "] " + actualValue + ". Couldn't type value.";
                break;
            case COMPARE_TEXT:
                assert false : "Element [" + locator + "].Expected text: [" + expectedValue + "] actual text: [" + actualValue + "].";
                break;
            case COMPARE_URL:
                assert false : "Expected URL: [" + expectedValue + "] actual URL: [" + actualValue + "].";
                break;
            case STATE:
                assert false : "Element [" + locator + "]. Expected state: [" + expectedValue + "] actual state: [" + actualValue + "].";
                break;
        }
    }


}
