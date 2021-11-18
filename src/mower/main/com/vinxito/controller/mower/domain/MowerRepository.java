package com.vinxito.controller.mower.domain;

import java.util.List;

public interface MowerRepository {
    void save(Mower item);

    void update(MowerXPosition xPosition, MowerYPosition yPosition, MowerCardinalPoint facing, Mower mowerUpdated);

    List<Mower> all();

    Mower byPosition(MowerXPosition xPosition, MowerYPosition yPosition, MowerCardinalPoint facing);
}
