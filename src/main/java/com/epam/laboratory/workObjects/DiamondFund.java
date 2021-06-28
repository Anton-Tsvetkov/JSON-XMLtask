package com.epam.laboratory.workObjects;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "DiamondFund")
public class DiamondFund {

    @JsonProperty("DiamondFund")
    private List<Gem> gems;

    @XmlElement(name="Gem")
    public List<Gem> getGems() {
        return gems;
    }

    public void setGems(List<Gem> gems) {
        this.gems = gems;
    }
}

