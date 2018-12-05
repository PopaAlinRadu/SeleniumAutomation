package ro.nila.utilities.configuration;

import ro.nila.utilities.PropertiesManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UiElementsManager extends PropertiesManager {

    @Override
    public void loadConfiguration() throws IOException {
        super.loadConfiguration();

        System.out.println("1.Loading---> ui-locators.properties");

        ui = getUiElementsProperties();
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\ui-locators.properties")) {
            ui.load(fileInputStream);

            System.out.println("ui-elements.properties <----Loaded");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
