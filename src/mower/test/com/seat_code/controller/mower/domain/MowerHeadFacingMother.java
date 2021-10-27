package com.seat_code.controller.mower.domain;

import java.util.Random;


public final class MowerHeadFacingMother {
    public static MowerCardinalPoint create(String value) {
        return MowerCardinalPoint.fromValue(value);
    }

    public static MowerCardinalPoint random() {
        return create(MowerCardinalPoint.fromOrdinal(new Random().nextInt(4)).value());
    }
}
