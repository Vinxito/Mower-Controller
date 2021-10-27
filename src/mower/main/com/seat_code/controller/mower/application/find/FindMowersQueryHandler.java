package com.seat_code.controller.mower.application.find;

import com.seat_code.shared.domain.Service;
import com.seat_code.shared.domain.bus.query.QueryHandler;

@Service
public final class FindMowersQueryHandler implements QueryHandler<FindMowersQuery, MowersResponse> {
    private final MowerFinder finder;

    public FindMowersQueryHandler(MowerFinder finder) {
        this.finder = finder;
    }

    @Override
    public MowersResponse handle(FindMowersQuery query) {
        return finder.find();
    }
}
