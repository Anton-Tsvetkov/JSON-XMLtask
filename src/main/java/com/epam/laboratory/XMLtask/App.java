package com.epam.laboratory.XMLtask;


import com.epam.laboratory.Config;
import com.epam.laboratory.workObjects.DiamondFund;
import com.epam.laboratory.workObjects.Gem;

import javax.xml.bind.JAXBException;

public class App {
    public static void main(String[] args) throws JAXBException {

        NodeListProcessor nodeListProcessor = new NodeListProcessor();
        DiamondFund diamondFund = nodeListProcessor.unMarshalingGems(Config.PATH_TO_XML_FILE);

        System.out.println("\nGems before sort:");
        for (Gem gem : diamondFund.getGems()){
            System.out.println(gem);
        }

        diamondFund = nodeListProcessor.sortByValue(diamondFund);

        System.out.println("\nGems after sort:");
        for (Gem gem : diamondFund.getGems()){
            System.out.println(gem);
        }


        System.out.println("\nXML is corresponds to XSD: " +
                Inspector.xmlCorrespondsToXsd(
                        Config.PATH_TO_XML_FILE, Config.PATH_TO_XSD_FILE));


    }
}
