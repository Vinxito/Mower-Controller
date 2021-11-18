package com.vinxito.apps.backend.mower;

import com.vinxito.apps.AcceptanceTestCase;
import com.vinxito.controller.mower.application.create.CreateMowerCommand;
import com.vinxito.controller.mower.domain.MowerCardinalPoint;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

final class MowersGetControllerShould extends AcceptanceTestCase {

    @Test
    void find_a_mower() throws Exception {

        withAMowerCreated();

        List<JSONObject> mowers = new ArrayList<>();
        mowers.add(new JSONObject("{\"xPosition\": \"1\", \"yPosition\": \"3\",\"headFacing\": \"N\" }"));

        assertResponse("/mowers", 200, mowers.toString());
    }

    @Test
    void no_find_a_non_existing_mower() throws Exception {

        List<JSONObject> mowers = new ArrayList<>();

        assertResponse("/mowers", 200, mowers.toString());
    }

    private void withAMowerCreated() {
        commandBus.dispatch(new CreateMowerCommand(1, 3, MowerCardinalPoint.N.value()));
    }

}
