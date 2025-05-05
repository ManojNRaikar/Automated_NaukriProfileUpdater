package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream fileInput = new FileInputStream("src/test/resources/config/config.properties");
            properties.load(fileInput);
            fileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("❌ config.properties file not found!");
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
