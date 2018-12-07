package ro.nila.utilities;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ro.nila.base.TestBase;

import static ro.nila.utilities.configuration.ExtentManager.report;

public class CustomListener extends TestBase implements ITestListener{

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
