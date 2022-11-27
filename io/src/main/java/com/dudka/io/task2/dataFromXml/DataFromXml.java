package com.dudka.io.task2.dataFromXml;

import com.dudka.io.Main;
import com.dudka.io.task2.entity.Fine;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DataFromXml {
    private static final List<Fine> fines = new ArrayList<>();

    public static List<Fine> parser(String pathToFile) throws ParserConfigurationException, URISyntaxException, IOException, SAXException, ParseException {
        SAXParserFactory factorySax = SAXParserFactory.newInstance();
        SAXParser parser = factorySax.newSAXParser();
        XMLHandler handler = new XMLHandler();
        ClassLoader classloader = Main.class.getClassLoader();
        URL url = classloader.getResource(pathToFile);

        parser.parse(new File(Objects.requireNonNull(url).toURI()), handler);
        System.out.println(Arrays.toString(fines.toArray()));
        return fines;
    }

    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startDocument() throws SAXException {

        }

        @Override
        public void endDocument() throws SAXException {

        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("fine")) {
                String type = attributes.getValue("type");
                Double fineAmount = Double.valueOf(attributes.getValue("fine_amount"));
                fines.add(new Fine(type, fineAmount));
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

        }

        @Override
        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

        }
    }
}
