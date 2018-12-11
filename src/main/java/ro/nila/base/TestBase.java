package ro.nila.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
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
import static ro.nila.utilities.configuration.ExtentManager.report;

public class TestBase implements ITestListener {


    private static PropertiesManager uiElementsManager, txtManager, configManager, webDriverManager;
    private static ExtentReports reports;
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

    //ITestListener interface methods
    //---------------------------------------------------------------//
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart ");
        test = report.startTest(iTestResult.getInstanceName());
        test.log(LogStatus.PASS, "Starting test: " + iTestResult.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSucces");
        test.log(LogStatus.PASS, "Ended Test: " + iTestResult.getMethod().getMethodName() + " passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure");
        test.log(LogStatus.FAIL, "Ended Test: " + iTestResult.getMethod().getMethodName() + " failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped");
        test.log(LogStatus.SKIP, "Ended Test: " + iTestResult.getMethod().getMethodName() + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        //  Do nothing yet
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish");
        report.endTest(test);
        report.flush();
    }

}
