package com.vinxito.controller.grass_plateau.application.create;

import com.vinxito.controller.grass_plateau.domain.GrassPlateau;
import com.vinxito.controller.grass_plateau.domain.GrassPlateauRepository;
import com.vinxito.controller.grass_plateau.domain.GrassPlateauXSize;
import com.vinxito.controller.grass_plateau.domain.GrassPlateauYSize;
import com.vinxito.shared.domain.Service;

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
