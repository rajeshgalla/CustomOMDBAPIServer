package com.rajesh.galla.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

    public static String getProperty(String key) {

        Resource resource = new ClassPathResource("app.properties");
        Properties props = null;
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            System.out.println("Unable to load Resources");
            e.printStackTrace();
        }

        return props.getProperty(key);
    }
}
