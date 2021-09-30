package com.epam.laboratory.parsers.SAX.handlers;

import com.epam.laboratory.workObjects.world.Country;
import com.epam.laboratory.workObjects.world.Locality;
import com.epam.laboratory.workObjects.world.Region;
import org.xml.sax.Attributes;

import java.util.ArrayList;

public class SAXWorldHandler extends SAXHandler {

    private String lastElementName; // помечаем в каком элементе в данный момент мы находимся

    private ArrayList<Country> countries = new ArrayList<>();
    private ArrayList<Country> countriesBuffer = new ArrayList<>();

    private ArrayList<Region> regions = new ArrayList<>();
    private ArrayList<Locality> localities = new ArrayList<>();

    private String countryName;
    private int population, foundYear;

    private String regionName;
    private String type;
    private int index;


    @Override
    public ArrayList<Country> getObjects(String pathToXMLFile) {
        return countries;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        lastElementName = qName;
        if (qName.equals("locality")) {
            index = Integer.parseInt(atts.getValue("index"));
            type = atts.getValue("type");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String information = new String(ch, start, length);
        information = information.replaceAll("\n", "").trim();

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
                    regionName = information;
                    break;
                default:
                    System.out.println("No find \"" + information + "\" element");
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (qName.equals("region")) {
            fillRegion();
            nullifyRegion();
        }
        if (qName.equals("country")) {
            fillCountry();
            nullifyCountry();
        }

        localities.add(new Locality(index, type));

    }


    private void fillCountry() {
        countriesBuffer.add(new Country(countryName, population, foundYear, regions));
        countries.addAll(countriesBuffer);
    }

    private void nullifyCountry() {
        countryName = "null";
        population = 0;
        foundYear = 0;

        regions = new ArrayList<>();
        countriesBuffer = new ArrayList<>();

        index = 0;
        type = "null";
    }

    private void fillRegion() {
        regions.add(new Region(
                regionName,
                localities.get(0)));

    }

    private void nullifyRegion() {
        regionName = "null";
        localities = new ArrayList<>();
    }

}
