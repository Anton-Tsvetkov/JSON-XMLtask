package com.epam.laboratory.parsers;

import com.epam.laboratory.workObjects.Gem;

import java.util.ArrayList;

abstract public class Parser {

    ArrayList<Gem> gems = new ArrayList<>();
    public ArrayList<Gem> getGems(){
        return gems;
    }
    abstract public void askParseMethod(String pathToXMLFile);
}
