package com.epam.laboratory.workObjects.gem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="color" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numberOfFaces" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="transparency" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "color",
        "numberOfFaces",
        "transparency"
})
public class VisualParameters {


    public VisualParameters(String color, byte numberOfFaces, float transparency) {
        this.color = color;
        this.numberOfFaces = numberOfFaces;
        this.transparency = transparency;
    }

    public VisualParameters(){
        this.color = "color";
        this.numberOfFaces = 0;
        this.transparency = 0;
    }

    @XmlElement(required = true)
    protected String color;
    protected byte numberOfFaces;
    protected float transparency;


    /**
     * Sets the value of the visualParameters property.
     *
     * @params color, numberOfFaces, transparency allowed object is
     *              {@link VisualParameters }
     */
    public void setVisualParameters(String color, Byte numberOfFaces, Float transparency) {
        this.color = color;
        this.numberOfFaces = numberOfFaces;
        this.transparency = transparency;
    }

    /**
     * Gets the value of the color property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setColor(String value) {
        this.color = value;
    }

    /**
     * Gets the value of the numberOfFaces property.
     */
    public byte getNumberOfFaces() {
        return numberOfFaces;
    }

    /**
     * Sets the value of the numberOfFaces property.
     */
    public void setNumberOfFaces(byte value) {
        this.numberOfFaces = value;
    }

    /**
     * Gets the value of the transparency property.
     */
    public float getTransparency() {
        return transparency;
    }

    /**
     * Sets the value of the transparency property.
     */
    public void setTransparency(float value) {
        this.transparency = value;
    }

    @Override
    public String toString() {
        return "VisualParameters{" +
                "color='" + color + '\'' +
                ", numberOfFaces=" + numberOfFaces +
                ", transparency=" + transparency +
                '}';
    }
}
