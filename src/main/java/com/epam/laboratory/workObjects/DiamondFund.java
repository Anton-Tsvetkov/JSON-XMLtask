package com.epam.laboratory.workObjects;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "DiamondFund")
@XmlAccessorType(XmlAccessType.FIELD)
public class DiamondFund {

    @XmlElement(name = "gem")
    private List<Gem> gems;

    public List<Gem> getGems() {
        return gems;
    }

    public void setGems(List<Gem> gems) {
        this.gems = gems;
    }
}

