package com.seat_code.controller.mower.application.create;

import com.seat_code.controller.mower.domain.MowerCardinalPoint;
import com.seat_code.controller.mower.domain.MowerXPosition;
import com.seat_code.controller.mower.domain.MowerYPosition;
import com.seat_code.shared.domain.Service;
import com.seat_code.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateMowerCommandHandler implements CommandHandler<CreateMowerCommand> {
    private final MowerCreator creator;

    public CreateMowerCommandHandler(MowerCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateMowerCommand command) {
        MowerXPosition xPosition = new MowerXPosition(command.xPosition());
        MowerYPosition yPosition = new MowerYPosition(command.yPosition());
        MowerCardinalPoint facing = MowerCardinalPoint.fromValue(command.headFacing());

        creator.create(xPosition, yPosition, facing);
    }
}
