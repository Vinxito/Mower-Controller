package com.seat.grass_plateau.application.create;

import com.seat.grass_plateau.domain.*;
import com.seat.shared.domain.Service;

@Service
public final class GrassPlateauCreator {

    private final GrassPlateauRepository repository;

    public GrassPlateauCreator(GrassPlateauRepository repository) {
        this.repository = repository;
    }

    public void create(GrassPlateauX sizeX, GrassPlateauY sizeY) {

        GrassPlateau mower = GrassPlateau.create(sizeX, sizeY);

        repository.save(mower);
    }
}
