package com.epam.laboratory.JSONtask;

import com.epam.laboratory.Config;
import com.epam.laboratory.parsers.JSON.XMLtoJSONConverter;


public class App {

    public static void main(String[] args) {
        XMLtoJSONConverter xmLtoJSONConverter = new XMLtoJSONConverter();
        xmLtoJSONConverter.convert(Config.pathToXmlFile, Config.pathToJsonFile); // look for the result in properties/Gem.json

//        Parser parser = new Parser();
//        parser.parse();

        //System.out.println(jsonParser.getDiamondFundFromJSON().getGem().get(0).getColor());

    }
}
