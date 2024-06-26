package com.vinxito.controller.grass_plateau.domain;

import java.util.Optional;

public interface GrassPlateauRepository {
    Optional<GrassPlateau> search();

    void save(GrassPlateau grassPlateau);
}
