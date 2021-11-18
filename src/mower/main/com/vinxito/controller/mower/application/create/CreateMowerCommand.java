package com.vinxito.controller.mower.application.create;

import com.vinxito.shared.domain.bus.command.Command;

public final class CreateMowerCommand implements Command {
    private final Integer xPosition;
    private final Integer yPosition;
    private final String headFacing;

    public CreateMowerCommand(Integer xPosition, Integer yPosition, String headFacing) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.headFacing = headFacing;
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
}
