package com.epam.laboratory.workObjects;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.List;

@JsonRootName(value = "DiamondFund")
public class DiamondFund {

    protected List<Gem> gem;

    /**
     * Gets the value of the gem property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gem property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGem().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Gem }
     */
    public List<Gem> getGem() {
        if (gem == null) {
            gem = new ArrayList<>();
        }
        return this.gem;
    }

}
