package com.epam.laboratory.JSONtask;

import com.epam.laboratory.Config;
import com.epam.laboratory.workObjects.DiamondFund;
import com.epam.laboratory.workObjects.Gem;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public class JSONParser {

    private static final Logger LOGGER = Logger.getLogger(XMLtoJSONConverter.class);


    public DiamondFund getDiamondFundFromJSON() {
        DiamondFund diamondFund = null;
        try {
            JSONObject jsonObj = new JSONObject(XMLtoJSONConverter.getJsonObject(Config.PATH_TO_XML_FILE).toString());
            ObjectMapper objectMapper = new ObjectMapper();
            diamondFund = objectMapper.readValue(blackMagicCutting(jsonObj), DiamondFund.class);
        } catch (IOException ex) {
            LOGGER.error("Error reading from file '" + Config.PATH_TO_XML_FILE + "'");
        }
        return diamondFund;
    }

    public List<Gem> getGemsFromJSON() throws IOException {
        return getDiamondFundFromJSON().getGems();
    }


    private String blackMagicCutting(JSONObject jsonObj) {
        String json = jsonObj.toString();
        json = json.replace(":{", ":");
        json = json.replace("\"Gem\":", "");
        return json;
    }

}

