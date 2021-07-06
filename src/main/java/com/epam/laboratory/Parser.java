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
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Parser {

    public static class SAXParser {

    }

    public static class StAXParser {

    }

    public static class DOMParser {

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


    public static class JSONParser {

        private final Logger LOGGER = Logger.getLogger(XMLtoJSONConverter.class);


        public DiamondFund getDiamondFundFromJSON() {
            DiamondFund diamondFund = null;
            try {
                ObjectMapper mapper = new ObjectMapper();
                diamondFund = mapper.readValue(new File(Config.pathToJsonFile), DiamondFund.class);

            } catch (IOException ex) {
                LOGGER.error("Error reading from file '" + Config.pathToJsonFile + "'");
            }
            return diamondFund;
        }


    }

}
