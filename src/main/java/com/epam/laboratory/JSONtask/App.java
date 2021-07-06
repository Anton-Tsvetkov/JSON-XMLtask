package com.epam.laboratory.JSONtask;

import com.epam.laboratory.Config;
import com.epam.laboratory.Parser;

import java.io.IOException;

public class App {

    private static final String PATH_TO_XML_FILE = Config.pathToXmlFile;
    private static final String PATH_TO_JSON_FILE = Config.pathToJsonFile;

    public static void main(String[] args) {
        XMLtoJSONConverter xmLtoJSONConverter = new XMLtoJSONConverter();
        xmLtoJSONConverter.convert(PATH_TO_XML_FILE, PATH_TO_JSON_FILE); // look for the result in properties/Gem.json


        Parser.JSONParser jsonParser = new Parser.JSONParser();

        System.out.println(jsonParser.getDiamondFundFromJSON().getGem().get(0).getColor());

    }
}
