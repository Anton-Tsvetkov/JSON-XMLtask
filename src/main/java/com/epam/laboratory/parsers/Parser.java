package com.epam.laboratory.parsers;

import com.epam.laboratory.workObjects.Gem;

import java.util.ArrayList;

abstract public class Parser {

    ArrayList<Gem> gems = new ArrayList<>();
    public ArrayList<Gem> parse(String pathToXMLFile){return gems;}
}
