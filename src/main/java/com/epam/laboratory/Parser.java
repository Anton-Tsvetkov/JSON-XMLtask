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

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static class XsltTransform {
        public void transform() throws TransformerException {
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(new File(Config.pathToXslFile));
            Transformer transformer = factory.newTransformer(xslt);
            Source xml = new StreamSource(new File(Config.pathToXmlFile));
            transformer.transform(xml, new StreamResult(new File(Config.pathToTransformXmlFile)));
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
            if (qName.equals("gem")) {
                String idStr = atts.getValue("id");
                id = Integer.parseInt(idStr);
            }
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

        List<DiamondFund.Gem> gems = new ArrayList<>();
        DiamondFund.Gem gem;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        public List<DiamondFund.Gem> getGems() {
            return gems;
        }

        public void parse(String filename) {
            try {
                XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(filename));
                // идём по элементам xml файла
                while (reader.hasNext()) {
                    // получаем элемент и разбиваем его по атрибутам
                    XMLEvent nextEvent = reader.nextEvent();
                    if (nextEvent.isStartElement()) {
                        StartElement startElement = nextEvent.asStartElement();
                        // получаем gem's атрибуты
                        switch (startElement.getName().getLocalPart()) {
                            case "gem":
                                gem = new DiamondFund.Gem();
                                Attribute id = startElement.getAttributeByName(new QName("id"));
                                if (id != null) {
                                    gem.setId(Integer.parseInt(id.getValue()));
                                }
                                break;
                            case "color":
                                nextEvent = reader.nextEvent();
                                gem.setColor(nextEvent.asCharacters().getData());
                                break;
                            case "name":
                                nextEvent = reader.nextEvent();
                                gem.setName(nextEvent.asCharacters().getData());
                                break;
                            case "numberOfFaces":
                                nextEvent = reader.nextEvent();
                                gem.setNumberOfFaces(Byte.parseByte(nextEvent.asCharacters().getData()));
                                break;
                            case "origin":
                                nextEvent = reader.nextEvent();
                                gem.setOrigin(nextEvent.asCharacters().getData());
                                break;
                            case "preciousness":
                                nextEvent = reader.nextEvent();
                                gem.setPreciousness(nextEvent.asCharacters().getData());
                                break;
                            case "transparency":
                                nextEvent = reader.nextEvent();
                                gem.setTransparency(Byte.parseByte(nextEvent.asCharacters().getData()));
                                break;
                            case "value":
                                nextEvent = reader.nextEvent();
                                gem.setValue(Float.parseFloat(nextEvent.asCharacters().getData()));
                                break;
                            default:
                                System.out.println("No find \"" + startElement.getName().getLocalPart() + "\" element");
                        }
                        // если цикл дошел до закрывающего элемента Gem,
                        // то добавляем считанный из файла gem в список

                    }
                    if (nextEvent.isEndElement()) {
                        EndElement endElement = nextEvent.asEndElement();
                        if (endElement.getName().getLocalPart().equals("gem")) {
                            gems.add(gem);
                        }
                    }
                }

            } catch (FileNotFoundException | XMLStreamException e) {
                e.printStackTrace();
            }
        }

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
