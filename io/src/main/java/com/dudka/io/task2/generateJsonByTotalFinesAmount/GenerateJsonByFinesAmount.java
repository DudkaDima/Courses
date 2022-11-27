package com.dudka.io.task2.generateJsonByTotalFinesAmount;

import com.dudka.io.task2.calculateFineAmountByType.CalculateFine;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;

import javax.json.Json;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonByFinesAmount {
    public static void generateJson(List<CalculateFine> fines, String path) throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        jsonFactory.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
        ObjectMapper mapper = new ObjectMapper(jsonFactory);
        FileWriter writer = new FileWriter("finalFines.json", true);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        mapper.writerWithDefaultPrettyPrinter().writeValue(writer, fines);


    }
}
