package com.seat_code.controller.mower.application.update;


import com.seat_code.controller.grass_plateau.application.find.GrassPlateauResponse;
import com.seat_code.shared.domain.IntegerMother;

final class GrassPlateauResponseMother {
    public static GrassPlateauResponse create(Integer xSize, Integer ySize) {
        return new GrassPlateauResponse(xSize, ySize);
    }

    public static GrassPlateauResponse random() {
        return create(IntegerMother.random(), IntegerMother.random());
    }
}
