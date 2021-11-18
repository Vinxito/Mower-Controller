package com.vinxito.controller.grass_plateau.domain;


import com.vinxito.shared.domain.IntegerMother;

public final class GrassPlateauYSizeMother {
    public static GrassPlateauYSize create(Integer value) {
        return new GrassPlateauYSize(value);
    }

    public static GrassPlateauYSize random() {
        return create(IntegerMother.random());
    }

}
