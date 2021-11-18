package com.vinxito.controller.mower.application.update;

import com.vinxito.controller.mower.application.update.orders.OrderType;
import com.vinxito.controller.mower.domain.*;

import java.util.List;
import java.util.Random;

public final class UpdateMowerCommandMother {
    public static UpdateMowerCommand create(MowerXPosition xPosition,
                                            MowerYPosition yPosition,
                                            MowerCardinalPoint facing,
                                            List<String> orders) {
        return new UpdateMowerCommand(xPosition.value(), yPosition.value(), facing.value(), orders);
    }

    public static UpdateMowerCommand random() {
        return create(MowerXPositionMother.random(),
                MowerYPositionMother.random(),
                MowerHeadFacingMother.random(),
                List.of(OrderType.fromOrdinal(new Random().nextInt(3)).name()));
    }
}
