package com.epam.laboratory.parsers.SAX;

import com.epam.laboratory.workObjects.world.Country;
import com.epam.laboratory.workObjects.world.Locality;
import com.epam.laboratory.workObjects.world.Region;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SAXWorldHandler extends DefaultHandler {

    private String lastElementName; // помечаем в каком элементе в данный момент мы находимся

    protected ArrayList<Country> countries = new ArrayList<>();
    private ArrayList<Region> regions = new ArrayList<>();
    private ArrayList<Locality> localities = new ArrayList<>();

    private String countryName;
    private int population, foundYear;

    private ArrayList<String> regionNames = new ArrayList<>();
    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<Integer> indexes = new ArrayList<>();


    protected ArrayList<Country> getCountries() {
        return countries;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        lastElementName = qName;
        if (qName.equals("locality")) {
            indexes.add(Integer.parseInt(atts.getValue("index")));
            types.add(atts.getValue("type"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String information = new String(ch, start, length);
        information = information.replaceAll("\n", "").trim();

        for(int i = 0; i < 1; i++){
            System.out.println(information);
        }

        if (!information.isEmpty()) {
            switch (lastElementName) {
                case "countryName":
                    countryName = information;
                    break;
                case "population":
                    population = Integer.parseInt(information);
                    break;
                case "foundYear":
                    foundYear = Integer.parseInt(information);
                    break;
                case "regionName":
                    regionNames.add(information);
                    System.out.println("REGION: " + information);
                    break;
                default:
                    System.out.println("No find \"" + information + "\" element");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if ((countryName != null &&!countryName.isEmpty()) &&
                population != 0 &&
                !regionNames.isEmpty() &&
                !types.isEmpty() &&
                foundYear != 0 &&
                !indexes.isEmpty()) {
            for (int i = 0; i < indexes.size(); i++) {
                localities.add(new Locality(indexes.get(i), types.get(i)));
            }
            for (int i = 0; i < localities.size(); i++) {
                regions.add(new Region(regionNames.get(i), localities.get(i)));

            }
            countries.add(new Country(countryName, population, foundYear, regions));

            for(int i = 0; i < 1; i++){
                System.out.println("!!!!!!!!!!!!!!!" + countryName);
            }


            countryName = null;
            population = 0;
            foundYear = 0;

            localities = new ArrayList<>();
            regions = new ArrayList<>();
            countries = new ArrayList<>();

            regionNames = new ArrayList<>();
            indexes = new ArrayList<>();
            types = new ArrayList<>();
        }
    }
}
