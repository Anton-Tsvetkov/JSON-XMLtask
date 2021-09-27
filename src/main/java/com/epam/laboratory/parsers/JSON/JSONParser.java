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

    protected ArrayList<Country> countries = new ArrayList<>();
    protected ArrayList<Gem> gems = new ArrayList<>();


    @Override
    public ArrayList<?> parse(String pathToJSONFile) {
        JSONObject jsonObject = new JSONObject(getFileContentAsString(pathToJSONFile));
        if(jsonObject.toString().contains("country")) {
            JSONArray jsonArray = jsonObject.getJSONArray("country");
            castJsonArrayToArrayListWorld(jsonArray);
            return countries;
        } else if (jsonObject.toString().contains("gem")){
            JSONArray jsonArray = jsonObject.getJSONArray("gem");
            castJsonArrayToArrayListGem(jsonArray);
            return gems;
        } else return new ArrayList<>();
    }

    private String getFileContentAsString(String path) {
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            return lines.collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return path;
    }



    private void castJsonArrayToArrayListGem(JSONArray jsonArray) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 0; i < jsonArray.length(); i++) {
                gems.add(objectMapper.readValue(jsonArray.get(i).toString(), Gem.class));
            }
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }

    }


    private void castJsonArrayToArrayListWorld(JSONArray jsonArray) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 0; i < jsonArray.length(); i++) {
                countries.add(objectMapper.readValue(jsonArray.get(i).toString(), Country.class));
            }
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }

    }
}
