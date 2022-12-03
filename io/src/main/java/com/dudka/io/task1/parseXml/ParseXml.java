package com.dudka.io.task1.parseXml;

import com.dudka.io.Main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseXml {
    public static void parseXmlWithPersons() {
        try (InputStream inputStream = Main.class.getResourceAsStream("/persons/person.xml");
             FileWriter myWriter = new FileWriter("persons.xml")) {
            Scanner scanner = new Scanner(Objects.requireNonNull(inputStream), "UTF-8");

            scanner.useDelimiter("(?<=>)");
            if (scanner.hasNext()) {
                while (scanner.hasNext()) {
                    StringBuilder stringBuilder = new StringBuilder(scanner.next());

                    Matcher matcherLastname = Pattern.compile("(?<=surname=\")[^\"]+").matcher(stringBuilder.toString());
                    Matcher matcherFirstName = Pattern.compile("\\s*(?<=\\bname=\")[^\"]+").matcher(stringBuilder.toString());

                    if (!stringBuilder.toString().contains("name")) {
                        myWriter.write(String.valueOf(stringBuilder));
                    } else if (matcherLastname.find() && matcherFirstName.find()) {
                        String lastname = matcherLastname.group();
                        String firstname = matcherFirstName.group();

                        stringBuilder = new StringBuilder(stringBuilder.toString().replaceAll("(?<=\\bname=\")[^\"]+", firstname + " " + lastname));
                        stringBuilder = new StringBuilder(stringBuilder.toString().replaceAll("(\\s*\\bsurname\\s*=\\s*\")[^\"]+[\"^]+", " "));

                        myWriter.write(String.valueOf(stringBuilder));
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}





