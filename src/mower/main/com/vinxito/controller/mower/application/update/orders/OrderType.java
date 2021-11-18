package com.vinxito.controller.mower.application.update.orders;


public enum OrderType {
    L("L"),
    R("R"),
    M("M");

    private String order;

    OrderType(String order) {
        this.order = order;
    }

    public static OrderType fromValue(String value) {
        switch (value) {
            case "L":
                return OrderType.L;
            case "R":
                return OrderType.R;
            case "M":
                return OrderType.M;
            default:
                return null;
        }
    }

    public static OrderType fromOrdinal(Integer position) {
        return OrderType.values()[position];
    }

    public String order() {
        return order;
    }
}
