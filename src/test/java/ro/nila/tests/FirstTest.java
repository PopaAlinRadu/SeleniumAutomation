package ro.nila.tests;

import org.testng.annotations.Test;
import ro.nila.base.TestBase;
import ro.nila.utilities.Commands;

public class FirstTest extends TestBase {

    @Test
    public void firstTest(){
        System.out.println("\nInside FIRST test\n");
        Commands.clickElement("ui.lf.landingPage.loginButton.css");
    }
}
