package com.epam.laboratory;

import com.epam.laboratory.JSONtask.XMLtoJSONConverter;
import com.epam.laboratory.workObjects.DiamondFund;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Parser {

    class SAXParser {

    }

    class StAXParser {

    }

    class DOMParser {

        private Document document;

        public DOMParser(String xmlFileName) {
            try {
                // построитель документа для того чтобы загрузить структуру
                DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                // после загрузки xml документа разбираем его,
                // получая объект document - дерево (объектное представление всей информации внутри xml)
                this.document = documentBuilder.parse(xmlFileName);
            } catch (ParserConfigurationException | SAXException | IOException ex) {
                ex.printStackTrace();
            }
        }

        public NodeList parseCollection() {

            Node root = document.getDocumentElement();  // корневой элемент
            // просматриваем все подэлементы корневого - камни
            return root.getChildNodes();
        }

        public Document getDocument() {
            return document;
        }
    }


    class JSONParser {

        private final Logger LOGGER = Logger.getLogger(XMLtoJSONConverter.class);


        public DiamondFund getDiamondFundFromJSON() {
            DiamondFund diamondFund = null;
            try {
                JSONObject jsonObj = new JSONObject(XMLtoJSONConverter.getJsonObject(Config.pathToXmlFile).toString());
                ObjectMapper objectMapper = new ObjectMapper();
                diamondFund = objectMapper.readValue(blackMagicCutting(jsonObj), DiamondFund.class);
            } catch (IOException ex) {
                LOGGER.error("Error reading from file '" + Config.pathToXmlFile + "'");
            }
            return diamondFund;
        }

        public List<DiamondFund.Gem> getGemsFromJSON() {
            return getDiamondFundFromJSON().getGem();
        }


        private String blackMagicCutting(JSONObject jsonObj) {
            String json = jsonObj.toString();
            json = json.replace(":{", ":");
            json = json.replace("\"Gem\":", "");
            return json;
        }

    }


}
