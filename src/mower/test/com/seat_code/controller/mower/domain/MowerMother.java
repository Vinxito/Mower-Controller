package com.seat_code.controller.mower.domain;

import com.seat_code.controller.mower.application.create.CreateMowerCommand;

public final class MowerMother {

    public static Mower create(MowerXPosition xPosition, MowerYPosition YPosition, MowerCardinalPoint facing) {
        return new Mower(xPosition, YPosition, facing);
    }

    public static Mower fromRequest(CreateMowerCommand request) {
        return create(
                MowerXPositionMother.create(request.xPosition()),
                MowerYPositionMother.create(request.yPosition()),
                MowerHeadFacingMother.create(request.headFacing())
        );
    }

    public static Mower random() {
        return create(MowerXPositionMother.random(), MowerYPositionMother.random(), MowerHeadFacingMother.random());
    }
}
