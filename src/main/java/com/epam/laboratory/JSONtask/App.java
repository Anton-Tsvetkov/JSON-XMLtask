package com.epam.laboratory.JSONtask;

import com.epam.laboratory.Config;
import com.epam.laboratory.workObjects.DiamondFund;
import com.epam.laboratory.workObjects.Gem;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {

    private static final String PATH_TO_XML_FILE = Config.PATH_TO_XML_FILE;
    private static final String PATH_TO_JSON_FILE = Config.PATH_TO_JSON_FILE;

    public static void main(String[] args) throws IOException {
        XMLtoJSONConverter xmLtoJSONConverter = new XMLtoJSONConverter();
        xmLtoJSONConverter.convert(PATH_TO_XML_FILE, PATH_TO_JSON_FILE); // look for the result in properties/Gem.json

        JSONParser jsonParser = new JSONParser();
        DiamondFund diamondFund = jsonParser.getDiamondFundFromJSON();
        List<Gem> gems = jsonParser.getGemsFromJSON();

        System.out.println(Arrays.toString(diamondFund.getGems().get(1).getVisualParams()));
        System.out.println(gems.get(0).getColor());
    }
}
