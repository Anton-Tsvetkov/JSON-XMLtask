package com.epam.laboratory;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

public class App {

    public static void main(String[] args) throws ParserConfigurationException, SAXException {

        ParseMethodQuestioner parseMethodQuestioner = new ParseMethodQuestioner();
        parseMethodQuestioner.askParseMethod();

    }

}
