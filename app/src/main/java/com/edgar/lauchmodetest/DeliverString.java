package com.edgar.lauchmodetest;

public class DeliverString {

    private static final DeliverString instance = new DeliverString();

    private String deliverString = "";

    private DeliverString() {}

    public static DeliverString getInstance() {
        return instance;
    }

    public void setDeliverString(String deliverString) {
        this.deliverString = deliverString;
    }

    public String getDeliverString() {
        return "Info: " + deliverString;
    }
}
