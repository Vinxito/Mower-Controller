package com.seat_code.controller.grass_plateau.application.search;

import com.seat_code.controller.grass_plateau.domain.GrassPlateauRepository;
import com.seat_code.shared.domain.Service;

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
