package com.seat.mower.application.create;

import com.seat.mower.domain.CardinalPoint;
import com.seat.mower.domain.*;
import com.seat.shared.domain.Service;

@Service
public final class MowerCreator {

    private final MowerRepository repository;

    public MowerCreator(MowerRepository repository) {
        this.repository = repository;
    }

    public void create(MowerXPosition xPosition, MowerYPosition yPosition, CardinalPoint facing) {
        Mower mower = Mower.create(xPosition, yPosition, facing);

        repository.save(mower);
    }
}
