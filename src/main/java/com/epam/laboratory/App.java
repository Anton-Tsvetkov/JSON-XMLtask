package com.epam.laboratory;

public class App {

    public static void main(String[] args) {

        parseMethodAsker parseMethodAsker = new parseMethodAsker();
        parseMethodAsker.askParseMethod(Config.pathToXmlFile);
//        System.out.println(parseMethodAsker.getGems().get(0).getOrigin());
//        System.out.println(parseMethodAsker.getGems().get(0).getValue());
//        System.out.println(parseMethodAsker.getGems().get(0).getVisualParameters().getColor());



    }

}
