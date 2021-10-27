package com.seat_code.controller.grass_plateau.domain;


import com.seat_code.shared.domain.IntegerMother;

public final class GrassPlateauYSizeMother {
    public static GrassPlateauYSize create(Integer value) {
        return new GrassPlateauYSize(value);
    }

    public static GrassPlateauYSize random() {
        return create(IntegerMother.random());
    }

}
