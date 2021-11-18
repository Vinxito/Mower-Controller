package com.vinxito.controller.mower.domain;

import com.vinxito.shared.domain.StringValueObject;

public final class MowerHeadFacing extends StringValueObject {

    public MowerHeadFacing(String value) {
        super(value);
        MowerCardinalPoint.valueOf(value);
    }
}
