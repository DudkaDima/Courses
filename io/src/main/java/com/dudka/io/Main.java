package com.dudka.io;

import com.dudka.io.task1.parseXml.ParseXml;
import com.dudka.io.task2.dataFromXml.DataFromXml;
import com.dudka.io.task2.generateJsonByTotalFinesAmount.GenerateJsonByFinesAmount;
import com.dudka.io.task2.parseFineToTotalFines.TotalFinesParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, URISyntaxException, IOException, ParseException, SAXException {

        GenerateJsonByFinesAmount.generateJson(TotalFinesParser.calculateFines(DataFromXml.parser("fines/fines.xml")), "totalFines.json");

        ParseXml.parseXmlWithPersons();
    }
}
