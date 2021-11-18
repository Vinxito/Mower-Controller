package com.vinxito.controller.grass_plateau.application.create;


import com.vinxito.controller.grass_plateau.domain.GrassPlateauXSize;
import com.vinxito.controller.grass_plateau.domain.GrassPlateauXSizeMother;
import com.vinxito.controller.grass_plateau.domain.GrassPlateauYSize;
import com.vinxito.controller.grass_plateau.domain.GrassPlateauYSizeMother;

public final class CreateGrassPlateauCommandMother {
    public static CreateGrassPlateauCommand create(GrassPlateauXSize xSize, GrassPlateauYSize ySize) {
        return new CreateGrassPlateauCommand(xSize.value(), ySize.value());
    }

    public static CreateGrassPlateauCommand random() {
        return create(GrassPlateauXSizeMother.random(), GrassPlateauYSizeMother.random());
    }
}
