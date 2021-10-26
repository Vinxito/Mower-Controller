package com.seat.apps.mower.controller.grass_plateau;

import com.seat.grass_plateau.application.create.CreateGrassPlateauCommand;
import com.seat.shared.domain.bus.command.CommandBus;
import com.seat.shared.domain.bus.command.CommandHandlerExecutionError;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.HashMap;

@Controller
final class GrassPlateauPutController {

    private final CommandBus commandBus;

    public GrassPlateauPutController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }



}
