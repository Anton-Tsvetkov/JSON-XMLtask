package com.epam.laboratory.parsers;

import com.epam.laboratory.workObjects.Gem;
import org.apache.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StAXParser extends Parser {

    ArrayList<Gem> gems = new ArrayList<>();
    Gem gem;

    private final Logger LOGGER = Logger.getLogger(StAXParser.class);

    @Override
    public ArrayList<Gem> parse(String pathToXMLFile) {
        try (FileInputStream fileInputStream = new FileInputStream(new File(pathToXMLFile))) {
            XMLEventReader reader = XMLInputFactory.newInstance().createXMLEventReader(fileInputStream);
            // идём по элементам xml файла
            while (reader.hasNext()) {
                // получаем элемент и разбиваем его по атрибутам
                XMLEvent nextEvent = reader.nextEvent();
                if (nextEvent.isStartElement()) {
                    StartElement startElement = nextEvent.asStartElement();

                    gemShaping(startElement, reader);

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
            reader.close();
        } catch (XMLStreamException | IOException ex) {
            LOGGER.error(ex.getMessage());
        }
        return gems;
    }

    private void gemShaping(StartElement startElement, XMLEventReader reader) {
        // получаем gem's атрибуты
        try {
            XMLEvent nextEvent;
            switch (startElement.getName().getLocalPart()) {
                case "gem":
                    gem = new Gem();
                    Attribute id = startElement.getAttributeByName(new QName("id"));
                    if (id != null) {
                        gem.setId(Integer.parseInt(id.getValue()));
                    }
                    break;
                case "color":
                    nextEvent = reader.nextEvent();
                    gem.getVisualParameters().setColor(nextEvent.asCharacters().getData());
                    break;
                case "name":
                    nextEvent = reader.nextEvent();
                    gem.setName(nextEvent.asCharacters().getData());
                    break;
                case "numberOfFaces":
                    nextEvent = reader.nextEvent();
                    gem.getVisualParameters().setNumberOfFaces(Byte.parseByte(nextEvent.asCharacters().getData()));
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
                    gem.getVisualParameters().setTransparency(Byte.parseByte(nextEvent.asCharacters().getData()));
                    break;
                case "value":
                    nextEvent = reader.nextEvent();
                    gem.setValue(Float.parseFloat(nextEvent.asCharacters().getData()));
                    break;
            }
        } catch (NoSuchElementException | XMLStreamException ex) {
            LOGGER.error(ex.getMessage());
        }
    }
}
