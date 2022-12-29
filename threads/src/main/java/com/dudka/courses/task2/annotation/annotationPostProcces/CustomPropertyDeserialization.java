package com.dudka.courses.task2.annotation.annotationPostProcces;

import com.dudka.courses.task2.annotation.CustomProperty;
import com.dudka.courses.task2.exceptions.CustomPropertyAnnotationException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Logger;

public class CustomPropertyDeserialization {
    public static Object loadFromProperty(Object obj, String path) {
        Class<?> clazz = obj.getClass();
        try (InputStream inputStream = Files.newInputStream(Paths.get(path))) {

            Properties prop = new Properties();
            prop.load(inputStream);

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(CustomProperty.class)) {

                    try {
                        if (prop.getProperty(getKey(field)).equals("")) {
                            throw new IllegalArgumentException();
                        }

                        if (field.getType().equals(Instant.class)) {
                            field.set(obj, LocalDateTime.parse(prop.getProperty(getKey(field)), DateTimeFormatter
                                            .ofPattern(field.getAnnotation(CustomProperty.class).dateFormat()))
                                    .toInstant(ZoneOffset.UTC));

                        } else if (field.getType().equals(String.class)) {
                            field.set(obj, prop.getProperty(getKey(field)));

                        } else if (field.getType().equals(int.class)
                                || field.getType().equals(Integer.class)) {
                            field.set(obj, Integer.parseInt(prop.getProperty(getKey(field))));

                        } else {
                            throw new CustomPropertyAnnotationException(
                                    "Provided type of field is not completable with current field type " + field.getType().getName());
                        }
                    } catch (CustomPropertyAnnotationException e) {
                        Logger.getAnonymousLogger().warning(e.getMessage());
                        throw new CustomPropertyAnnotationException("Cannot map object properties from file");
                    } catch (IllegalAccessException e) {
                        Logger.getAnonymousLogger().warning(e.getMessage());
                        throw new CustomPropertyAnnotationException("Cannot map object properties from file");
                    } catch (IllegalArgumentException e) {
                        Logger.getAnonymousLogger().warning(e.getMessage());
                        throw new IllegalArgumentException("Property: " + getKey(field) + " has an invalid value");
                    }
                }
            }
        } catch (IOException exception) {
            Logger.getAnonymousLogger().warning("couldn't find provided file " + exception.getMessage());

        }
        return obj;
    }

    private static String getKey(Field field) {
        CustomProperty customProperty = field.getAnnotation(CustomProperty.class);
        String key = customProperty.name();
        if (key.equals("")) {
            return field.getName();
        } else {
            return key;
        }
    }

}
