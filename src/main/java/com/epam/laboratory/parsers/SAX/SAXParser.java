package com.epam.laboratory.parsers.SAX;

import com.epam.laboratory.parsers.Parser;
import com.epam.laboratory.parsers.SAX.handlers.SAXGemHandler;
import com.epam.laboratory.parsers.SAX.handlers.SAXHandler;
import com.epam.laboratory.parsers.SAX.handlers.SAXWorldHandler;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class SAXParser extends Parser {

    private final Logger LOGGER = Logger.getLogger(Parser.class);


    public ArrayList<?> parse(String pathToXMLFile, String objectType) {
        try {
            return new ArrayList<>(returnHandlerByObjectType(objectType).getObjects(pathToXMLFile));
        } catch (Exception e) {
            LOGGER.error("No such found " + objectType + " object type");
        }
        return new ArrayList<>();
    }

    private SAXHandler returnHandlerByObjectType(String objectType) throws Exception {
        if (objectType.contains("gem")) {
            return new SAXGemHandler();
        } else if (objectType.contains("world")) {
            return new SAXWorldHandler();
        } else {
            throw new Exception("No such found " + objectType + " object type");
        }
    }


}
