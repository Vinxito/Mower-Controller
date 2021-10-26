package com.seat.grass_plateau.domain;

import com.seat.shared.domain.AggregateRoot;

public final class GrassPlateau extends AggregateRoot {
    private final GrassPlateauX positionX;
    private final GrassPlateauY positionY;

    public GrassPlateau() {
        positionX = null;
        positionY = null;
    }

    public GrassPlateau(GrassPlateauX positionX, GrassPlateauY positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public static GrassPlateau create(GrassPlateauX positionX, GrassPlateauY positionY) {
        return new GrassPlateau(positionX, positionY);
    }

    public GrassPlateauX positionX() {
        return positionX;
    }

    public GrassPlateauY positionY() {
        return positionY;
    }
}
