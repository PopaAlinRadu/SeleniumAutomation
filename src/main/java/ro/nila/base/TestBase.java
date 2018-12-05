package ro.nila.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ro.nila.utilities.PropertiesManager;
import ro.nila.utilities.configuration.ConfigManager;
import ro.nila.utilities.configuration.TxtManager;
import ro.nila.utilities.configuration.UiElementsManager;
import ro.nila.utilities.configuration.WebDriverManager;

import java.io.IOException;

import static ro.nila.utilities.PropertiesManager.closeWebDriver;
import static ro.nila.utilities.PropertiesManager.quitWebDriver;

public abstract class TestBase implements ITestListener {


    public static PropertiesManager uiElementsManager, txtManager, configManager, webDriverManager, report, test;

    static{
        configManager = new ConfigManager();
        txtManager = new TxtManager();
        uiElementsManager = new UiElementsManager();
        webDriverManager = new WebDriverManager();
    }

    // Needs to contain:
    // Initialize Configuration - (config.properties) + (ui.properties) + (WebDriver) + (ExtentReports) + (ExtentTest)
    // Annotation from TestNG
    @BeforeSuite
    public void beforeSuite() throws IOException {
        uiElementsManager.loadConfiguration();
        txtManager.loadConfiguration();
        configManager.loadConfiguration();
    }

    @BeforeMethod
    public void beforeMethod() throws IOException{
        webDriverManager.loadConfiguration();
    }

    @AfterMethod
    public void tearDownAfterMethod(){
        closeWebDriver();
    }

    @AfterSuite
    public void tearDownAfterSuite(){
        quitWebDriver();
    }

    // Methods from ITestListener interface
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart ");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("onTestSucces");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("onTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("onStart");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("onFinish");
    }
}
