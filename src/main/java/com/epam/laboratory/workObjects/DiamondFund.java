package com.epam.laboratory.workObjects;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DiamondFund {

    @JsonProperty("DiamondFund")
    private List<Gem> gems;

    public List<Gem> getGems() {
        return gems;
    }

    public void setGems(List<Gem> gems) {
        this.gems = gems;
    }
}

