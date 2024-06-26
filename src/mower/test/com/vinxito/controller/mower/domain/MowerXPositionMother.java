package com.vinxito.controller.mower.domain;

import com.vinxito.shared.domain.IntegerMother;

public final class MowerXPositionMother {
    public static MowerXPosition create(Integer value) {
        return new MowerXPosition(value);
    }

    public static MowerXPosition random() {
        return create(IntegerMother.random());
    }
}
