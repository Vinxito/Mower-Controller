package com.vinxito.controller.grass_plateau.domain;

import com.vinxito.shared.domain.IntegerMother;

public final class GrassPlateauXSizeMother {
    public static GrassPlateauXSize create(Integer value) {
        return new GrassPlateauXSize(value);
    }

    public static GrassPlateauXSize random() {
        return create(IntegerMother.random());
    }
}
