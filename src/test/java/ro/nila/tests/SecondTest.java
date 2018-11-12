package ro.nila.tests;

import org.testng.annotations.Test;
import ro.nila.base.TestBase;
import ro.nila.utilities.Commands;


public class SecondTest extends TestBase {

    @Test
    public void SecondTest(){
        System.out.println("\nInside SECOND test\n");
        Commands.clickElement("ui.lf.landingPage.loginButton.css");
    }
}
