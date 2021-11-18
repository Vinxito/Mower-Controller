package com.vinxito.apps.mower.controller.grass_plateau;

import com.vinxito.controller.grass_plateau.application.find.FindGrassPlateauQuery;
import com.vinxito.controller.grass_plateau.application.find.GrassPlateauResponse;
import com.vinxito.shared.domain.bus.command.CommandHandlerExecutionError;
import com.vinxito.shared.domain.bus.query.QueryBus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public final class GrassPlateauGetController {

    private final QueryBus queryBus;

    public GrassPlateauGetController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping(value = "/grass_plateau")
    public boolean grassPlateauFinder() throws CommandHandlerExecutionError {
        GrassPlateauResponse grassPlateauResponse = queryBus.ask(new FindGrassPlateauQuery());
        return grassPlateauResponse.xSize() != 0 && grassPlateauResponse.ySize() != 0;
    }
}
