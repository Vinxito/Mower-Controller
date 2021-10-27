package com.seat_code.controller.mower.application.find;

import com.seat_code.controller.mower.domain.Mower;
import com.seat_code.shared.domain.bus.query.Response;

public final class MowerResponse implements Response {
    private final Integer xPosition;
    private final Integer yPosition;
    private final String headFacing;

    public MowerResponse(Integer xPosition, Integer yPosition, String headFacing) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.headFacing = headFacing;
    }

    public String headFacing() {
        return headFacing;
    }

    public Integer xPosition() {
        return xPosition;
    }

    public Integer yPosition() {
        return yPosition;
    }

    public static MowerResponse fromAggregate(Mower mower) {
        return new MowerResponse(mower.xPosition().value(), mower.yPosition().value(), mower.facing().value());
    }

}
