package com.epam.laboratory.parsers;

import com.epam.laboratory.parsers.SAX.handlers.SAXHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;

abstract public class Parser {

    ArrayList<?> objects = new ArrayList<>();

    public ArrayList<?> parse(String pathToFile, String objectType) throws ParserConfigurationException, SAXException {
        return objects;
    }
}
