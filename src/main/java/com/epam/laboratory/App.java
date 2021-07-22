package com.epam.laboratory;

import com.epam.laboratory.parsers.JSON.XMLtoJSONConverter;

public class App {

    public static void main(String[] args) {
        XMLtoJSONConverter xmLtoJSONConverter = new XMLtoJSONConverter();
        xmLtoJSONConverter.convert(Config.pathToXmlFile, Config.pathToJsonFile); // look for the result in properties/Gem.json



    }

}
