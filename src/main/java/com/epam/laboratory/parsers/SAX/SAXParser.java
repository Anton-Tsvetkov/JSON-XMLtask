package com.epam.laboratory.parsers.SAX;

import com.epam.laboratory.parsers.Parser;
import com.epam.laboratory.workObjects.DiamondFund;
import com.epam.laboratory.workObjects.Gems;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXParser extends Parser {

    @Override
    public DiamondFund parse(File file) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factory.newSAXParser();

            SAXHandler handler = new SAXHandler();
            parser.parse(file, handler);

            gems.addAll(handler.getGems());

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return new DiamondFund();
    }

    ArrayList<Gems.Gem> gems = new ArrayList<>();

    public ArrayList<Gems.Gem> getGems() {
        return gems;
    }


}
