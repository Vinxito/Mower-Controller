package com.seat.mower.infrastructure.persistence;

import com.seat.mower.application.update.orders.Order;
import com.seat.mower.domain.*;
import com.seat.shared.domain.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public final class InMemoryMowerRepository implements MowerRepository {

    private HashMap<String, Mower> mowers = new HashMap<>();

    @Override
    public void save(Mower mower) {
        mowers.put(String.format("%s,%s,%s",mower.positionY().value(), mower.positionY().value(), mower.facing().value()), mower);
    }

    @Override
    public void update(Mower mower, Order order) {
        mowers.remove(mower);
//        save(mower);
    }

    public List<Mower> all() {
        return new ArrayList<>(mowers.values());
    }

    @Override
    public Mower byPosition(MowerXPosition xPosition, MowerYPosition yPosition, CardinalPoint facing) {
       return mowers.get(String.format("%s,%s,%s", xPosition.value(), yPosition.value(), facing.value()));
    }

}
