package com.seat_code.controller.mower.application.create;

import com.seat_code.controller.mower.domain.MowerCardinalPoint;
import com.seat_code.shared.domain.Service;
import com.seat_code.controller.mower.domain.*;

@Service
public final class MowerCreator {

    private final MowerRepository repository;

    public MowerCreator(MowerRepository repository) {
        this.repository = repository;
    }

    public void create(MowerXPosition xPosition, MowerYPosition yPosition, MowerCardinalPoint facing) {
        Mower mower = Mower.create(xPosition, yPosition, facing);

        repository.save(mower);
    }
}
