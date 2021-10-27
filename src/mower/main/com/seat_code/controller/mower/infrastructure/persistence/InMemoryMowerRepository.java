package com.seat_code.controller.mower.infrastructure.persistence;

import com.seat_code.shared.domain.Service;
import com.seat_code.controller.mower.domain.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public final class InMemoryMowerRepository implements MowerRepository {

    private HashMap<String, Mower> mowers = new HashMap<>();

    @Override
    public void save(Mower mower) {
        mowers.put(String.format("%s,%s,%s",mower.xPosition().value(), mower.yPosition().value(), mower.facing().value()), mower);
    }

    @Override
    public void update(MowerXPosition xPosition, MowerYPosition yPosition, MowerCardinalPoint facing, Mower mowerUpdated) {
        mowers.remove(String.format("%s,%s,%s", xPosition.value(), yPosition.value(), facing.value()));
        save(mowerUpdated);
    }

    @Override
    public List<Mower> all() {
        return new ArrayList<>(mowers.values());
    }


    public Mower byPosition(MowerXPosition xPosition, MowerYPosition yPosition, MowerCardinalPoint facing) {
       return mowers.get(String.format("%s,%s,%s", xPosition.value(), yPosition.value(), facing.value()));
    }

}