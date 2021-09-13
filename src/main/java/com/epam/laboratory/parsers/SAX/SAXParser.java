package com.epam.laboratory.parsers.SAX;

import com.epam.laboratory.parsers.Parser;
import com.epam.laboratory.workObjects.Gem;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXParser extends Parser {


    @Override
    public ArrayList<Gem> parse(String pathToXMLFile) {
        ArrayList<Gem> gems = new ArrayList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();

            SAXHandler handler = new SAXHandler();
            parser.parse(new File(pathToXMLFile), handler);

            gems.addAll(handler.getGems());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return gems;
    }


}
