package ro.nila.utilities.configuration;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import ro.nila.utilities.PropertiesManager;

import java.io.File;
import java.io.IOException;

public class ExtentManager extends PropertiesManager{

    public static ExtentReports getInstance(){
        if (report == null){
            report = new ExtentReports(System.getProperty("user.dir") + "\\target\\extent-report\\extent.html",true, DisplayOrder.OLDEST_FIRST);
            report.loadConfig(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\extentconfig\\reportsConfig.xml"));
        }
        return report;
    }
}
