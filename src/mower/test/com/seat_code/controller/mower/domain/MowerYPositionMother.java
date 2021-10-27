package com.seat_code.controller.mower.domain;

import com.seat_code.shared.domain.IntegerMother;

public final class MowerYPositionMother {
    public static MowerYPosition create(Integer value) {
        return new MowerYPosition(value);
    }

    public static MowerYPosition random() {
        return create(IntegerMother.random());
    }
}
