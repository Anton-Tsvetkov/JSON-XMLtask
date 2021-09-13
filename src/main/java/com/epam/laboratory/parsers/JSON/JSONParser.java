package com.epam.laboratory.parsers.JSON;

import com.epam.laboratory.parsers.Parser;
import com.epam.laboratory.workObjects.Gem;
import com.fasterxml.jackson.core.type.TypeReference;
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

    ArrayList<Gem> gems = new ArrayList<>();

    public ArrayList<Gem> getGems() {
        return gems;
    }


    @Override
    public void askParseMethod(String pathToJSONFile) {
        getGemsFromJSON(pathToJSONFile);
    }

    private String getFileContentAsString(String path) {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return path;
    }

    public void getGemsFromJSON(String pathToJSONFile) {
        JSONObject jsonObject = new JSONObject(getFileContentAsString(pathToJSONFile));
        JSONArray jsonArray = jsonObject.getJSONArray("gem");
        castJsonArrayToArrayList(jsonArray);
    }

    private void castJsonArrayToArrayList(JSONArray jsonArray) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 0; i < jsonArray.length(); i++) {
                gems.add(objectMapper.readValue(jsonArray.get(i).toString(), Gem.class));
            }
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }

    }
}
