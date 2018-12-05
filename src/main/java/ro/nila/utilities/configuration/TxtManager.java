package ro.nila.utilities.configuration;

import ro.nila.utilities.PropertiesManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TxtManager extends PropertiesManager {

    @Override
    public void loadConfiguration() throws IOException {
        super.loadConfiguration();

        System.out.println("3.Loading---> txt.properties");

        txt = getUiElementsProperties();
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\txt.properties")) {
            txt.load(fileInputStream);
            System.out.println("txt.properties <----Loaded");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
