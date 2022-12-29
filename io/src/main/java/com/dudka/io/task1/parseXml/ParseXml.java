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
             FileWriter writer = new FileWriter("persons.xml")) {

            Scanner scanner = new Scanner(Objects.requireNonNull(inputStream), "UTF-8");
            scanner.useDelimiter("(?<=>)");

            Pattern lastnamePattern = Pattern.compile("(?<=surname=\")[^\"]+");
            Pattern firstNamePattern = Pattern.compile("\\s*(?<=\\bname=\")[^\"]+");

            while (scanner.hasNext()) {
                String line = scanner.next();

                Matcher matcherLastname = lastnamePattern.matcher(line);
                Matcher matcherFirstName = firstNamePattern.matcher(line);

                if (!line.contains("name")) {
                    writer.write(line);
                } else if (matcherLastname.find() && matcherFirstName.find()) {
                    String lastname = matcherLastname.group();
                    String firstname = matcherFirstName.group();

                    String result = line
                            .replaceAll("(?<=\\bname=\")[^\"]+", firstname + " " + lastname)
                            .replaceAll("(\\s*\\bsurname\\s*=\\s*\")[^\"]+[\"^]+", " ");

                    writer.write(result);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}





