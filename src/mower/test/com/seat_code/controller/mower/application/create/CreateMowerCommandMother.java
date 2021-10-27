package com.seat_code.controller.mower.application.create;

import com.seat_code.controller.mower.domain.*;

public final class CreateMowerCommandMother {

    public static CreateMowerCommand create(MowerXPosition xPosition, MowerYPosition yPosition, MowerCardinalPoint facing) {
        return new CreateMowerCommand(xPosition.value(), yPosition.value(), facing.value());
    }

    public static CreateMowerCommand random() {
        return create(MowerXPositionMother.random(), MowerYPositionMother.random(), MowerHeadFacingMother.random());
    }
}
