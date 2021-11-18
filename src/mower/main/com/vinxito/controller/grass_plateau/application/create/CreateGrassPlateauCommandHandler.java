package com.vinxito.controller.grass_plateau.application.create;


import com.vinxito.controller.grass_plateau.domain.GrassPlateauXSize;
import com.vinxito.controller.grass_plateau.domain.GrassPlateauYSize;
import com.vinxito.shared.domain.Service;
import com.vinxito.shared.domain.bus.command.CommandHandler;

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
