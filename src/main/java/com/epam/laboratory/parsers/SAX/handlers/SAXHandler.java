package com.epam.laboratory.parsers.SAX.handlers;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public abstract class SAXHandler extends DefaultHandler {

    private ArrayList<?> objects;

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {

    }

    @Override
    public void characters(char[] ch, int start, int length) {

    }

    @Override
    public void endElement(String uri, String localName, String qName) {

    }

    public ArrayList<?> getObjects(String pathToXMLFile) {
        return objects;
    }


}
