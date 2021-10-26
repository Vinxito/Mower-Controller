package com.seat.mower.application.update;

import com.seat.grass_plateau.domain.GrassPlateau;
import com.seat.grass_plateau.domain.GrassPlateauRepository;
import com.seat.mower.application.update.orders.Order;
import com.seat.mower.application.update.orders.Orders;
import com.seat.mower.domain.*;
import com.seat.shared.domain.Service;

@Service
public final class MowerUpdate {

    private final MowerRepository mowerRepository;
    private final GrassPlateauRepository grassPlateauRepository;

    public MowerUpdate(MowerRepository mowerRepository, GrassPlateauRepository grassPlateauRepository) {
        this.mowerRepository = mowerRepository;
        this.grassPlateauRepository = grassPlateauRepository;
    }

    public void applyOrder(MowerXPosition xPosition, MowerYPosition yPosition, MowerCardinalPoint facing, Orders orders) {

        Mower mower = mowerRepository.byPosition(xPosition, yPosition, facing);

        GrassPlateau grassPlateau = grassPlateauRepository.search();

        for (Order order: orders.orders()) {
            switch (order.type().order()) {
                case "L": mower = mower.turnLeft(); break;
                case "R": mower = mower.turnRight(); break;
                case "M": mower = mower.move(grassPlateau); break;
            }
        }

        mowerRepository.update(xPosition, yPosition, facing, mower);
    }
}
