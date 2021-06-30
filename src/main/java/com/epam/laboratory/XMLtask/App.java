package com.epam.laboratory.XMLtask;


import com.epam.laboratory.Config;
import com.epam.laboratory.workObjects.DiamondFund;

import javax.xml.bind.JAXBException;
import java.util.List;

public class App {
    public static void main(String[] args) throws JAXBException {

        NodeListProcessor nodeListProcessor = new NodeListProcessor();
        DiamondFund diamondFund = nodeListProcessor.unMarshalingGems(Config.pathToXmlFile);

        System.out.println("\nGems before sort:");
        for (DiamondFund.Gem gem : diamondFund.getGem()){
            System.out.println(gem);
        }

        List<DiamondFund.Gem> gems = nodeListProcessor.sortByValue(diamondFund);

        System.out.println("\nGems after sort:");
        for (DiamondFund.Gem gem : gems){
            System.out.println(gem);
        }


        System.out.println("\nXML is corresponds to XSD: " +
                InspectorXML.validateByXsd(
                        Config.pathToXmlFile, Config.pathToXsdFile));


    }
}
