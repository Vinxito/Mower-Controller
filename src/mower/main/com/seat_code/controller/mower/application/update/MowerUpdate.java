package com.seat_code.controller.mower.application.update;

import com.seat_code.controller.grass_plateau.application.find.FindGrassPlateauQuery;
import com.seat_code.controller.grass_plateau.application.find.GrassPlateauResponse;
import com.seat_code.controller.grass_plateau.domain.GrassPlateauXSize;
import com.seat_code.controller.grass_plateau.domain.GrassPlateauYSize;
import com.seat_code.controller.mower.application.update.orders.Order;
import com.seat_code.controller.mower.application.update.orders.Orders;
import com.seat_code.shared.domain.Service;
import com.seat_code.shared.domain.bus.query.QueryBus;
import com.seat_code.controller.mower.domain.*;

@Service
public final class MowerUpdate {

    private final MowerRepository mowerRepository;
    private final QueryBus queryBus;

    public MowerUpdate(MowerRepository mowerRepository, QueryBus queryBus) {
        this.mowerRepository = mowerRepository;
        this.queryBus = queryBus;
    }

    public void applyOrder(MowerXPosition xPosition, MowerYPosition yPosition, MowerCardinalPoint facing, Orders orders) {

        Mower mower = mowerRepository.byPosition(xPosition, yPosition, facing);

        GrassPlateauResponse grassPlateauResponse = queryBus.ask(new FindGrassPlateauQuery());

        for (Order order: orders.orders()) {
            switch (order.type().order()) {
                case "L": mower = mower.turnLeft(); break;
                case "R": mower = mower.turnRight(); break;
                case "M": mower = mower.move(
                        new GrassPlateauXSize(grassPlateauResponse.xSize()),
                        new GrassPlateauYSize(grassPlateauResponse.ySize())); break;
            }
        }

        mowerRepository.update(xPosition, yPosition, facing, mower);
    }
}
