package com.seat.apps.mower.controller.mower;

import com.seat.grass_plateau.application.create.CreateGrassPlateauCommand;
import com.seat.mower.application.create.CreateMowerCommand;
import com.seat.mower.application.find.FindMowersQuery;
import com.seat.mower.application.find.MowersResponse;
import com.seat.mower.application.update.UpdateMowerCommand;
import com.seat.shared.domain.bus.command.CommandBus;
import com.seat.shared.domain.bus.command.CommandHandlerExecutionError;
import com.seat.shared.domain.bus.query.QueryBus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

@Controller
public final class MowersGetController {

    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public MowersGetController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(@ModelAttribute("model") ModelMap model) {
        return "index";
    }

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView plateau(@RequestParam HashMap<String, Serializable> request) throws CommandHandlerExecutionError {

        String firstInputLine = request.get("grassPlateau").toString();

        String xSize = String.valueOf(firstInputLine.charAt(0));
        String ySize = firstInputLine.substring(firstInputLine.length() - 1);

        commandBus.dispatch(new CreateGrassPlateauCommand(
                Integer.parseInt(xSize),
                Integer.parseInt(ySize)));

        String secondInputLine = request.get("position").toString();

        String xPosition = String.valueOf(secondInputLine.charAt(0));
        String yPosition = String.valueOf(secondInputLine.charAt(2));
        String headFacing = secondInputLine.substring(secondInputLine.length() - 1);

        commandBus.dispatch(new CreateMowerCommand(
                Integer.parseInt(xPosition),
                Integer.parseInt(yPosition),
                headFacing));

        String thirdInputLine = request.get("orders").toString();

        Arrays.stream(thirdInputLine.split("")).collect(Collectors.toList())
                .forEach(order -> commandBus.dispatch(new UpdateMowerCommand(
                        Integer.parseInt(xPosition),
                        Integer.parseInt(yPosition),
                        headFacing,
                        order)));

        MowersResponse mowersResponse = queryBus.ask(new FindMowersQuery());

        return new ModelAndView("redirect:/", new HashMap<String, Serializable>() {{
            put("xPosition", "");
            put("yPosition", "");
            put("headFacing", "");
//            put("courses_counter", counterResponse.total());
//            put("inputs", inputs);
//            put("errors", errors);
        }});
    }

//    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public ModelAndView mower(@RequestParam HashMap<String, Serializable> request) throws CommandHandlerExecutionError {
//
//        String secondInputLine = request.get("position").toString();
//
//        String xPosition = String.valueOf(secondInputLine.charAt(0));
//        String yPosition = String.valueOf(secondInputLine.charAt(2));
//        String headFacing = secondInputLine.substring(secondInputLine.length() - 1);
//
//        commandBus.dispatch(new CreateMowerCommand(
//                Integer.getInteger(xPosition),
//                Integer.getInteger(yPosition),
//                headFacing));
//
//        return new ModelAndView("redirect:/");
//    }
//
//    @PostMapping(value = "/orders", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public ModelAndView orders(@RequestParam HashMap<String, Serializable> request) throws CommandHandlerExecutionError {
//
//        Collections.singleton(request.get("orders").toString()).forEach(
//                order -> commandBus.dispatch(new UpdateMowerCommand(order)));
//
//        return new ModelAndView("redirect:/");
//    }
//
//    @GetMapping(value = "/mowers", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public ModelAndView mowers() throws CommandHandlerExecutionError {
//
//        queryBus.ask(new FindMowersQuery());
//
//        return new ModelAndView("mowers", new HashMap<String, Serializable>() {{
//            put("title", "Courses");
//            put("description", "Courses CodelyTV - Backoffice");
////            put("courses_counter", counterResponse.total());
////            put("inputs", inputs);
////            put("errors", errors);
//        }});
//    }
}
