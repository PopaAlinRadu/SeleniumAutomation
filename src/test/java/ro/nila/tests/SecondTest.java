package ro.nila.tests;

import org.testng.annotations.Test;
import ro.nila.actions.Checkpoints;
import ro.nila.actions.Commands;
import ro.nila.base.TestBase;
import ro.nila.business.Account;

import static ro.nila.utilities.Utilities.getTestName;

public class SecondTest extends TestBase {

    Account account;
    String fullName;

    @Override
    public void init() {
        account = new Account();
        fullName = (account.getFirstName() + " " + account.getSecondName());
    }

    @Test(description = "Check that can login with valid credential and not with invalid")
    public void testToCheckLogin() {
        System.out.println("----> INSIDE TEST: " + getTestName(this.getClass().getDeclaredMethods()) + " <----");

        //  STEPS:


        System.out.println("---> TEST FINISHED <---");
    }
}
