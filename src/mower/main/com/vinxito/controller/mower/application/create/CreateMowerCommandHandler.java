package com.vinxito.controller.mower.application.create;

import com.vinxito.controller.mower.domain.MowerCardinalPoint;
import com.vinxito.controller.mower.domain.MowerXPosition;
import com.vinxito.controller.mower.domain.MowerYPosition;
import com.vinxito.shared.domain.Service;
import com.vinxito.shared.domain.bus.command.CommandHandler;

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
