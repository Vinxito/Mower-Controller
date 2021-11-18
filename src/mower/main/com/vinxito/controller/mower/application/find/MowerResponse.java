package com.vinxito.controller.mower.application.find;

import com.vinxito.controller.mower.domain.Mower;
import com.vinxito.shared.domain.bus.query.Response;

import java.util.Objects;

public final class MowerResponse implements Response {
    private final Integer xPosition;
    private final Integer yPosition;
    private final String headFacing;

    public MowerResponse(Integer xPosition, Integer yPosition, String headFacing) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.headFacing = headFacing;
    }

    public static MowerResponse fromAggregate(Mower mower) {
        return new MowerResponse(mower.xPosition().value(), mower.yPosition().value(), mower.facing().value());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MowerResponse that = (MowerResponse) o;
        return xPosition.equals(that.xPosition) && yPosition.equals(that.yPosition) && headFacing.equals(that.headFacing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPosition, yPosition, headFacing);
    }
}
