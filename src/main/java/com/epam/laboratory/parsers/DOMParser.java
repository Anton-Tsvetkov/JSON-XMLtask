package com.epam.laboratory.parsers;

import com.epam.laboratory.workObjects.DiamondFund;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DOMParser extends Parser {

    private Document document;

    @Override
    public DiamondFund parse(File file) {
        try {
            // построитель документа для того чтобы загрузить структуру
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // после загрузки xml документа разбираем его,
            // получая объект document - дерево (объектное представление всей информации внутри xml)
            document = documentBuilder.parse(file);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

//        public NodeList parse() {
//
//            Node root = document.getDocumentElement();  // корневой элемент
//            // просматриваем все подэлементы корневого - камни
//            return root.getChildNodes();
//        }

    public Document getDocument() {
        return document;
    }
}
