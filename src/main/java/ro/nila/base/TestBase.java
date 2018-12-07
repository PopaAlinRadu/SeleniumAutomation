package ro.nila.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.annotations.*;
import ro.nila.utilities.PropertiesManager;
import ro.nila.utilities.configuration.ConfigManager;
import ro.nila.utilities.configuration.TxtManager;
import ro.nila.utilities.configuration.UiElementsManager;
import ro.nila.utilities.configuration.WebDriverManager;

import java.io.IOException;

import static ro.nila.utilities.PropertiesManager.closeWebDriver;
import static ro.nila.utilities.PropertiesManager.quitWebDriver;
import static ro.nila.utilities.configuration.ExtentManager.getInstance;

public class TestBase {


    public static PropertiesManager uiElementsManager, txtManager, configManager, webDriverManager;
    public static ExtentReports reports;
    public static ExtentTest test;


    static {
        configManager = new ConfigManager();
        txtManager = new TxtManager();
        uiElementsManager = new UiElementsManager();
        webDriverManager = new WebDriverManager();
    }

    /*
     - Initialize Configuration :
        - config.properties
        - ui.properties
        - txt.properties
        - WebDriver
        - ExtentReports
        - ExtentTest -> in subclass
     - Annotation from TestNG
     */

    @BeforeSuite
    public void beforeSuite() throws IOException {
        uiElementsManager.loadConfiguration();
        txtManager.loadConfiguration();
        configManager.loadConfiguration();
        reports = getInstance();
    }

    @BeforeClass()
    public void beforeClass() {
        init();
    }

    @BeforeMethod
    public void beforeMethod() throws IOException {
        webDriverManager.loadConfiguration();
    }

    @AfterMethod
    public void tearDownAfterMethod() {
        closeWebDriver();
    }

    @AfterSuite
    public void tearDownAfterSuite() {
        quitWebDriver();
    }

    /*
    Method that will run before each testMethod
    to make setup for the test
     */
    public void init() {
        // to be overridden in subclasses
    }
}
