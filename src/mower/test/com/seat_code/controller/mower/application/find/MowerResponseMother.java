package com.seat_code.controller.mower.application.find;

import com.seat_code.shared.domain.IntegerMother;
import com.seat_code.shared.domain.WordMother;

final class MowerResponseMother {
    public static MowerResponse create(Integer xSize, Integer ySize, String headFacing) {
        return new MowerResponse(xSize, ySize, headFacing);
    }

    public static MowerResponse random() {
        return create(IntegerMother.random(), IntegerMother.random(), WordMother.random());
    }
}
