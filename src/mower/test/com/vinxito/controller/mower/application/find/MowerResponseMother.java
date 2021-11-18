package com.vinxito.controller.mower.application.find;

import com.vinxito.shared.domain.IntegerMother;
import com.vinxito.shared.domain.WordMother;

final class MowerResponseMother {
    public static MowerResponse create(Integer xSize, Integer ySize, String headFacing) {
        return new MowerResponse(xSize, ySize, headFacing);
    }

    public static MowerResponse random() {
        return create(IntegerMother.random(), IntegerMother.random(), WordMother.random());
    }
}
