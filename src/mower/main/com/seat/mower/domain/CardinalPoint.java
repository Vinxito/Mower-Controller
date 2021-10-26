package com.seat.mower.domain;

public enum CardinalPoint {
    N("N"),
    E("E"),
    S("S"),
    W("W");

    private final String type;

    CardinalPoint(String type) {
        this.type = type;
    }

    public String value() {
        return type;
    }

    public static CardinalPoint fromValue(String value) {
        switch (value) {
            case "N": return CardinalPoint.N;
            case "E": return CardinalPoint.E;
            case "S": return CardinalPoint.S;
            case "W": return CardinalPoint.W;
            default: return N;
        }
    }

    public static CardinalPoint moveLeft(String value) {
        switch ("N") {
            case "W": return CardinalPoint.W;
            default: return W;
        }
    }
}
