package com.epam.laboratory.XMLtask;

import com.epam.laboratory.workObjects.Gem;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Comparator;
import java.util.List;

public class NodeListProcessor {

    /* Parameters:
    name
    preciousness
    origin
    visualParams:
			color
			transparency
			numberOfFaces
			value
     */

    private List<Gem> sortByParameter(Gem gem, String parameter){

        Comparator<Gem> comparator;

        switch (parameter){
            case "NAME":
                comparator = Comparator.comparing(Gem::getName);
                break;
            case "PRECIOUSNESS":
                comparator = Comparator.comparing(Gem::getPreciousness);
                break;
            case "ORIGIN":
                comparator = Comparator.comparing(Gem::getOrigin);
                break;
//            case "COLOR":
//                comparator = Comparator.comparing(DiamondFund.Gem.VisualParameters::getColor);
//                break;
//            case "TRANSPARENCY":
//                comparator = Comparator.comparingInt(DiamondFund.Gem.VisualParameters::getTransparency);
//                break;
//            case "NUMBER_OF_FACES":
//                comparator = Comparator.comparingInt(DiamondFund.Gem.VisualParameters::getNumberOfFaces);
//                break;
            case "VALUE":
                comparator = (o1, o2) -> (int) (o1.getValue() - o2.getValue());
                break;
            default:
                comparator = Comparator.comparing(Gem::getName);
                System.out.println("Parameter for sorting not found");
        }

        // Here, code praying to the GOD for protecting our comparator methods from lambda's bugs and other things.
        // This is really critical step! Be advised to not remove it, even if you don't believer
        System.out.println("Praise Noodles, Sauce, and Meaty Balls.\n");

        List<Gem> gemList = gem.getGem();
        gemList.sort(comparator);

        return gemList;
    }

    public List<Gem> sortByName(Gem gem){
        return sortByParameter(gem, "NAME");
    }

    public List<Gem> sortByPreciousness(Gem gem){
        return sortByParameter(gem, "PRECIOUSNESS");
    }

    public List<Gem> sortByOrigin(Gem gem){
        return sortByParameter(gem, "ORIGIN");
    }

    public List<Gem> sortByColor(Gem gem){
        return sortByParameter(gem, "COLOR");
    }

    public List<Gem> sortByTransparency(Gem gem){
        return sortByParameter(gem, "TRANSPARENCY");
    }

    public List<Gem> sortByNumberOfFaces(Gem gem){
        return sortByParameter(gem, "NUMBER_OF_FACES");
    }

    public List<Gem> sortByValue(Gem gem){
        return sortByParameter(gem, "VALUE");
    }


    public Gem unMarshalingGems(String path) throws JAXBException {

        return (Gem) JAXBContext
                .newInstance(Gem.class)
                .createUnmarshaller()
                .unmarshal(new File(path));

    }

}
