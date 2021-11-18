package com.vinxito.controller.mower.application.create;

import com.vinxito.controller.mower.MowersModuleUnitTestCase;
import com.vinxito.controller.mower.domain.Mower;
import com.vinxito.controller.mower.domain.MowerMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class CreateMowerCommandHandlerShould extends MowersModuleUnitTestCase {

    private CreateMowerCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new CreateMowerCommandHandler(new MowerCreator(repository));
    }

    @Test
    void create_a_mower() {
        CreateMowerCommand command = CreateMowerCommandMother.random();

        Mower mower = MowerMother.fromRequest(command);

        handler.handle(command);

        shouldHaveSaved(mower);
    }
}
