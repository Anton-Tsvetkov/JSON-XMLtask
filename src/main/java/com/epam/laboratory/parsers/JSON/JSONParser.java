package com.epam.laboratory.parsers.JSON;

import com.epam.laboratory.parsers.Parser;
import com.epam.laboratory.workObjects.DiamondFund;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.*;

public class JSONParser extends Parser {

    private final Logger LOGGER = Logger.getLogger(JSONParser.class);


    @Override
    public DiamondFund parse(File file) {
        getDiamondFundFromJSON(file);

        return null;
    }


    public DiamondFund getDiamondFundFromJSON(File file) {
        DiamondFund diamondFund = new DiamondFund();
        try {
            ObjectMapper mapper = new ObjectMapper();
            diamondFund = mapper.readValue(file, DiamondFund.class);

        } catch (IOException ex) {
            LOGGER.error("Error reading from file '" + file.getPath() + "'");
        }
        return diamondFund;
    }


}
