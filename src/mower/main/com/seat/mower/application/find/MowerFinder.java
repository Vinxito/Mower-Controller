package com.seat.mower.application.find;

import com.seat.mower.domain.MowerRepository;
import com.seat.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class MowerFinder {
    private final MowerRepository repository;

    public MowerFinder(MowerRepository repository) {
        this.repository = repository;
    }

    public MowersResponse find() {
        return new MowersResponse(
                repository.all().stream().map(MowerResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
