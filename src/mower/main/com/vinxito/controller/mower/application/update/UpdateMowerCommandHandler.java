package com.vinxito.controller.mower.application.update;

import com.vinxito.controller.mower.application.update.orders.Orders;
import com.vinxito.controller.mower.domain.MowerCardinalPoint;
import com.vinxito.controller.mower.domain.MowerXPosition;
import com.vinxito.controller.mower.domain.MowerYPosition;
import com.vinxito.shared.domain.Service;
import com.vinxito.shared.domain.bus.command.CommandHandler;

@Service
public final class UpdateMowerCommandHandler implements CommandHandler<UpdateMowerCommand> {

    private final MowerUpdate updater;

    public UpdateMowerCommandHandler(MowerUpdate updater) {
        this.updater = updater;
    }

    @Override
    public void handle(UpdateMowerCommand command) {
        MowerXPosition xPosition = new MowerXPosition(command.xPosition());
        MowerYPosition yPosition = new MowerYPosition(command.yPosition());
        MowerCardinalPoint facing = MowerCardinalPoint.fromValue(command.headFacing());

        Orders orders = Orders.fromValue(command.orders());

        updater.applyOrder(xPosition, yPosition, facing, orders);
    }
}
