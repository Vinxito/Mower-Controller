package com.seat.mower.domain;

import com.seat.mower.application.update.orders.Order;

import java.util.List;

public interface MowerRepository {
    void save(Mower item);

//    void update(Mower item);

    void update(Mower mower, Order order);

    List<Mower> all();

    Mower byPosition(MowerXPosition xPosition, MowerYPosition yPosition, CardinalPoint facing);
}
