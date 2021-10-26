package com.seat.grass_plateau.application.create;


import com.seat.grass_plateau.domain.GrassPlateauX;
import com.seat.grass_plateau.domain.GrassPlateauY;
import com.seat.shared.domain.Service;
import com.seat.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateGrassPlateauCommandHandler implements CommandHandler<CreateGrassPlateauCommand> {

    private final GrassPlateauCreator creator;

    public CreateGrassPlateauCommandHandler(GrassPlateauCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateGrassPlateauCommand command) {
        GrassPlateauX xSize = new GrassPlateauX(command.xSize());
        GrassPlateauY ySize = new GrassPlateauY(command.ySize());

        creator.create(xSize, ySize);
    }
}
