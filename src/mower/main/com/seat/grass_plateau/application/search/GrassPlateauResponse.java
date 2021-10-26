package com.seat.grass_plateau.application.search;

import com.seat.grass_plateau.domain.GrassPlateau;
import com.seat.shared.domain.bus.query.Response;

public final class GrassPlateauResponse implements Response {
    private final Integer xSize;
    private final Integer ySize;

    public GrassPlateauResponse(Integer xSize, Integer ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public Integer xSize() {
        return xSize;
    }

    public Integer ySize() {
        return ySize;
    }

    public static GrassPlateauResponse fromAggregate(GrassPlateau grassPlateau) {
        return new GrassPlateauResponse(grassPlateau.xSize().value(), grassPlateau.ySize().value());
    }

}
