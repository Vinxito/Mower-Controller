package com.seat_code.controller.grass_plateau.domain;

import com.seat_code.shared.domain.AggregateRoot;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrassPlateau that = (GrassPlateau) o;
        return xSize.equals(that.xSize) && ySize.equals(that.ySize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xSize, ySize);
    }
}
