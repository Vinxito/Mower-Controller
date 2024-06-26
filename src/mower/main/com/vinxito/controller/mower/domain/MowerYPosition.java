package com.vinxito.controller.mower.domain;

import com.vinxito.shared.domain.IntValueObject;

public final class MowerYPosition extends IntValueObject {
    public MowerYPosition(Integer value) {
        super(value);
    }

    public static MowerYPosition moveUp(MowerYPosition yPosition) {
        return new MowerYPosition(yPosition.value() + 1);
    }

    public static MowerYPosition moveDown(MowerYPosition yPosition) {
        return new MowerYPosition(yPosition.value() - 1);
    }
}
