package com.seat.apps.mower.controller.mower;

import com.seat.mower.application.create.CreateMowerCommand;
import com.seat.mower.application.update.UpdateMowerCommand;
import com.seat.shared.domain.bus.command.CommandBus;
import com.seat.shared.domain.bus.command.CommandHandlerExecutionError;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Controller
public final class MowersPostController {

    private final CommandBus commandBus;

    public MowersPostController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(@ModelAttribute("model") ModelMap model) {
        model.addAttribute("grassCreated", false);
        return "index";
    }

    @PostMapping(value = "/mowers", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView plateau(@RequestParam HashMap<String, Serializable> request) throws CommandHandlerExecutionError {

        String positionInputLine = request.get("position").toString().replace(" ", "");

        Integer xPosition = Integer.parseInt(String.valueOf(positionInputLine.charAt(0)));
        Integer yPosition = Integer.parseInt(String.valueOf(positionInputLine.split("")[1]));
        String headFacing = positionInputLine.substring(positionInputLine.length() - 1);

        commandBus.dispatch(new CreateMowerCommand(
                xPosition,
                yPosition,
                headFacing));

        List<String> orderInputLine = List.of(request.get("orders").toString().replace(" ", "").split(""));

        commandBus.dispatch(new UpdateMowerCommand(
                xPosition,
                yPosition,
                headFacing,
                orderInputLine));

        return new ModelAndView("redirect:/");
    }
}
