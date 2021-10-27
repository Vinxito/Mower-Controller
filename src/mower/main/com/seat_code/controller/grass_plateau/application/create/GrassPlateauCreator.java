package com.seat_code.controller.grass_plateau.application.create;

import com.seat_code.controller.grass_plateau.domain.GrassPlateau;
import com.seat_code.controller.grass_plateau.domain.GrassPlateauRepository;
import com.seat_code.controller.grass_plateau.domain.GrassPlateauXSize;
import com.seat_code.controller.grass_plateau.domain.GrassPlateauYSize;
import com.seat_code.shared.domain.Service;

@Service
public final class GrassPlateauCreator {

    private final GrassPlateauRepository repository;

    public GrassPlateauCreator(GrassPlateauRepository repository) {
        this.repository = repository;
    }

    public void create(GrassPlateauXSize sizeX, GrassPlateauYSize sizeY) {

        GrassPlateau grassPlateau = GrassPlateau.create(sizeX, sizeY);

        repository.save(grassPlateau);
    }
}
