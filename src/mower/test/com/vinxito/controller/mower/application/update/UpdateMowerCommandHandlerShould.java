package com.vinxito.controller.mower.application.update;

import com.vinxito.controller.grass_plateau.application.find.FindGrassPlateauQuery;
import com.vinxito.controller.grass_plateau.application.find.GrassPlateauResponse;
import com.vinxito.controller.mower.MowersModuleUnitTestCase;
import com.vinxito.controller.mower.domain.Mower;
import com.vinxito.controller.mower.domain.MowerMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


final class UpdateMowerCommandHandlerShould extends MowersModuleUnitTestCase {

    private UpdateMowerCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new UpdateMowerCommandHandler(new MowerUpdate(repository, queryBus));
    }

    @Test
    void update_a_mower() {

        UpdateMowerCommand command = UpdateMowerCommandMother.random();

        Mower mower = MowerMother.update(command);

        GrassPlateauResponse grassPlateauResponse = GrassPlateauResponseMother.random();

        FindGrassPlateauQuery grassPlateauQuery = FindGrassPlateauQueryMother.random();

        shouldSearchByPosition(mower);

        shouldAsk(grassPlateauQuery, grassPlateauResponse);

        handler.handle(command);

    }
}
