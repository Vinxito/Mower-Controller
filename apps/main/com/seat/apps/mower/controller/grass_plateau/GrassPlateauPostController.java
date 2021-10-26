package com.seat.apps.mower.controller.grass_plateau;

import com.seat.grass_plateau.application.create.CreateGrassPlateauCommand;
import com.seat.shared.domain.bus.command.CommandBus;
import com.seat.shared.domain.bus.command.CommandHandlerExecutionError;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.HashMap;

@Controller
public final class GrassPlateauPostController {

    private final CommandBus commandBus;


    public GrassPlateauPostController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping(value = "/grass_plateau", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView plateau(@RequestParam HashMap<String, Serializable> request) throws CommandHandlerExecutionError {

        String firstInputLine = request.get("grassPlateau").toString();

        String xSize = String.valueOf(firstInputLine.charAt(0));
        String ySize = firstInputLine.substring(firstInputLine.length() - 1);

        commandBus.dispatch(new CreateGrassPlateauCommand(
                Integer.parseInt(xSize),
                Integer.parseInt(ySize)));

        return new ModelAndView("redirect:/");
    }
}
