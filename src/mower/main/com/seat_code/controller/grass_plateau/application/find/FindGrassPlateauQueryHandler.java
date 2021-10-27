package com.seat_code.controller.grass_plateau.application.find;

import com.seat_code.shared.domain.Service;
import com.seat_code.shared.domain.bus.query.QueryHandler;

@Service
public final class FindGrassPlateauQueryHandler implements QueryHandler<FindGrassPlateauQuery, GrassPlateauResponse> {
    private final GrassPlateauFinder finder;

    public FindGrassPlateauQueryHandler(GrassPlateauFinder finder) {
        this.finder = finder;
    }

    @Override
    public GrassPlateauResponse handle(FindGrassPlateauQuery query) {
        return finder.find();
    }
}
