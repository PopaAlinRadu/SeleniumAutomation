package ro.nila.utilities.configuration;

import ro.nila.utilities.PropertiesManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigManager extends PropertiesManager {


    @Override
    public void loadConfiguration() throws IOException {
        super.loadConfiguration();

        System.out.println("2.Loading---> configuration.properties");

        config = getConfigProperties();
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\config.properties")) {
            config.load(fileInputStream);
            System.out.println("configuration.properties <----Loaded");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
