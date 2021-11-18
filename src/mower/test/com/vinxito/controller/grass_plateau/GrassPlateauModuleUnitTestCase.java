package com.vinxito.controller.grass_plateau;

import com.vinxito.controller.grass_plateau.domain.GrassPlateau;
import com.vinxito.controller.grass_plateau.domain.GrassPlateauRepository;
import com.vinxito.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class GrassPlateauModuleUnitTestCase extends UnitTestCase {

    protected GrassPlateauRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(GrassPlateauRepository.class);
    }

    public void shouldSearch(GrassPlateau grassPlateau) {
        Mockito.when(repository.search()).thenReturn(Optional.of(grassPlateau));
    }

    public void shouldHaveSaved(GrassPlateau grassPlateau) {
        verify(repository, atLeastOnce()).save(grassPlateau);
    }
}
