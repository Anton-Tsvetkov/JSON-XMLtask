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

    Config config = new Config();

    public ArrayList<Gem> callObjectParseMethodByNumber(String parseMethod){
        switch (parseMethod) {
            case "1":
                SAXParser saxParser = new SAXParser();
                return saxParser.parse(config.getPathToXmlFile());
            case "2":
                StAXParser stAXParser = new StAXParser();
                return stAXParser.parse(config.getPathToXmlFile());
            case "3":
                DOMParser domParser = new DOMParser();
                return domParser.parse(config.getPathToXmlFile());
            case "4":
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(config.getPathToJsonFile());
            default:
                System.out.println("Parse method " + parseMethod + " not found");
        }
        return new ArrayList<>();
    }

    public ArrayList<Gem> callOtherParseMethodByNumber(String parseMethod){
        switch (parseMethod) {
            case "1":
                XMLtoJSONConverter xmLtoJSONConverter = new XMLtoJSONConverter();
                xmLtoJSONConverter.convert(config.getPathToXmlFile(), config.getPathToJsonFile());
                break;
            case "2":
                System.out.println(new InspectorXML().validateByXsd(config.getPathToXmlFile(), Config.pathToXsdFile));
                break;
            case "3":
                new XsltTransform().transform(Config.pathToXslFile, Config.pathToXmlFile, Config.pathToTransformXmlFile);
                break;
            default:
                System.out.println("Parse method " + parseMethod + " not found");
        }
        return new ArrayList<>();
    }

}
