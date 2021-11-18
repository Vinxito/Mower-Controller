package com.vinxito.controller.mower.application.create;

import com.vinxito.controller.mower.domain.*;
import com.vinxito.shared.domain.Service;
import com.vinxito.controller.mower.domain.*;

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
