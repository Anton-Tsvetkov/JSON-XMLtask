package com.epam.laboratory.parsers.DOM;

import com.epam.laboratory.workObjects.Gem;
import org.w3c.dom.*;

import java.util.ArrayList;

public class DOMHandler {

    public void addGems(Document document, ArrayList<Gem> gems) {
        NodeList nodeList = document.getElementsByTagName("gem");
        for (int i = 0; i < nodeList.getLength(); i++) {
            gems.add(collectGem(nodeList.item(0)));
        }

    }

    private static Gem collectGem(Node node) {
        Gem gem = new Gem();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            gem.setOrigin(getTagValue("origin", element));
            gem.setValue(Float.parseFloat(getTagValue("value", element)));
            gem.setName(getTagValue("name", element));
            gem.setPreciousness(getTagValue("preciousness", element));

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
