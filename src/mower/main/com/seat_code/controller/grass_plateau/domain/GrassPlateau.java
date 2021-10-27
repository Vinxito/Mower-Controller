package com.seat_code.controller.grass_plateau.domain;

import com.seat_code.shared.domain.AggregateRoot;

public final class GrassPlateau extends AggregateRoot {
    private final GrassPlateauXSize xSize;
    private final GrassPlateauYSize ySize;

    public GrassPlateau() {
        xSize = null;
        ySize = null;
    }

    public GrassPlateau(GrassPlateauXSize xSize, GrassPlateauYSize ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public static GrassPlateau create(GrassPlateauXSize xSize, GrassPlateauYSize ySize) {
        return new GrassPlateau(xSize, ySize);
    }

    public GrassPlateauXSize xSize() {
        return xSize;
    }

    public GrassPlateauYSize ySize() {
        return ySize;
    }
}
