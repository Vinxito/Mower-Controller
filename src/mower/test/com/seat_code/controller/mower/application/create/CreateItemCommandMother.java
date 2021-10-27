package com.seat_code.controller.mower.application.create;

import com.seat_code.controller.mower.application.create.CreateMowerCommand;
import com.seat_code.controller.mower.domain.MowerHeadFacing;
import com.seat_code.controller.mower.domain.MowerXPosition;
import com.seat_code.controller.mower.domain.MowerYPosition;

public final class CreateItemCommandMother {
    public static CreateMowerCommand create(MowerXPosition xPosition, MowerYPosition yPosition, MowerHeadFacing facing) {
        return new CreateMowerCommand(xPosition.value(), yPosition.value(), facing.value());
    }

//    public static CreateMowerCommand random() {
//        return create(MowerYPositionMother.random(), MowerHeadFacingMother.random());
//    }
}
