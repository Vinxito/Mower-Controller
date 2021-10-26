package com.seat.mower.application.create;

import com.seat.mower.domain.*;

public final class CreateItemCommandMother {
    public static CreateMowerCommand create(MowerXPosition xPosition, MowerYPosition yPosition, MowerHeadFacing facing) {
        return new CreateMowerCommand(xPosition.value(), yPosition.value(), facing.value());
    }

//    public static CreateMowerCommand random() {
//        return create(MowerYPositionMother.random(), MowerHeadFacingMother.random());
//    }
}
