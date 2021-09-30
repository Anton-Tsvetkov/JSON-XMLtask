package com.epam.laboratory.XMLtask;

import com.epam.laboratory.Config;
import com.epam.laboratory.parsers.JSON.JSONParser;
import com.epam.laboratory.parsers.JSON.XMLtoJSONConverter;
import com.epam.laboratory.parsers.Parser;
import com.epam.laboratory.parsers.SAX.SAXParser;
import com.epam.laboratory.parsers.SAX.handlers.SAXGemHandler;
import com.epam.laboratory.parsers.SAX.handlers.SAXWorldHandler;
import com.epam.laboratory.workObjects.world.Country;
import com.epam.laboratory.workObjects.world.World;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;


public class ParseMethodCaller {

    public ArrayList<?> callObjectParseMethodByNumber(String parseMethod, String objectType) throws ParserConfigurationException, SAXException {
        objectType = objectType.toLowerCase().trim();
        switch (parseMethod) {
            case "1":
                return returnParsedListByObjectType(new SAXParser(), objectType, "sax");
            case "2":
                return returnParsedListByObjectType(new JSONParser(), objectType, "json");
            default:
                System.out.println("Parse method \"" + parseMethod + "\" not found");
        }
        return new ArrayList<>();
    }

    public boolean callOtherParseMethodByNumber(String parseMethod, String objectType) {
        switch (parseMethod) {
            case "1":
                if (objectType.contains("world")) {
                    new XMLtoJSONConverter().convert(Config.pathToWorldXmlFile, Config.pathToWorldJsonFile);
                    return true;
                } else if (objectType.contains("gem")) {
                    new XMLtoJSONConverter().convert(Config.pathToGemXmlFile, Config.pathToGemJsonFile);
                    return true;
                } else {
                    System.out.println("No found \"" + objectType + "\" objectType");
                    return false;
                }
            case "2":
                if (objectType.contains("world")) {
                    return new InspectorXML().validateByXsd(Config.pathToWorldXmlFile, Config.pathToWorldXsdFile);
                } else if (objectType.contains("gem")) {
                    return new InspectorXML().validateByXsd(Config.pathToGemXmlFile, Config.pathToGemXsdFile);
                } else {
                    System.out.println("No found \"" + objectType + "\" objectType");
                    return false;
                }
            default:
                System.out.println("Parse method " + parseMethod + " not found");
                return false;
        }
    }

    private ArrayList<?> returnParsedListByObjectType(Parser parser, String objectType, String parserType) throws ParserConfigurationException, SAXException {
        if (parserType.contains("sax")) {
            if (objectType.contains("world")) {
                return parser.parse(Config.pathToWorldXmlFile, objectType);
            } else if (objectType.contains("gem")) {
                return parser.parse(Config.pathToGemXmlFile, objectType);
            } else {
                System.out.println("No found \"" + objectType + "\" object type");
                return new ArrayList<>();
            }
        } else if (parserType.contains("json")) {
            if (objectType.contains("world")) {
                return parser.parse(Config.pathToWorldJsonFile, objectType);
            } else if (objectType.contains("gem")) {
                return parser.parse(Config.pathToGemJsonFile, objectType);
            } else {
                System.out.println("No found \"" + objectType + "\" object type");
                return new ArrayList<>();
            }
        } else {
            System.out.println("No found \"" + parserType + "\" parser type");
            return new ArrayList<>();
        }
    }

}
