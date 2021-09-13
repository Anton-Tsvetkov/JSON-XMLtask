package com.epam.laboratory;

import com.epam.laboratory.XMLtask.InspectorXML;
import com.epam.laboratory.XMLtask.XsltTransform;
import com.epam.laboratory.parsers.DOM.DOMParser;
import com.epam.laboratory.parsers.JSON.JSONParser;
import com.epam.laboratory.parsers.JSON.XMLtoJSONConverter;
import com.epam.laboratory.parsers.SAX.SAXParser;
import com.epam.laboratory.parsers.StAXParser;
import com.epam.laboratory.workObjects.Gem;

import java.util.ArrayList;
import java.util.Scanner;

public class parseMethodAsker {
    public void askParseMethod(String pathToXMLFile) {
        String pathToJsonFile = Config.pathToJsonFile;
        System.out.println("Choose askParseMethod method:" +
                "\n1.Parse objects from XML with SAX" +
                "\n2.Parse objects from XML with StAX" +
                "\n3.Parse objects from XML with DOM" +
                "\n4.Parse objects from JSON" +
                "\n5.Parse from XML to JSON" +
                "\n6.XML/XSD check" +
                "\n7.XML(Gem)->XML(Origin) with XSLT");
        System.out.print(":");
        Scanner scanner = new Scanner(System.in);
        String parseMethod = scanner.nextLine();
        parseMethod = parseMethod.toLowerCase().trim();
        switch (parseMethod) {
            case "1":
                SAXParser saxParser = new SAXParser();
                saxParser.askParseMethod(pathToXMLFile);
                setGems(saxParser.getGems());
                break;
            case "2":
                StAXParser stAXParser = new StAXParser();
                stAXParser.askParseMethod(pathToXMLFile);
                setGems(stAXParser.getGems());
                break;
            case "3":
                DOMParser domParser = new DOMParser();
                domParser.askParseMethod(pathToXMLFile);
                setGems(domParser.getGems());
                break;
            case "4":
                JSONParser jsonParser = new JSONParser();
                jsonParser.askParseMethod(pathToJsonFile);
                setGems(jsonParser.getGems());
                break;
            case "5":
                XMLtoJSONConverter xmLtoJSONConverter = new XMLtoJSONConverter();
                xmLtoJSONConverter.convert(pathToXMLFile, pathToJsonFile);
                break;
            case "6":
                System.out.println(new InspectorXML().validateByXsd(pathToXMLFile, Config.pathToXsdFile));
                break;
            case "7":
                new XsltTransform().transform(Config.pathToXslFile, Config.pathToXmlFile, Config.pathToTransformXmlFile);
                break;
            default:
                System.out.println("Parse method " + parseMethod + " not found");
        }
    }

    ArrayList<Gem> gems = new ArrayList<>();

    public void setGems(ArrayList<Gem> gems) {
        this.gems = gems;
    }

    public ArrayList<Gem> getGems() {
        return gems;
    }
}
