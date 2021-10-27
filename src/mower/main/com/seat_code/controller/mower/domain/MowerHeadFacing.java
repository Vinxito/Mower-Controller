package com.seat_code.controller.mower.domain;

import com.seat_code.shared.domain.StringValueObject;

public final class MowerHeadFacing extends StringValueObject {

    public MowerHeadFacing(String value) {
        super(value);
        MowerCardinalPoint.valueOf(value);
    }
}
