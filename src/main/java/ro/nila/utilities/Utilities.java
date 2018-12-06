package ro.nila.utilities;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

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
}
