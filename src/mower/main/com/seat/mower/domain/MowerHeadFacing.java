package com.seat.mower.domain;

import com.seat.shared.domain.StringValueObject;

public final class MowerHeadFacing extends StringValueObject {

    public MowerHeadFacing(String value) {
        super(value);
        MowerCardinalPoint.valueOf(value);
    }
}
