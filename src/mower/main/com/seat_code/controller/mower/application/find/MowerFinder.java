package com.seat_code.controller.mower.application.find;

import com.seat_code.controller.mower.domain.MowerRepository;
import com.seat_code.shared.domain.Service;

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
