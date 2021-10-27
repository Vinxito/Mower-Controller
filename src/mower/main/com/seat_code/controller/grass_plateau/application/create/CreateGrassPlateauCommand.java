package com.seat_code.controller.grass_plateau.application.create;

import com.seat_code.shared.domain.bus.command.Command;

public final class CreateGrassPlateauCommand implements Command {
    private final Integer xSize;
    private final Integer ySize;

    public CreateGrassPlateauCommand(Integer xSize, Integer ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public Integer xSize() {
        return xSize;
    }

    public Integer ySize() {
        return ySize;
    }
}
