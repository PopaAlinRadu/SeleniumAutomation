package ro.nila.base;

import org.testng.annotations.*;
import ro.nila.utilities.PropertiesManager;

import static ro.nila.utilities.PropertiesManager.*;

public abstract class TestBase {

    public static String USERNAME;
    public static String PASSWORD;

    @BeforeSuite
    public void setUpBeforeSuite(){
        System.out.println("setUpBeforeSuite");
        setupConfig();
        setUpUiLocators();
    }

    @BeforeTest
    public void setUpBeforeTest(){
        System.out.println("setUpBeforeTest");

    }

    @BeforeClass
    public void setUpBeforeClass(){
        System.out.println("setUpBeforeClass");

    }

    @BeforeMethod
    public void setUpBeforeMethod(){
        System.out.println("setUpBeforeMethod");
        USERNAME = PropertiesManager.getUsername();
        PASSWORD = PropertiesManager.getPasswrod();
        setUpWebDriver();
    }

    @AfterMethod
    public void tearDownAfterMethod(){
        System.out.println("\ntearDownAfterMethod");
        closeWebDriver();
    }

    @AfterClass
    public void tearDownAfterClass(){
        System.out.println("tearDownAfterClass");
    }

    @AfterTest
    public void tearDownAfterTest(){
        System.out.println("tearDownAfterTest");

    }

    @AfterSuite
    public void tearDownAfterSuite(){
        System.out.println("tearDownAfterSuite");
        quitWebDriver();
        closeFis();
    }
}
