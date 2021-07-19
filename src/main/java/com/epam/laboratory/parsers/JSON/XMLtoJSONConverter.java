package com.epam.laboratory.parsers.JSON;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;

public class XMLtoJSONConverter {

    private static final Logger LOGGER = Logger.getLogger(XMLtoJSONConverter.class);

    private static final int INDENT_FACTOR = 3;
    private static JSONObject jsonObject;


    public static JSONObject getJsonObject(String pathToXmlFile) {
        try {
            File xmlFile = new File(pathToXmlFile);
            InputStream inputStream = new FileInputStream(xmlFile);
            StringBuilder builder = new StringBuilder();
            int ptr;
            while ((ptr = inputStream.read()) != -1) {
                builder.append((char) ptr);
            }

            String xml = builder.toString();
            jsonObject = XML.toJSONObject(xml);
        } catch (IOException ex) {
            LOGGER.error("Error reading from file '" + pathToXmlFile + "'");
        }
        return jsonObject;
    }

    public void convert(String pathToXmlFile, String pathToJsonFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathToJsonFile))) {
            String jsonString = getJsonObject(pathToXmlFile).toString(INDENT_FACTOR);
            jsonString = blackMagicCutting(jsonString);
            bufferedWriter.write(jsonString);
        } catch (IOException ex) {
            LOGGER.error("Error writing to file '" + pathToJsonFile + "'");
        }
    }


    private String blackMagicCutting(String json) {
        StringBuilder stringBuilder = new StringBuilder(json);
        int index = json.indexOf(":");
        stringBuilder.delete(0, index + 2);
        index = stringBuilder.lastIndexOf("}");
        stringBuilder.deleteCharAt(index);
        json = stringBuilder.toString();
        return json;
    }

}