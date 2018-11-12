package ro.nila.base;

import org.testng.annotations.*;

public abstract class TestBase {


    @BeforeSuite
    public void setUpBeforeSuite(){
        System.out.println("setUpBeforeSuite");
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
    }

    @AfterMethod
    public void tearDownAfterMethod(){
        System.out.println("tearDownAfterMethod");
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
    }
}
