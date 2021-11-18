package com.vinxito.apps.mower.controller.mower;

import com.vinxito.controller.mower.application.find.FindMowerQuery;
import com.vinxito.controller.mower.application.find.MowersResponse;
import com.vinxito.shared.domain.bus.query.QueryBus;
import com.vinxito.shared.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MowerGetController {

    private final QueryBus queryBus;

    public MowerGetController(QueryBus queryBus) {
        this.queryBus = queryBus;
    }

    @GetMapping("/mowers")
    public List<HashMap<String, String>> mowersList() throws QueryHandlerExecutionError {

        MowersResponse mowersResponse = queryBus.ask(new FindMowerQuery());

        return mowersResponse.mowers().stream().map(response -> new HashMap<String, String>() {{
            put("xPosition", response.xPosition().toString());
            put("yPosition", response.yPosition().toString());
            put("headFacing", response.headFacing());
        }}).collect(Collectors.toList());
    }
}
