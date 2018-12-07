package ro.nila.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.util.Properties;

public abstract class PropertiesManager {

    public static WebElement webElement;
    public static WebDriver webDriver;
    public static Wait driverWait;
    public static Properties config, ui, txt;


    /*
    //  Implementation in subclasses to load:
    //  1. WebDriver
    //  2. WebDriverWait
    //  3. Properties and FileInputStream
    //  4. ExtentReports and ExtentTest
     */
    public void loadConfiguration() throws IOException {
        System.out.println("Loading Configuration");
    }

    public static Properties getUiElementsProperties() {
        if (ui == null) {
            ui = new Properties();
        }
        return ui;

    }

    public static Properties getConfigProperties() {
        if (config == null) {
            config = new Properties();
        }
        return config;
    }

    public static String getValue(String key) {
        String value;
        if (key.contains("ui")) {
            value = ui.getProperty(key);
        } else if (key.contains("txt")) {
            value = txt.getProperty(key);
        } else if(key.contains("config")) {
            value = config.getProperty(key);
        } else {
            value = key;
        }
        return value;
    }

    public static void closeWebDriver() {
        if (webDriver != null) {
            webDriver.close();
            System.out.println("Close driver");
        }
    }

    public static void quitWebDriver() {
        if (webDriver != null) {
            webDriver.quit();
            System.out.println("Quit driver");
        }
    }
}
