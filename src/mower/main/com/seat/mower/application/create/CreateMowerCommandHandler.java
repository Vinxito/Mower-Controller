package com.seat.mower.application.create;

import com.seat.mower.domain.CardinalPoint;
import com.seat.mower.domain.MowerXPosition;
import com.seat.mower.domain.MowerYPosition;
import com.seat.shared.domain.Service;
import com.seat.shared.domain.bus.command.CommandHandler;

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
        CardinalPoint facing = CardinalPoint.fromValue(command.headFacing());

        creator.create(xPosition, yPosition, facing);
    }
}
