package com.epam.laboratory;

import com.epam.laboratory.JSONtask.XMLtoJSONConverter;
import com.epam.laboratory.workObjects.DiamondFund;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Parser {

    public static class XsltTransform {
        public static void main(String[] args) throws IOException, URISyntaxException, TransformerException {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File("article1a.xsl"));
            Transformer transformer = factory.newTransformer(xslt);
            Source xml = new StreamSource(new File(Config.pathToXmlFile));
            transformer.transform(xml, new StreamResult(new File("output.xml")));
        }
    }

    public static class SAXParser extends DefaultHandler {

        private String lastElementName; // помечаем в каком элементе в данный момент мы находимся
        ArrayList<DiamondFund.Gem> gems = new ArrayList<>();

        private String color, name, origin, preciousness;
        private int id;
        private byte numberOfFaces, transparency;
        private float value;

        public ArrayList<DiamondFund.Gem> getGems() {
            return gems;
        }


        @Override
        public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);
            information = information.replace("\n", "").trim();
            if (!information.isEmpty()) {
                switch (lastElementName) {
                    case "color":
                        color = information;
                        break;
                    case "id":
                        id = Integer.parseInt(information);
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
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ((color != null && !color.isEmpty()) &&
                    id != 0 &&
                    (name != null && !name.isEmpty()) &&
                    numberOfFaces != 0 &&
                    (origin != null && !origin.isEmpty()) &&
                    (preciousness != null && !preciousness.isEmpty()) &&
                    transparency != 0 &&
                    value != 0) {
                gems.add(new DiamondFund.Gem(color, id, name, numberOfFaces, origin, preciousness, transparency, value));
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
