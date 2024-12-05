package com.saucelabs.enums;

public enum FilterOption {
    NAME_A_TO_Z("Name (A to Z)"),
    NAME_Z_TO_A("Name (Z to A)"),
    PRICE_LOW_TO_HIGH("Price (low to high)"),
    PRICE_HIGH_TO_LOW("Price (high to low)");



    private String value;


    private FilterOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
