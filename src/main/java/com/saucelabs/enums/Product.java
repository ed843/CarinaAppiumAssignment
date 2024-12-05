package com.saucelabs.enums;

public enum Product {
    BACKPACK("Sauce Labs Backpack"),
    BIKE_LIGHT("Sauce Labs Bike Light"),
    BOLT_TSHIRT("Sauce Labs Bolt T-Shirt"),
    FLEECE_JACKET("Sauce Labs Fleece Jacket"),
    ONESIE("Sauce Labs Onesie"),
    TESTALLTHINGS_TSHIRT("Test.allTheThings() T-Shirt (Red)");


    private String value;


    private Product(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
