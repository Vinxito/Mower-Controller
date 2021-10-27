package com.seat_code.controller.grass_plateau.application.find;

import com.seat_code.controller.grass_plateau.GrassPlateauModuleUnitTestCase;
import com.seat_code.controller.grass_plateau.domain.GrassPlateau;
import com.seat_code.controller.grass_plateau.domain.GrassPlateauMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

final class FindGrassPlateauQueryHandlerShould extends GrassPlateauModuleUnitTestCase {

    private FindGrassPlateauQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new FindGrassPlateauQueryHandler(new GrassPlateauFinder(repository));
    }

    @Test
    void find_an_existent_grass_plateau() {
        FindGrassPlateauQuery query = new FindGrassPlateauQuery();

        GrassPlateau grassPlateau = GrassPlateauMother.random();

        GrassPlateauResponse response = GrassPlateauResponseMother.create(grassPlateau.xSize().value(), grassPlateau.ySize().value());

        shouldSearch(grassPlateau);

        assertEquals(response, handler.handle(query));
    }

    @Test
    void non_find_an_existent_grass_plateau() {
        FindGrassPlateauQuery query = new FindGrassPlateauQuery();

        GrassPlateau grassPlateau = GrassPlateauMother.random();

        GrassPlateauResponse response = GrassPlateauResponseMother.random();

        shouldSearch(grassPlateau);

        assertNotEquals(response, handler.handle(query));
    }
}
