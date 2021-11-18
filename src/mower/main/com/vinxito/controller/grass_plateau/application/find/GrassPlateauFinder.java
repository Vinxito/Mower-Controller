package com.vinxito.controller.grass_plateau.application.find;

import com.vinxito.controller.grass_plateau.domain.GrassPlateauRepository;
import com.vinxito.shared.domain.Service;

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
