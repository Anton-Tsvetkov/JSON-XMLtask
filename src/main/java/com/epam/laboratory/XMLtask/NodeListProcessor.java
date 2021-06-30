package com.epam.laboratory.XMLtask;

import com.epam.laboratory.workObjects.DiamondFund;

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

    private List<DiamondFund.Gem> sortByParameter(DiamondFund diamondFund, String parameter){

        Comparator<DiamondFund.Gem> comparator;

        switch (parameter){
            case "NAME":
                comparator = Comparator.comparing(DiamondFund.Gem::getName);
                break;
            case "PRECIOUSNESS":
                comparator = Comparator.comparing(DiamondFund.Gem::getPreciousness);
                break;
            case "ORIGIN":
                comparator = Comparator.comparing(DiamondFund.Gem::getOrigin);
                break;
            case "COLOR":
                comparator = Comparator.comparing(DiamondFund.Gem::getColor);
                break;
            case "TRANSPARENCY":
                comparator = Comparator.comparingInt(DiamondFund.Gem::getTransparency);
                break;
            case "NUMBER_OF_FACES":
                comparator = Comparator.comparingInt(DiamondFund.Gem::getNumberOfFaces);
                break;
            case "VALUE":
                comparator = (o1, o2) -> (int) (o1.getValue() - o2.getValue());
                break;
            default:
                comparator = Comparator.comparing(DiamondFund.Gem::getName);
                System.out.println("Parameter for sorting not found");
        }

        List<DiamondFund.Gem> gemList = diamondFund.getGem();
        gemList.sort(comparator);

        return gemList;
    }

    public List<DiamondFund.Gem> sortByName(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "NAME");
    }

    public List<DiamondFund.Gem> sortByPreciousness(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "PRECIOUSNESS");
    }

    public List<DiamondFund.Gem> sortByOrigin(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "ORIGIN");
    }

    public List<DiamondFund.Gem> sortByColor(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "COLOR");
    }

    public List<DiamondFund.Gem> sortByTransparency(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "TRANSPARENCY");
    }

    public List<DiamondFund.Gem> sortByNumberOfFaces(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "NUMBER_OF_FACES");
    }

    public List<DiamondFund.Gem> sortByValue(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "VALUE");
    }


    public DiamondFund unMarshalingGems(String path) throws JAXBException {

        return (DiamondFund) JAXBContext
                .newInstance(DiamondFund.class)
                .createUnmarshaller()
                .unmarshal(new File(path));

    }

}
