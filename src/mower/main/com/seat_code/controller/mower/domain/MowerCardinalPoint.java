package com.seat_code.controller.mower.domain;

public enum MowerCardinalPoint {
    N("N"),
    E("E"),
    S("S"),
    W("W");

    private final String type;

    MowerCardinalPoint(String type) {
        this.type = type;
    }

    public static MowerCardinalPoint fromValue(String value) {
        switch (value) {
            case "N":
                return MowerCardinalPoint.N;
            case "E":
                return MowerCardinalPoint.E;
            case "S":
                return MowerCardinalPoint.S;
            case "W":
                return MowerCardinalPoint.W;
            default:
                return N;
        }
    }

    public static MowerCardinalPoint fromOrdinal(Integer position) {
        return MowerCardinalPoint.values()[position];
    }

    public static MowerCardinalPoint moveLeft(String value) {

        MowerCardinalPoint point = fromValue(value);

        if (point.value().equals("N")) {
            return MowerCardinalPoint.W;
        }

        return MowerCardinalPoint.fromOrdinal(point.ordinal() - 1);
    }

    public static MowerCardinalPoint moveRight(String value) {

        MowerCardinalPoint point = fromValue(value);

        if (point.value().equals("W")) {
            return MowerCardinalPoint.N;
        }

        return MowerCardinalPoint.fromOrdinal(point.ordinal() + 1);
    }

    public String value() {
        return type;
    }
}
