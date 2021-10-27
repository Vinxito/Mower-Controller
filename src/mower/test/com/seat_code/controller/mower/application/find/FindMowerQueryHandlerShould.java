package com.seat_code.controller.mower.application.find;

import com.seat_code.controller.mower.MowersModuleUnitTestCase;
import com.seat_code.controller.mower.domain.Mower;
import com.seat_code.controller.mower.domain.MowerMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

final class FindMowerQueryHandlerShould extends MowersModuleUnitTestCase {

    private FindMowerQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new FindMowerQueryHandler(new MowerFinder(repository));
    }

    @Test
    void find_all_existent_mower() {
        FindMowerQuery query = new FindMowerQuery();

        Mower mower = MowerMother.random();

        MowerResponse response = MowerResponseMother.create(mower.xPosition().value(), mower.yPosition().value(), mower.facing().value());

        MowersResponse responses = MowersResponseMother.create(List.of(response));

        shouldSearchAll(List.of(mower));

        assertEquals(responses, handler.handle(query));
    }

    @Test
    void non_find_an_existent_mower() {
        FindMowerQuery query = new FindMowerQuery();

        Mower mower = MowerMother.random();

        MowerResponse response = MowerResponseMother.random();

        shouldSearchAll(List.of(mower));

        assertNotEquals(response, handler.handle(query));
    }
}
