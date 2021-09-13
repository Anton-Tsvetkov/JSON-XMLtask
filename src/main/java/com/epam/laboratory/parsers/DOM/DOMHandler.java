package com.epam.laboratory.parsers.DOM;

import com.epam.laboratory.workObjects.Gem;
import org.w3c.dom.*;

import java.util.ArrayList;

public class DOMHandler {

//    ArrayList<Gem> gems = new ArrayList<>();
//
//    public ArrayList<Gem> getGems() {
//        return gems;
//
//    }

    public void addGems(Document document, ArrayList<Gem> gems) {
        // Получение списка всех элементов gem внутри корневого элемента
        // (getDocumentElement возвращает ROOT элемент XML файла)

        // Перебор всех элементов gem
//        for (int i = 0; i < diamondFundElements.getLength(); i++) {
//            Node gem = diamondFundElements.item(i);
//            // Получение атрибутов каждого элемента
//            NamedNodeMap attributes = gem.getAttributes();
        // Добавление камня.
        // Атрибут - тоже Node, потому нам нужно получить значение атрибута с помощью метода getNodeValue()


        // получаем узлы с именем Language
        // теперь XML полностью загружен в память
        // в виде объекта Document
        NodeList nodeList = document.getElementsByTagName("gem");

        for (int i = 0; i < nodeList.getLength(); i++) {
            gems.add(collectGem(nodeList.item(0), document));
        }


//            System.out.println(attributes.getLength());
//
//            gems.add(new Gem(attributes.getNamedItem("color").getNodeValue(),
//                    Integer.parseInt(attributes.getNamedItem("id").getNodeValue()),
//                    attributes.getNamedItem("name").getNodeValue(),
//                    Byte.parseByte(attributes.getNamedItem("numberOfFaces").getNodeValue()),
//                    attributes.getNamedItem("origin").getNodeValue(),
//                    attributes.getNamedItem("preciousness").getNodeValue(),
//                    Byte.parseByte(attributes.getNamedItem("transparency").getNodeValue()),
//                    Float.parseFloat(attributes.getNamedItem("value").getNodeValue())));
//        }

    }

    private static Gem collectGem(Node node, Document document) {
        Gem gem = new Gem();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            gem.setOrigin(getTagValue("origin", element));
            gem.setValue(Float.parseFloat(getTagValue("value", element)));
            //gem.setId(Byte.parseByte(getTagValue("id", element)));
            gem.setName(getTagValue("name", element));
            gem.setPreciousness(getTagValue("preciousness", element));

            NodeList nodeList = ((Element) node).getElementsByTagName("VisualParameters").item(0).getChildNodes();

            //element = (Element) nodeList.item(0);
            gem.setVisualParameters(getTagValue("color", element),
                    Byte.parseByte(getTagValue("numberOfFaces", element)),
                    Float.parseFloat(getTagValue("transparency", element)));
        }
        return gem;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

}
