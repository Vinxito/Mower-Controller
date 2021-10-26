package com.seat.grass_plateau.application.search;

import com.seat.grass_plateau.domain.GrassPlateauRepository;
import com.seat.shared.domain.Service;

@Service
public final class GrassPlateauFinder {
    private final GrassPlateauRepository repository;

    public GrassPlateauFinder(GrassPlateauRepository repository) {
        this.repository = repository;
    }

    public GrassPlateauResponse find() {
        return repository.search().map(GrassPlateauResponse::fromAggregate).get();
    }
}
