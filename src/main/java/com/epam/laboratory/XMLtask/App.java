package com.epam.laboratory.XMLtask;


import com.epam.laboratory.Config;
import com.epam.laboratory.Parser;
import com.epam.laboratory.workObjects.DiamondFund;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws JAXBException, ParserConfigurationException, SAXException, IOException {

//        NodeListProcessor nodeListProcessor = new NodeListProcessor();
//        DiamondFund diamondFund = nodeListProcessor.unMarshalingGems(Config.pathToXmlFile);
//
//        System.out.println("\nGems before sort:");
//        for (DiamondFund.Gem gem : diamondFund.getGem()){
//            System.out.println(gem);
//        }
//
//        List<DiamondFund.Gem> gems = nodeListProcessor.sortByValue(diamondFund);
//
//        System.out.println("\nGems after sort:");
//        for (DiamondFund.Gem gem : gems){
//            System.out.println(gem);
//        }
//
//
//        System.out.println("\nXML is corresponds to XSD: " +
//                InspectorXML.validateByXsd(
//                        Config.pathToXmlFile, Config.pathToXsdFile));

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        Parser.SAXParser handler = new Parser.SAXParser();
        parser.parse(new File(Config.pathToXmlFile), handler);

//        System.out.println(handler.getGem());

        for (DiamondFund.Gem gem : handler.getGems()){
            System.out.println(gem);
        }

    }
}
