package ro.nila.listeners;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ro.nila.utilities.PropertiesManager;

public class CustomListeners extends PropertiesManager implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("onTestStart");
        test = report.startTest(iTestResult.getName().toUpperCase());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(LogStatus.PASS, "Test " + iTestResult.getName().toUpperCase() + " passed");
        report.endTest(test);
        report.flush();
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
