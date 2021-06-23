package com.epam.laboratory.XMLtask;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParser {

    private Document document;

    public DomParser(String xmlFileName) {
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
