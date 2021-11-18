package com.vinxito.controller.grass_plateau.domain;


import com.vinxito.controller.grass_plateau.application.create.CreateGrassPlateauCommand;

public final class GrassPlateauMother {
    public static GrassPlateau create(GrassPlateauXSize xSize, GrassPlateauYSize ySize) {
        return new GrassPlateau(xSize, ySize);
    }

    public static GrassPlateau fromRequest(CreateGrassPlateauCommand request) {
        return create(
                GrassPlateauXSizeMother.create(request.xSize()),
                GrassPlateauYSizeMother.create(request.ySize()));
    }

    public static GrassPlateau random() {
        return create(GrassPlateauXSizeMother.random(), GrassPlateauYSizeMother.random());
    }
}
