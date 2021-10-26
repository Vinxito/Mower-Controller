package com.seat.mower.application.update;

import com.seat.shared.domain.bus.command.Command;

public final class UpdateMowerCommand implements Command {
    private final Integer xPosition;
    private final Integer yPosition;
    private final String headFacing;
    private final String order;

    public UpdateMowerCommand(Integer xPosition, Integer yPosition, String headFacing, String order) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.headFacing = headFacing;
        this.order = order;
    }

    public Integer xPosition() {
        return xPosition;
    }

    public Integer yPosition() {
        return yPosition;
    }

    public String headFacing() {
        return headFacing;
    }

    public String order() {
        return order;
    }

}
