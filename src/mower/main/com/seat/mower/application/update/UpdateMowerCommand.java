package com.seat.mower.application.update;

import com.seat.shared.domain.bus.command.Command;

import java.util.List;

public final class UpdateMowerCommand implements Command {
    private final Integer xPosition;
    private final Integer yPosition;
    private final String headFacing;
    private final List<String> orders;

    public UpdateMowerCommand(Integer xPosition, Integer yPosition, String headFacing, List<String> orders) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.headFacing = headFacing;
        this.orders = orders;
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

    public List<String> orders() {
        return orders;
    }

}
