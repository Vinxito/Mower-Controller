package com.seat.grass_plateau.infrastructure.persistence;

import com.seat.grass_plateau.domain.*;
import com.seat.shared.domain.Service;

@Service
public final class InMemoryGrassPlateauRepository implements GrassPlateauRepository {

    private GrassPlateau grassPlateau;

    @Override
    public GrassPlateau search() {
        return grassPlateau;
    }

    @Override
    public void save(GrassPlateau grassPlateau) {
        this.grassPlateau = grassPlateau;
    }

}
