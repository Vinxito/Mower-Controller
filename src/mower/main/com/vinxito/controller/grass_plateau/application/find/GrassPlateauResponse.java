package com.vinxito.controller.grass_plateau.application.find;

import com.vinxito.controller.grass_plateau.domain.GrassPlateau;
import com.vinxito.shared.domain.bus.query.Response;

import java.util.Objects;

public final class GrassPlateauResponse implements Response {
    private final Integer xSize;
    private final Integer ySize;

    public GrassPlateauResponse(Integer xSize, Integer ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public static GrassPlateauResponse fromAggregate(GrassPlateau grassPlateau) {
        return new GrassPlateauResponse(grassPlateau.xSize().value(), grassPlateau.ySize().value());
    }

    public Integer xSize() {
        return xSize;
    }

    public Integer ySize() {
        return ySize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrassPlateauResponse that = (GrassPlateauResponse) o;
        return xSize.equals(that.xSize) && ySize.equals(that.ySize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xSize, ySize);
    }
}
