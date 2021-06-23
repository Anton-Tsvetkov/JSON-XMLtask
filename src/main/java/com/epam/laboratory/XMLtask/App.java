package com.epam.laboratory.XMLtask;


import com.epam.laboratory.workObjects.DiamondFund;
import com.epam.laboratory.workObjects.Gem;

import javax.xml.bind.JAXBException;

public class App {
    public static void main(String[] args) throws JAXBException {

        NodeListProcessor nodeListProcessor = new NodeListProcessor();
        DiamondFund gems = nodeListProcessor.unMarshalingGems("Gem.xml");

        System.out.println("\nGems before sort:");
        for (Gem gem : gems.getGems()){
            System.out.println(gem);
        }

        gems = nodeListProcessor.sortByValue(gems);

        System.out.println("\nGems after sort:");
        for (Gem gem : gems.getGems()){
            System.out.println(gem);
        }


        System.out.println("\nXML is corresponds to XSD: " +
                Inspector.xmlCorrespondsToXsd(
                        "Gem.xml", "Gem.xsd"));


    }
}
