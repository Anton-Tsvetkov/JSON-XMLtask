package com.epam.laboratory;

public class App {

    private static final String PATH_TO_XML_FILE = Config.PATH_TO_XML_FILE;
    private static final String PATH_TO_JSON_FILE = Config.PATH_TO_JSON_FILE;

    public static void main(String[] args) {
        XMLtoJSONConverter xmLtoJSONConverter = new XMLtoJSONConverter();
        xmLtoJSONConverter.convert(PATH_TO_XML_FILE, PATH_TO_JSON_FILE);
    }
}
