package com.javalesson.oop;

public enum Size {

    VERY_SMALL("XS"), SMALL("S"), AVERAGE("M"), VERY_BIG("L"), BIG("XL"), UNDEFINED("");

    private String abbreviation;

    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
