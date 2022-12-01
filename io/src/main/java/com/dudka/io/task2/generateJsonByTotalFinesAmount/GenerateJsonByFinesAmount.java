package com.dudka.io.task2.generateJsonByTotalFinesAmount;

import com.dudka.io.task2.calculateFineAmountByType.CalculateFine;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonByFinesAmount {
    public static void generateJson(List<CalculateFine> fines, String path) throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
        ObjectMapper mapper = new ObjectMapper(jsonFactory);
        FileWriter writer = new FileWriter("finalFines.json", true);

        mapper.writerWithDefaultPrettyPrinter().writeValue(writer, fines);


    }
}
