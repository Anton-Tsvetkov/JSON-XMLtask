package com.epam.laboratory.workObjects.world;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;

/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="index" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class Locality {

    @XmlAttribute(name = "index", required = true)
    @JsonProperty("index")
    protected int index;

    @JsonProperty("type")
    @XmlAttribute(name = "type", required = true)
    protected String type;

    public Locality() {
    }

    public Locality(int index, String type) {
        this.index = index;
        this.type = type;
    }

    /**
     * Gets the value of the index property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     *
     * @param value
     *     allowed object is
     *     {@link int }
     *
     */
    public void setIndex(int value) {
        this.index = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setType(String value) {
        this.type = value;
    }

    @Override
    public String toString() {
        return "Locality{" +
                "index=" + index +
                ", type='" + type + '\'' +
                '}';
    }
}
