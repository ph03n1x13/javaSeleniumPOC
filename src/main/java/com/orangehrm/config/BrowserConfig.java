package com.orangehrm.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads browser and application configuration from config.properties.
 */
public class BrowserConfig {
    private static Properties properties = new Properties();

    // Static initializer to load properties at class load time
    static {
        try (InputStream input = BrowserConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                System.err.println("config.properties file not found in resources folder!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless", "false"));
    }

    public static String getBrowser() {
        return properties.getProperty("browser", "chrome");
    }

    public static String getLoginUrl() {
        return properties.getProperty("login.url");
    }

    public static String getDashboardUrl() {
        return properties.getProperty("dashboard.url");
    }

    public static String getDirectoryUrl() {
        return properties.getProperty("directory.url");
    }

    public static String getUser(){
        return properties.getProperty("username");
    }
    public static String getPasswd(){
        return properties.getProperty("password");
    }
}
