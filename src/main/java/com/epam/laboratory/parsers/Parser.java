package com.epam.laboratory.parsers;

import java.util.ArrayList;
import java.util.List;

abstract public class Parser {

    ArrayList<Object> objects = new ArrayList<>();
    public List<? extends Object> parse(String pathToXMLFile){return objects;}
}
