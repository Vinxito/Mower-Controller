package com.seat_code.controller.grass_plateau;

import com.seat_code.controller.grass_plateau.domain.GrassPlateau;
import com.seat_code.controller.grass_plateau.domain.GrassPlateauRepository;
import com.seat_code.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public abstract class GrassPlateauModuleUnitTestCase extends UnitTestCase {

    protected GrassPlateauRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(GrassPlateauRepository.class);
    }

    public void shouldHaveSaved(GrassPlateau grassPlateau) {
        verify(repository, atLeastOnce()).save(grassPlateau);
    }
}
