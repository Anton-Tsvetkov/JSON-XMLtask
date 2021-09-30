package com.epam.laboratory.parsers.SAX;

import com.epam.laboratory.parsers.Parser;
import com.epam.laboratory.parsers.SAX.handlers.SAXGemHandler;
import com.epam.laboratory.parsers.SAX.handlers.SAXHandler;
import com.epam.laboratory.parsers.SAX.handlers.SAXWorldHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

public class SAXParser extends Parser {

    private final Logger LOGGER = Logger.getLogger(Parser.class);


    public ArrayList<?> parse(String pathToXMLFile, String objectType) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();

            SAXHandler handler = returnHandlerByObjectType(objectType);
            parser.parse(pathToXMLFile, handler);
            return new ArrayList<>(handler.getObjects(pathToXMLFile));
        } catch (ParserConfigurationException | SAXException | IOException exception) {
            LOGGER.error(exception.getMessage());
        }
        return new ArrayList<>();
    }

    private SAXHandler returnHandlerByObjectType(String objectType) {
        if (objectType.contains("gem")) {
            return new SAXGemHandler();
        } else {
            return new SAXWorldHandler();
        }
    }


}
