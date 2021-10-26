package com.seat.mower.application.update;

import com.seat.mower.application.update.orders.Order;
import com.seat.mower.domain.*;
import com.seat.shared.domain.Service;

@Service
public final class MowerUpdate {

    private final MowerRepository repository;

    public MowerUpdate(MowerRepository repository) {
        this.repository = repository;
    }

    public void apply(MowerXPosition xPosition, MowerYPosition yPosition, CardinalPoint facing, Order order) {

        Mower mower = repository.byPosition(xPosition, yPosition, facing);


        repository.update(mower, order);
    }
}
