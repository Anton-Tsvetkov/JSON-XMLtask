package com.epam.laboratory.workObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Gem {

    @JsonProperty("VisualParams")
    protected String[] VisualParams;

    protected String color;
    protected String preciousness;
    protected int numberOfFaces;
    protected String origin;
    protected int transparency;
    protected String name;
    protected String id;
    protected double value;

    public String[] getVisualParams() {
        return VisualParams;
    }

    public void setVisualParams(String[] visualParams) {
        VisualParams = visualParams;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public int getNumberOfFaces() {
        return numberOfFaces;
    }

    public void setNumberOfFaces(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Gem{" +
                "visualParams='" + VisualParams + '\'' +
                ", color='" + color + '\'' +
                ", preciousness='" + preciousness + '\'' +
                ", numberOfFaces=" + numberOfFaces +
                ", origin='" + origin + '\'' +
                ", transparency=" + transparency +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", value=" + value +
                '}';
    }
}
