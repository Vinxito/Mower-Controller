package com.seat.mower.application.update;

import com.seat.mower.application.update.orders.Order;
import com.seat.mower.domain.CardinalPoint;
import com.seat.mower.domain.MowerXPosition;
import com.seat.mower.domain.MowerYPosition;
import com.seat.shared.domain.Service;
import com.seat.shared.domain.bus.command.CommandHandler;

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
        CardinalPoint facing = CardinalPoint.fromValue(command.headFacing());
        Order order = Order.fromValue(command.order());

        updater.apply(xPosition, yPosition , facing, order);
    }
}
