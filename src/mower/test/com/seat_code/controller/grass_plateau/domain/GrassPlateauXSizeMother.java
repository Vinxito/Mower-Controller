package com.seat_code.controller.grass_plateau.domain;

import com.seat_code.shared.domain.IntegerMother;

public final class GrassPlateauXSizeMother {
    public static GrassPlateauXSize create(Integer value) {
        return new GrassPlateauXSize(value);
    }

    public static GrassPlateauXSize random() {
        return create(IntegerMother.random());
    }
}
