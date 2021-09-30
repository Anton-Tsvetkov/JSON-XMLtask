package com.epam.laboratory.parsers.JSON;

import com.epam.laboratory.parsers.Parser;
import com.epam.laboratory.workObjects.gem.Gem;
import com.epam.laboratory.workObjects.world.Country;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JSONParser extends Parser {

    private final Logger LOGGER = Logger.getLogger(JSONParser.class);

    public ArrayList<?> parse(String pathToJSONFile, String objectType) {
        ArrayList<Object> objects = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(getFileContentAsString(pathToJSONFile));
        JSONArray jsonArray;
        Object object = new Object();
        if (objectType.toLowerCase().contains("world")) {
            jsonArray = jsonObject.getJSONArray("country");
            object = new Country();
        } else if (objectType.toLowerCase().contains("gem")) {
            jsonArray = jsonObject.getJSONArray("gem");
            object = new Gem();
        } else {
            jsonArray = new JSONArray();
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 0; i < jsonArray.length(); i++) {
                objects.add(objectMapper.readValue(jsonArray.get(i).toString(), object.getClass()));
            }
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }

        return objects;

    }


    private String getFileContentAsString(String path) {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return path;
    }

}

