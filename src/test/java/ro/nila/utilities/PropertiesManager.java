package ro.nila.utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public  class PropertiesManager {

    public static WebDriver driver;
    public static WebDriverWait driverWait;

    public static Properties uiLocators = new Properties();
    public static Properties config = new Properties();
    public static FileInputStream fis;

    public static ExtentReports report = ExtentManager.getInstance();
    public static ExtentTest test;

    // Set all properties for WebDriver, Configuration and Ui-locators
    public static void setUpProperties() {
        setupConfig();
        setUpUiLocators();
        setUpWebDriver();
    }

    // Load config.properties
    public static void setupConfig() {
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config.load(fis);
            System.out.println("Config loaded");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load ui-locators.properties
    public static void setUpUiLocators() {
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\ui-locators.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            uiLocators.load(fis);
            System.out.println("Locators loaded");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Setup browser and driver
    public static void setUpWebDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println(config.getProperty("sng9"));
        driver.get(config.getProperty("sng9"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
        driverWait = new WebDriverWait(driver, 20);

        System.out.println("Driver and Browser setUp");
    }

    // Close the WebDriver
    public static void closeWebDriver() {
        if (driver != null) {
            driver.close();

            System.out.println("Close driver");
        }
    }

    // Quit the WebDriver
    public static void quitWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Close FileInputStream
    public static void closeFis(){
        if (fis!= null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getUsername(){
        System.out.println(config.getProperty("username"));
        return config.getProperty("username");
    }

    public static String getPasswrod(){
        return config.getProperty("password");
    }

}
