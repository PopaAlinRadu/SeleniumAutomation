package ro.nila.business;

import static ro.nila.utilities.PropertiesManager.getValue;

public class Account {

    public String username;
    public String password;
    public String firstName;
    public String secondName;

    public Account(){
        this.username = getValue("txt.lf.username");
        this.password = getValue("txt.lf.password");
        this.firstName = getValue("txt.lf.firstName");
        this.secondName = getValue("txt.lf.secondName");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
