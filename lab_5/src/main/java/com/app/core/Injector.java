package com.app.core;

import com.app.annotation.AutoInjectable;
import java.lang.reflect.Field;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class Injector {
    private Properties properties;

    public Injector(String configFileName) {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(configFileName)) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("File " + configFileName + " not found in classpath");
            }
        } catch (IOException error) {
            throw new RuntimeException("Error loading settings file", error);
        }
    }

    public <T> T inject(T object) {
        Class<?> clazz = object.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(AutoInjectable.class)) {
                Class<?> fieldType = field.getType();
                String implementationClassName = properties.getProperty(fieldType.getName());

                if (implementationClassName == null) {
                    throw new RuntimeException("No implementation found for interface " + fieldType.getName());
                }

                try {
                    Object implementationInstance = Class.forName(implementationClassName).getDeclaredConstructor()
                            .newInstance();
                    field.setAccessible(true);
                    field.set(object, implementationInstance);
                } catch (Exception error) {
                    throw new RuntimeException("Error injecting dependency", error);
                }
            }
        }

        return object;
    }
}