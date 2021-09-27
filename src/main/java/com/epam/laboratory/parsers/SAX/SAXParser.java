package com.epam.laboratory.parsers.SAX;

import com.epam.laboratory.parsers.Parser;
import com.epam.laboratory.workObjects.gem.Gem;
import com.epam.laboratory.workObjects.world.Country;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXParser extends Parser {

    private final Logger LOGGER = Logger.getLogger(Parser.class);


    @Override
    public ArrayList<?> parse(String pathToXMLFile) {
        if (pathToXMLFile.contains("Gem")) return returnGems(pathToXMLFile);
        else if (pathToXMLFile.contains("World")) return returnCountries(pathToXMLFile);
        else return new ArrayList<>();

    }

    private ArrayList<Gem> returnGems(String pathToXMLFile){
        ArrayList<Gem> gems = new ArrayList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();

            SAXGemHandler handler = new SAXGemHandler();
            parser.parse(new File(pathToXMLFile), handler);

            gems.addAll(handler.getGems());

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return gems;
    }

    private ArrayList<Country> returnCountries(String pathToXMLFile){
        ArrayList<Country> countries = new ArrayList<>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();

            SAXWorldHandler handler = new SAXWorldHandler();
            parser.parse(new File(pathToXMLFile), handler);

            countries.addAll(handler.getCountries());

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return countries;
    }

}
