package com.seat.mower.domain;

import com.seat.mower.application.update.orders.Order;
import com.seat.shared.domain.AggregateRoot;

public final class Mower extends AggregateRoot {

    private final MowerXPosition positionX;
    private final MowerYPosition positionY;
    private final CardinalPoint facing;

    public Mower(MowerXPosition positionX, MowerYPosition positionY, CardinalPoint facing) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.facing = facing;
    }

    public Mower() {
        this.positionX = null;
        this.positionY = null;
        this.facing = null;
    }

    public static Mower create(MowerXPosition positionX, MowerYPosition positionY, CardinalPoint facing) {
        return new Mower(positionX, positionY, facing);
    }

    public void turnLeft(MowerHeadFacing facing){


    }

    public void turnRight(){



    }

    public void move(){



    }

    public MowerXPosition positionX() {
        return positionX;
    }

    public MowerYPosition positionY() {
        return positionY;
    }

    public CardinalPoint facing() {
        return facing;
    }

}
