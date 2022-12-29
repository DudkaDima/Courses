package com.dudka.courses;

import com.dudka.courses.task1.xmlParser.ReadFromXml;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
        ReadFromXml.parallelCalculatingAsyncFiles(ReadFromXml.getFilesFromFolder(
                root+ "/threads/src/main/java/com/dudka/courses/data"), "finalFile1Threads2.json", 2);
        ReadFromXml.parallelCalculatingAsyncFiles(ReadFromXml.getFilesFromFolder(
                root+ "/threads/src/main/java/com/dudka/courses/data"), "finalFile2Threads4.json", 4);
        ReadFromXml.parallelCalculatingAsyncFiles(ReadFromXml.getFilesFromFolder(
                root+ "/threads/src/main/java/com/dudka/courses/data"), "finalFile3Threads8.json", 8);
    }
}
