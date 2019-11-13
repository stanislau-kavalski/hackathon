package com.applitools.hackathon.task.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/13/2019
 *
 * @author Stanislau Kavalski
 */
public class PropertiesProvider {
    private PropertiesProvider() {
        throw new AssertionError("Should never be instantiated.");
    }

    static final Properties properties;

    static {
        properties = new Properties();
        load();
    }

    private static void load() {
        try {
            InputStream is =
                PropertiesProvider.class.getClassLoader().getResourceAsStream(System.getProperty("testProperty"));
            properties.load(is);
        } catch (IOException e) {
            throw new AssertionError("Can't load properties from file: " + System.getProperty("testProperty"), e);
        }

    }

    public static String getAppUrl() {
        return properties.getProperty("host");
    }

    public static String getDynamicAppUrl() {
        return properties.getProperty("dynamicHost");
    }
}
