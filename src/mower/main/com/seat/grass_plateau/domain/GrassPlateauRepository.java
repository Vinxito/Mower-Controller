package com.seat.grass_plateau.domain;

public interface GrassPlateauRepository {
    GrassPlateau search();

    void save(GrassPlateau grassPlateau);
}
