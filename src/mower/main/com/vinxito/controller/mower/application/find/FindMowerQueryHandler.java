package com.vinxito.controller.mower.application.find;

import com.vinxito.shared.domain.Service;
import com.vinxito.shared.domain.bus.query.QueryHandler;

@Service
public final class FindMowerQueryHandler implements QueryHandler<FindMowerQuery, MowersResponse> {
    private final MowerFinder finder;

    public FindMowerQueryHandler(MowerFinder finder) {
        this.finder = finder;
    }

    @Override
    public MowersResponse handle(FindMowerQuery query) {
        return finder.find();
    }
}
