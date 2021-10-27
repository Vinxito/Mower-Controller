package com.seat_code.controller.grass_plateau.application.find;

import com.seat_code.shared.domain.bus.query.Query;

import java.util.Objects;

public final class FindGrassPlateauQuery implements Query {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash("FindGrassPlateauQuery");
    }
}
