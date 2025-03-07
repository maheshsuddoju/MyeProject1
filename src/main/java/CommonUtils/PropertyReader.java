package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;

    // Load properties file
    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    // Get property by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
