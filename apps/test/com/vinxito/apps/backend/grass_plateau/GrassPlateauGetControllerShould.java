package com.vinxito.apps.backend.grass_plateau;

import com.vinxito.apps.AcceptanceTestCase;
import com.vinxito.controller.grass_plateau.application.create.CreateGrassPlateauCommand;
import org.junit.jupiter.api.Test;

final class GrassPlateauGetControllerShould extends AcceptanceTestCase {

    @Test
    void find_any_grass_plateau() throws Exception {
        commandBus.dispatch(new CreateGrassPlateauCommand(5, 5));
        assertBooleanResponse("/grass_plateau", 200, true);
    }

    @Test
    void no_find_a_created_grass_plateau() throws Exception {
        assertBooleanResponse("/grass_plateau", 200, false);
    }

}
