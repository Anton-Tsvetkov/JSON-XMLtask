package com.epam.laboratory;

public class App {

    public static void main(String[] args) {

        ParseMethodAsker parseMethodAsker = new ParseMethodAsker();
        parseMethodAsker.askParseMethod();
        // souts заккоментировать если не вызывается парс объектов из файла
//        System.out.println(parseMethodAsker.getGems().get(0).getOrigin());
//        System.out.println(parseMethodAsker.getGems().get(0).getValue());
//        System.out.println(parseMethodAsker.getGems().get(0).getVisualParameters().getColor());


    }

}
