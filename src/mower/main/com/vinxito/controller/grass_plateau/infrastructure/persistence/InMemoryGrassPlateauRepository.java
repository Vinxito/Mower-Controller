package com.vinxito.controller.grass_plateau.infrastructure.persistence;

import com.vinxito.controller.grass_plateau.domain.GrassPlateau;
import com.vinxito.controller.grass_plateau.domain.GrassPlateauRepository;
import com.vinxito.controller.grass_plateau.domain.GrassPlateauXSize;
import com.vinxito.controller.grass_plateau.domain.GrassPlateauYSize;
import com.vinxito.shared.domain.Service;

import java.util.Optional;

@Service
public final class InMemoryGrassPlateauRepository implements GrassPlateauRepository {

    private GrassPlateau grassPlateau = new GrassPlateau(
            new GrassPlateauXSize(0),
            new GrassPlateauYSize(0));

    @Override
    public Optional<GrassPlateau> search() {
        return Optional.of(grassPlateau);
    }

    @Override
    public void save(GrassPlateau grassPlateau) {
        this.grassPlateau = grassPlateau;
    }

}
