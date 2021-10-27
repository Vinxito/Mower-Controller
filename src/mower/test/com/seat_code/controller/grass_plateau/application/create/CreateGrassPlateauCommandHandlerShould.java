package com.seat_code.controller.grass_plateau.application.create;

import com.seat_code.controller.grass_plateau.GrassPlateauModuleUnitTestCase;
import com.seat_code.controller.grass_plateau.domain.GrassPlateau;
import com.seat_code.controller.grass_plateau.domain.GrassPlateauMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class CreateGrassPlateauCommandHandlerShould extends GrassPlateauModuleUnitTestCase {

    private CreateGrassPlateauCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new CreateGrassPlateauCommandHandler(new GrassPlateauCreator(repository));
    }

//    @Test
//    void create_a_grass_plateau() {
//        CreateGrassPlateauCommand command = CreateGrassPlateauCommandMother.random();
//
//        GrassPlateau mower = GrassPlateauMother.fromRequest(command);
//
//        handler.handle(command);
//
//        shouldHaveSaved(mower);
//    }
}
