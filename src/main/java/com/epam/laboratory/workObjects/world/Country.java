package com.epam.laboratory.workObjects.world;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="population">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="foundYear">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2020"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="region" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="locality">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="index" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                           &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "countryName",
        "population",
        "foundYear",
        "region"
})

@JsonRootName(value = "country")
public class Country {

    @XmlElement(required = true)
    @JsonProperty("countryName")
    protected String countryName;

    @JsonProperty("population")
    protected int population;

    @JsonProperty("foundYear")
    protected int foundYear;

    @JsonProperty("region")
    @XmlElement(required = true)
    protected List<Region> region;

    public Country() {
    }

    public Country(String countryName, int population, int foundYear, List<Region> region) {
        this.countryName = countryName;
        this.population = population;
        this.foundYear = foundYear;
        this.region = region;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the population property.
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Sets the value of the population property.
     */
    public void setPopulation(int value) {
        this.population = value;
    }

    /**
     * Gets the value of the foundYear property.
     */
    public int getFoundYear() {
        return foundYear;
    }

    /**
     * Sets the value of the foundYear property.
     */
    public void setFoundYear(int value) {
        this.foundYear = value;
    }

    /**
     * Gets the value of the region property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the region property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegion().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Region }
     */
    public List<Region> getRegion() {
        if (region == null) {
            region = new ArrayList<Region>();
        }
        return this.region;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + countryName + '\'' +
                ", population=" + population +
                ", foundYear=" + foundYear +
                ", region=" + region +
                '}';
    }
}


