package com.seat.mower.domain;

import com.seat.shared.domain.IntValueObject;

public final class MowerXPosition extends IntValueObject {

    public MowerXPosition(Integer value) {
        super(value);
    }

    public static MowerXPosition moveLeft(MowerXPosition xPosition) {
        return new MowerXPosition(xPosition.value() - 1);
    }

    public static MowerXPosition moveRight(MowerXPosition xPosition) {
        return new MowerXPosition(xPosition.value() + 1);
    }

}
