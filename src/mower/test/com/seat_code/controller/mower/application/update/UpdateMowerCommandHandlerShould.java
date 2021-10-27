package com.seat_code.controller.mower.application.update;

import com.seat_code.controller.grass_plateau.application.find.FindGrassPlateauQuery;
import com.seat_code.controller.grass_plateau.application.find.GrassPlateauResponse;
import com.seat_code.controller.mower.MowersModuleUnitTestCase;
import com.seat_code.controller.mower.domain.Mower;
import com.seat_code.controller.mower.domain.MowerMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.when;

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
