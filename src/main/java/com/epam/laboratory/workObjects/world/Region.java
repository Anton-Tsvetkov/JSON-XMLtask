package com.epam.laboratory.workObjects.world;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.*;

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
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="locality">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="index" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *                 &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "regionName",
        "locality"
})
public class Region {

    @XmlElement(required = true)
    @JsonProperty("regionName")
    protected String regionName;

    @XmlElement(required = true)
    @JsonProperty("locality")
    protected Locality locality;

    public Region() {
    }

    public Region(String regionName, Locality locality) {
        this.regionName = regionName;
        this.locality = locality;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * Sets the value of the name property.
     *
     * @param regionName
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * Gets the value of the locality property.
     *
     * @return
     *     possible object is
     *     {@link Locality }
     *
     */
    public Locality getLocality() {
        return locality;
    }

    /**
     * Sets the value of the locality property.
     *
     * @param value
     *     allowed object is
     *     {@link Locality }
     *
     */
    public void setLocality(Locality value) {
        this.locality = value;
    }

    @Override
    public String toString() {
        return "Region{" +
                "name=" + regionName +
                ", locality=" + locality +
                '}';
    }
}
