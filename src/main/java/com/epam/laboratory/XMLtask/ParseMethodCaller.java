package com.epam.laboratory.XMLtask;

import com.epam.laboratory.Config;
import com.epam.laboratory.parsers.JSON.JSONParser;
import com.epam.laboratory.parsers.JSON.XMLtoJSONConverter;
import com.epam.laboratory.parsers.SAX.SAXParser;

import java.util.ArrayList;


public class ParseMethodCaller {

    public ArrayList<?> callObjectParseMethodByNumber(String parseMethod) {
        switch (parseMethod) {
            case "1":
                SAXParser saxParser = new SAXParser();
                return saxParser.parse(Config.pathToWorldXmlFile);
                //return saxParser.parse(Config.pathToGemXmlFile);

            case "2":
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(Config.pathToWorldJsonFile);
                //return jsonParser.parse(Config.pathToGemJsonFile);

            default:
                System.out.println("Parse method " + parseMethod + " not found");
        }
        return new ArrayList<>();
    }

    public boolean callOtherParseMethodByNumber(String parseMethod) {
        switch (parseMethod) {
            case "1":
                XMLtoJSONConverter xmLtoJSONConverter = new XMLtoJSONConverter();
                //xmLtoJSONConverter.convert(Config.pathToGemXmlFile, Config.pathToGemJsonFile);
                xmLtoJSONConverter.convert(Config.pathToWorldXmlFile, Config.pathToWorldJsonFile);
                return true;
            case "2":
                //return new InspectorXML().validateByXsd(Config.pathToGemXmlFile, Config.pathToGemXsdFile);
                return new InspectorXML().validateByXsd(Config.pathToWorldXmlFile, Config.pathToWorldXsdFile);
            default:
                System.out.println("Parse method " + parseMethod + " not found");
                return false;
        }
    }

}
