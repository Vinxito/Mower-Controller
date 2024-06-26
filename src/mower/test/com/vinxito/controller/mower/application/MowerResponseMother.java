package com.vinxito.controller.mower.application;

import com.vinxito.controller.mower.application.find.MowerResponse;
import com.vinxito.controller.mower.domain.*;
import com.vinxito.controller.mower.domain.*;

public final class MowerResponseMother {
    public static MowerResponse create(MowerXPosition xPosition, MowerYPosition yPosition, MowerCardinalPoint headFacing) {
        return new MowerResponse(xPosition.value(), yPosition.value(), headFacing.toString());
    }

    public static MowerResponse random() {
        return create(MowerXPositionMother.random(), MowerYPositionMother.random(), MowerHeadFacingMother.random());
    }
}
