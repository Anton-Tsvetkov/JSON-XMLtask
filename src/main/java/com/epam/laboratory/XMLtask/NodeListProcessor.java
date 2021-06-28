package com.epam.laboratory.XMLtask;

import com.epam.laboratory.workObjects.DiamondFund;
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

    private DiamondFund sortByParameter(DiamondFund diamondFund, String parameter){

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
            case "COLOR":
                comparator = Comparator.comparing(Gem::getColor);
                break;
            case "TRANSPARENCY":
                comparator = Comparator.comparingInt(Gem::getTransparency);
                break;
            case "NUMBER_OF_FACES":
                comparator = Comparator.comparingInt(Gem::getNumberOfFaces);
                break;
            case "VALUE":
                comparator = (o1, o2) -> (int) (o1.getValue() - o2.getValue());
                break;
            default:
                comparator = Comparator.comparing(Gem::getName);
                System.out.println("Parameter for sorting not found");
        }

        List<Gem> gemList = diamondFund.getGems();
        gemList.sort(comparator);
        diamondFund.setGems(gemList);

        return diamondFund;
    }

    public DiamondFund sortByName(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "NAME");
    }

    public DiamondFund sortByPreciousness(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "PRECIOUSNESS");
    }

    public DiamondFund sortByOrigin(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "ORIGIN");
    }

    public DiamondFund sortByColor(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "COLOR");
    }

    public DiamondFund sortByTransparency(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "TRANSPARENCY");
    }

    public DiamondFund sortByNumberOfFaces(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "NUMBER_OF_FACES");
    }

    public DiamondFund sortByValue(DiamondFund diamondFund){
        return sortByParameter(diamondFund, "VALUE");
    }


    public DiamondFund unMarshalingGems(String path) throws JAXBException {

        return (DiamondFund) JAXBContext
                .newInstance(DiamondFund.class)
                .createUnmarshaller()
                .unmarshal(new File(path));

    }

}
