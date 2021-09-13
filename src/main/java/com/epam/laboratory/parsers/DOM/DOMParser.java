package com.epam.laboratory.parsers.DOM;

import com.epam.laboratory.parsers.Parser;
import com.epam.laboratory.workObjects.Gem;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOMParser extends Parser {


    @Override
    public ArrayList<Gem> parse(String pathToXMLFile) {
        ArrayList<Gem> gems = new ArrayList<>();
        try {
            // Получение фабрики, чтобы после получить билдер документов.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
            Document document = builder.parse(new File(pathToXMLFile));

            DOMHandler domHandler = new DOMHandler();
            domHandler.addGems(document, gems);

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
        return gems;
    }

}
