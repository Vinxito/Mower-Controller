package com.seat_code.controller.mower;


import com.seat_code.controller.mower.domain.Mower;
import com.seat_code.controller.mower.domain.MowerRepository;
import com.seat_code.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public abstract class MowersModuleUnitTestCase extends UnitTestCase {

    protected MowerRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(MowerRepository.class);
    }

    public void shouldSearchAll(List<Mower> mowers) {
        Mockito.when(repository.all()).thenReturn(mowers);
    }

    public void shouldHaveSaved(Mower mower) {
        verify(repository, atLeastOnce()).save(mower);
    }

    public void shouldSearchByPosition(Mower mower) {
        when(repository.byPosition(mower.xPosition(), mower.yPosition(), mower.facing())).thenReturn(mower);
    }
}
