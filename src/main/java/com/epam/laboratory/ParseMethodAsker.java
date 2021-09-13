package com.epam.laboratory;

import com.epam.laboratory.XMLtask.ParseMethodCaller;
import com.epam.laboratory.workObjects.Gem;

import java.util.ArrayList;
import java.util.Scanner;

public class ParseMethodAsker {

    public void askParseMethod() {

        System.out.println("Get objects from file or other ?");
        Scanner scanner = new Scanner(System.in);
        String parseMethod = scanner.nextLine();
        parseMethod = parseMethod.toLowerCase().trim();
        if (parseMethod.contains("object")) {
            System.out.println("Choose parse method:" +
                    "\n1.Parse objects from XML with SAX" +
                    "\n2.Parse objects from XML with StAX" +
                    "\n3.Parse objects from XML with DOM" +
                    "\n4.Parse objects from JSON");
            System.out.print(":");
            parseMethod = scanner.nextLine();
            gems = new ParseMethodCaller().callObjectParseMethodByNumber(parseMethod.toLowerCase().trim());
        } else if (parseMethod.contains("other")) {
            System.out.println("Choose parse method:" +
                    "\n1.Parse from XML to JSON" +
                    "\n2.XML/XSD check" +
                    "\n3.XML(Gem)->XML(Origin) with XSLT");
            System.out.print(":");
            parseMethod = scanner.nextLine();
            new ParseMethodCaller().callOtherParseMethodByNumber(parseMethod.toLowerCase().trim());
        } else {
            System.out.println("The specified method cannot be found");
        }

    }

    ArrayList<Gem> gems = new ArrayList<>();

    public ArrayList<Gem> getGems() {
        return gems;
    }
}
