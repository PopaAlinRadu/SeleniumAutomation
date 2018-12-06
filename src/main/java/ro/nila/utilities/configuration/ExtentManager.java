package ro.nila.utilities.configuration;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;


public class ExtentManager {

    public static ExtentReports report;


    public static ExtentReports getInstance(){
        if (report == null){
            report = new ExtentReports(System.getProperty("user.dir") + "\\target\\extent-report\\extent.html",true, DisplayOrder.OLDEST_FIRST);
            report.loadConfig(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\extentconfig\\reportsConfig.xml"));
        }
        return report;
    }
}
