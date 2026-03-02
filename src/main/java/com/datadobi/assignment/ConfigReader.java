package com.datadobi.assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


// Util to read Application Properties so we can set the desired root path outside of the code
// as a configuration variable instead of hardcoded
public class ConfigReader {

    private static final Properties props = new Properties();

    static {
        try (InputStream input = new FileInputStream("application.properties")) {
            props.load(input);
        } catch (IOException e) {
            System.err.println("Failed to read application.properties: " + e.getMessage());
        }
    }

    // Helper method to get a property
    public static String get(String key) {
        return props.getProperty(key);
    }
}
