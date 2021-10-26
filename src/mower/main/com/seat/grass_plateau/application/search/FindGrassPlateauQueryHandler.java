package com.seat.grass_plateau.application.search;

import com.seat.shared.domain.Service;
import com.seat.shared.domain.bus.query.QueryHandler;

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
