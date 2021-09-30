package com.epam.laboratory.parsers.SAX.handlers;

import com.epam.laboratory.workObjects.gem.Gem;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SAXGemHandler extends SAXHandler {

    private String lastElementName; // помечаем в каком элементе в данный момент мы находимся

    protected ArrayList<Gem> gems = new ArrayList<>();

    private String color, name, origin, preciousness;
    private int id;
    private byte numberOfFaces, transparency;
    private float value;

    @Override
    public ArrayList<Gem> getObjects(String pathToXMLFile) {
        return gems;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        lastElementName = qName;
        if (qName.equals("gem")) {
            id = Integer.parseInt(atts.getValue("id"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String information = new String(ch, start, length);
        information = information.replaceAll("\n", "").trim();
        if (!information.isEmpty()) {
            switch (lastElementName) {
                case "color":
                    color = information;
                    break;
                case "name":
                    name = information;
                    break;
                case "numberOfFaces":
                    numberOfFaces = Byte.parseByte(information);
                    break;
                case "origin":
                    origin = information;
                    break;
                case "preciousness":
                    preciousness = information;
                    break;
                case "transparency":
                    transparency = Byte.parseByte(information);
                    break;
                case "value":
                    value = Float.parseFloat(information);
                    break;
                default:
                    System.out.println("No find \"" + information + "\" element");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ((color != null && !color.isEmpty()) &&
                id != 0 &&
                (name != null && !name.isEmpty()) &&
                numberOfFaces != 0 &&
                (origin != null && !origin.isEmpty()) &&
                (preciousness != null && !preciousness.isEmpty()) &&
                transparency != 0 &&
                value != 0) {
            gems.add(new Gem(color, id, name, numberOfFaces, origin, preciousness, transparency, value));
            color = null;
            id = 0;
            name = null;
            numberOfFaces = 0;
            origin = null;
            preciousness = null;
            transparency = 0;
            value = 0;
        }
    }
}
