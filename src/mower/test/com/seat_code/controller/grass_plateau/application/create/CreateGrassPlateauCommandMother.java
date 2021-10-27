package com.seat_code.controller.grass_plateau.application.create;


import com.seat_code.controller.grass_plateau.domain.GrassPlateauXSize;
import com.seat_code.controller.grass_plateau.domain.GrassPlateauXSizeMother;
import com.seat_code.controller.grass_plateau.domain.GrassPlateauYSize;
import com.seat_code.controller.grass_plateau.domain.GrassPlateauYSizeMother;

public final class CreateGrassPlateauCommandMother {
    public static CreateGrassPlateauCommand create(GrassPlateauXSize xSize, GrassPlateauYSize ySize) {
        return new CreateGrassPlateauCommand(xSize.value(), ySize.value());
    }

    public static CreateGrassPlateauCommand random() {
        return create(GrassPlateauXSizeMother.random(), GrassPlateauYSizeMother.random());
    }
}
