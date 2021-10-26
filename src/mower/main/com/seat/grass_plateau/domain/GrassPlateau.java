package com.seat.grass_plateau.domain;

import com.seat.shared.domain.AggregateRoot;

public final class GrassPlateau extends AggregateRoot {
    private final GrassPlateauX xSize;
    private final GrassPlateauY ySize;

    public GrassPlateau() {
        xSize = null;
        ySize = null;
    }

    public GrassPlateau(GrassPlateauX xSize, GrassPlateauY ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public static GrassPlateau create(GrassPlateauX xSize, GrassPlateauY ySize) {
        return new GrassPlateau(xSize, ySize);
    }

    public GrassPlateauX xSize() {
        return xSize;
    }

    public GrassPlateauY ySize() {
        return ySize;
    }
}
