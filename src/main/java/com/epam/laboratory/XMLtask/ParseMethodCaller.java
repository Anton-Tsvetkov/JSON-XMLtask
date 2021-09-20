package com.epam.laboratory.XMLtask;

import com.epam.laboratory.Config;
import com.epam.laboratory.parsers.DOM.DOMParser;
import com.epam.laboratory.parsers.JSON.JSONParser;
import com.epam.laboratory.parsers.JSON.XMLtoJSONConverter;
import com.epam.laboratory.parsers.SAX.SAXParser;
import com.epam.laboratory.parsers.StAXParser;
import com.epam.laboratory.workObjects.Gem;

import java.util.ArrayList;


public class ParseMethodCaller {

    public ArrayList<Gem> callObjectParseMethodByNumber(String parseMethod){
        switch (parseMethod) {
            case "1":
                SAXParser saxParser = new SAXParser();
                return saxParser.parse(Config.pathToXmlFile);
            case "2":
                StAXParser stAXParser = new StAXParser();
                return stAXParser.parse(Config.pathToXmlFile);
            case "3":
                DOMParser domParser = new DOMParser();
                return domParser.parse(Config.pathToXmlFile);
            case "4":
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(Config.pathToJsonFile);
            default:
                System.out.println("Parse method " + parseMethod + " not found");
        }
        return new ArrayList<>();
    }

    public boolean callOtherParseMethodByNumber(String parseMethod){
        switch (parseMethod) {
            case "1":
                XMLtoJSONConverter xmLtoJSONConverter = new XMLtoJSONConverter();
                xmLtoJSONConverter.convert(Config.pathToXmlFile, Config.pathToJsonFile);
                return true;
            case "2":
                return new InspectorXML().validateByXsd(Config.pathToXmlFile, Config.pathToXsdFile);
            case "3":
                new XsltTransform().transform(Config.pathToXslFile, Config.pathToXmlFile, Config.pathToTransformXmlFile);
                return true;
            default:
                System.out.println("Parse method " + parseMethod + " not found");
                return false;
        }
    }

}
