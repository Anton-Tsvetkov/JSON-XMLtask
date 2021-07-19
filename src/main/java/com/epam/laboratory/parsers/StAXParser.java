package com.epam.laboratory.parsers;

import com.epam.laboratory.workObjects.DiamondFund;

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
import java.util.List;

public class StAXParser extends Parser {

    List<DiamondFund.Gem> gems = new ArrayList<>();
    DiamondFund.Gem gem;

    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

    public List<DiamondFund.Gem> getGems() {
        return gems;
    }

    @Override
    public DiamondFund parse(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(fileInputStream);
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
            reader.close();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
