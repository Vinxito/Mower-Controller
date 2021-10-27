package com.seat_code.controller.grass_plateau.application.create;


import com.seat_code.controller.grass_plateau.domain.GrassPlateauXSize;
import com.seat_code.controller.grass_plateau.domain.GrassPlateauYSize;
import com.seat_code.shared.domain.Service;
import com.seat_code.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateGrassPlateauCommandHandler implements CommandHandler<CreateGrassPlateauCommand> {

    private final GrassPlateauCreator creator;

    public CreateGrassPlateauCommandHandler(GrassPlateauCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateGrassPlateauCommand command) {
        GrassPlateauXSize xSize = new GrassPlateauXSize(command.xSize());
        GrassPlateauYSize ySize = new GrassPlateauYSize(command.ySize());

        creator.create(xSize, ySize);
    }
}
