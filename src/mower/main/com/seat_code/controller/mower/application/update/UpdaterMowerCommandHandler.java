package com.seat_code.controller.mower.application.update;

import com.seat_code.controller.mower.application.update.orders.Orders;
import com.seat_code.controller.mower.domain.MowerCardinalPoint;
import com.seat_code.controller.mower.domain.MowerXPosition;
import com.seat_code.controller.mower.domain.MowerYPosition;
import com.seat_code.shared.domain.Service;
import com.seat_code.shared.domain.bus.command.CommandHandler;

@Service
public final class UpdaterMowerCommandHandler implements CommandHandler<UpdateMowerCommand> {

    private final MowerUpdate updater;

    public UpdaterMowerCommandHandler(MowerUpdate updater) {
        this.updater = updater;
    }

    @Override
    public void handle(UpdateMowerCommand command) {
        MowerXPosition xPosition = new MowerXPosition(command.xPosition());
        MowerYPosition yPosition = new MowerYPosition(command.yPosition());
        MowerCardinalPoint facing = MowerCardinalPoint.fromValue(command.headFacing());

        Orders orders = Orders.fromValue(command.orders());

        updater.applyOrder(xPosition, yPosition , facing, orders);
    }
}