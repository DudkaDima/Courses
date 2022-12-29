package com.dudka.courses.task1.xmlParser;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

public class ReadFromXml {
    private static final DecimalFormat NUMBER_FORMAT = new DecimalFormat("#.00");

    private static final Map<String, Double> fines = new HashMap<>();

    public static CompletableFuture<Map<String, Double>> findFinesFromFile(File file, ExecutorService service) throws ParserConfigurationException, org.xml.sax.SAXException, IOException {

        return CompletableFuture.supplyAsync(() -> {
            try {
                return returnMapForFuture(file);
            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            } catch (SAXException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, service);
    }


    public static Map<String, Boolean> getFilesFromFolder(String pathToFolder) {
        Map<String, Boolean> filesMap = new HashMap<>();
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(pathToFolder))) {
            for(Path path : stream) {
                if(!Files.isDirectory(path)) {
                    filesMap.put(path.toAbsolutePath().toString(), false);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filesMap;
    }

    public static void parallelCalculatingAsyncFiles(Map<String, Boolean>  pathToFiles, String resultFile, Integer numberOfThreads) throws ParserConfigurationException, IOException, SAXException {
        long start = System.currentTimeMillis();
        List<CompletableFuture<Map<String, Double>>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
            for(Map.Entry<String, Boolean> entry : pathToFiles.entrySet()){
                if(entry.getValue().equals(Boolean.FALSE)) {
                    futures.add(findFinesFromFile(new File(entry.getKey()),executorService));
                }
            }

        Map<String, Double> resultMap = futures.stream().map(future -> {
            try {
               return future.get();
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).flatMap(o-> o.entrySet().stream())
                .collect(groupingBy(Map.Entry::getKey, summingDouble(Map.Entry::getValue)));


                resultMap.entrySet().forEach(map -> {
                    try {
                        map.setValue(NUMBER_FORMAT.parse(map.getValue().toString()).doubleValue() / 2);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                });


        executorService.shutdown();

        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
        ObjectMapper mapper = new ObjectMapper(jsonFactory);
        FileWriter writer = new FileWriter(resultFile, true);

        mapper.writerWithDefaultPrettyPrinter().writeValue(writer, resultMap.entrySet().toArray());
        System.out.println("Time for " + numberOfThreads + " threads is = " + (System.currentTimeMillis() - start) + " milliseconds");
    }
    private static Map<String, Double> returnMapForFuture(File file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factorySax = SAXParserFactory.newInstance();
        SAXParser parser = factorySax.newSAXParser();
        XMLHandler handler = new XMLHandler();

        parser.parse(file, handler);
        return fines;
    }

    private static class XMLHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("fine")) {
                String type = attributes.getValue("type");
                Double fineAmount = Double.valueOf(attributes.getValue("fine_amount"));
                if(fines.containsKey(type)) {
                    fines.put(type, fines.get(type) + fineAmount);
                } else {
                    fines.put(type, fineAmount);
                }
            }
        }

        @Override
        public void startDocument() throws SAXException {

        }

        @Override
        public void endDocument() throws SAXException {

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