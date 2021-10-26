package com.seat.grass_plateau.infrastructure.persistence;

import com.seat.grass_plateau.domain.*;
import com.seat.shared.domain.Service;

import java.util.Optional;

@Service
public final class InMemoryGrassPlateauRepository implements GrassPlateauRepository {

    private GrassPlateau grassPlateau = new GrassPlateau(new GrassPlateauX(0),
            new GrassPlateauY(0));

    @Override
    public Optional<GrassPlateau> search() {
        return Optional.of(grassPlateau);
    }

    @Override
    public void save(GrassPlateau grassPlateau) {
        this.grassPlateau = grassPlateau;
    }

}
