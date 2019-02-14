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

    //  ---------------------Method that chose between logger or extent reports-----------------------

    public static void logSuccessSteps(String locator, String checkpointName, String value) {
        if (checkpointName == null) {
            if (test != null) {
                test.log(LogStatus.PASS, "-> Element " + locator + " found and clicked");
            } else {
                // TODO - implement logger
                System.out.println("Log-> Element '" + locator + "' found and clicked");
            }
        } else {
            if (test != null) {
                if (locator == null) {
                    test.log(LogStatus.PASS, "-> Expected URL equals: " + checkpointName);
                } else {
                    test.log(LogStatus.PASS, "-> Element " + locator + " contains: " + checkpointName);
                }
            } else {
                // TODO - implement logger
                System.out.println("Log-> Element '" + locator + "' contains: " + checkpointName);
            }
        }
    }

    public static void updatedLogSuccessSteps(String locator, String expectedValue, String actualValue, Actions action) {

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
        } else {
            //TODO just write in console
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
                    test.log(LogStatus.FAIL, "Element [" + locator + "] not found. Couldn't type value");
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
        } else {
            //TODO just write in console
        }
    }
}
