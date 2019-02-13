package ro.nila.utilities.configuration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import ro.nila.utilities.PropertiesManager;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class WebDriverManager extends PropertiesManager {

    @Override
    public void loadConfiguration() throws IOException {
        super.loadConfiguration();

        System.out.println("3.Loading---> WebDriver");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().deleteAllCookies();
        webDriver.get(getValue("config.application.url"));
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Integer.parseInt(getValue("config.driver.wait")), TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(Integer.parseInt(getValue("config.driver.wait")), TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(getValue("config.driver.wait")), TimeUnit.SECONDS);
        driverWait = new WebDriverWait(webDriver, Integer.parseInt(getValue("config.driver.wait")),5000);

        System.out.println("WebDriver <----Loaded");
    }
}
