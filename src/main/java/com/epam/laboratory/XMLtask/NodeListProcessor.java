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
                comparator = new Comparator<Gem>() {
                    @Override
                    public int compare(Gem o1, Gem o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                };
                break;
            case "PRECIOUSNESS":
                comparator = new Comparator<Gem>() {
                    @Override
                    public int compare(Gem o1, Gem o2) {
                        return o1.getPreciousness().compareTo(o2.getPreciousness());
                    }
                };
                break;
            case "ORIGIN":
                comparator = new Comparator<Gem>() {
                    @Override
                    public int compare(Gem o1, Gem o2) {
                        return o1.getOrigin().compareTo(o2.getOrigin());
                    }
                };
                break;
            case "COLOR":
                comparator = new Comparator<Gem>() {
                    @Override
                    public int compare(Gem o1, Gem o2) {
                        return o1.getColor().compareTo(o2.getColor());
                    }
                };
                break;
            case "TRANSPARENCY":
                comparator = new Comparator<Gem>() {
                    @Override
                    public int compare(Gem o1, Gem o2) {
                        return o1.getTransparency() - o2.getTransparency();
                    }
                };
                break;
            case "NUMBER_OF_FACES":
                comparator = new Comparator<Gem>() {
                    @Override
                    public int compare(Gem o1, Gem o2) {
                        return o1.getNumberOfFaces() - o2.getNumberOfFaces();
                    }
                };
                break;
            case "VALUE":
                comparator = new Comparator<Gem>() {
                    @Override
                    public int compare(Gem o1, Gem o2) {
                        return (int) (o1.getValue() - o2.getValue());
                    }
                };
                break;
            default:
                comparator = new Comparator<Gem>() {
                    @Override
                    public int compare(Gem o1, Gem o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                };
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
