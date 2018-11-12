package ro.nila.tests;

import org.testng.annotations.Test;
import ro.nila.base.TestBase;

public class FirstTest extends TestBase {

    @Test
    public void firstTest(){
        System.out.println("\nInside the test\n");
    }
}
