package com.epam.laboratory;

import com.epam.laboratory.XMLtask.ParseMethodCaller;
import java.util.Scanner;

public class ParseMethodQuestioner {

    public void askParseMethod() {

        System.out.println("Get objects from file or other ?");
        Scanner scanner = new Scanner(System.in);
        String parseMethod = scanner.nextLine();
        parseMethod = parseMethod.toLowerCase().trim();
        if (parseMethod.contains("object")) {
            System.out.println("Choose parse method:" +
                    "\n1.Parse objects from XML with SAX" +
                    "\n2.Parse objects from JSON");
            System.out.print(":");
            parseMethod = scanner.nextLine();
            System.out.println(new ParseMethodCaller().callObjectParseMethodByNumber(parseMethod.toLowerCase().trim()));
        } else if (parseMethod.contains("other")) {
            System.out.println("Choose parse method:" +
                    "\n1.Parse from XML to JSON" +
                    "\n2.XML/XSD check");
            System.out.print(":");
            parseMethod = scanner.nextLine();
            System.out.println(new ParseMethodCaller().callOtherParseMethodByNumber(parseMethod.toLowerCase().trim()));
        } else {
            System.out.println("The specified method cannot be found");
        }
    }

}
