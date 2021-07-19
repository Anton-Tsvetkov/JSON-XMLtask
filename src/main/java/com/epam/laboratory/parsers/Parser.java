package com.epam.laboratory.parsers;

import com.epam.laboratory.parsers.JSON.JSONParser;
import com.epam.laboratory.parsers.SAX.SAXParser;
import com.epam.laboratory.workObjects.DiamondFund;

import java.io.File;
import java.util.Scanner;

public class Parser implements IParser {
    @Override
    public DiamondFund parse(File file) {
        System.out.println("Choose parse method:" +
                "\nParse object with SAX" +
                "\nParse object with StAX" +
                "\nParse object with DOM" +
                "\nParse from XML to JSON\n");
        Scanner scanner = new Scanner(System.in);
        String parseMethod = scanner.nextLine();
        parseMethod = parseMethod.toLowerCase().trim();
        switch (parseMethod) {
            case "sax":
                return new SAXParser().parse(file);
            case "stax":
                return new StAXParser().parse(file);
            case "dom":
                return new DOMParser().parse(file);
            case "json":
                return new JSONParser().parse(file);
            default:
                System.out.println("Parse method " + parseMethod + " not found");
        }
        return null;
    }
}
