package com.seat.shared.infrastructure;

import com.seat.shared.domain.bus.query.Query;
import com.seat.shared.domain.bus.query.QueryBus;
import com.seat.shared.domain.bus.query.Response;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public abstract class UnitTestCase {

    protected QueryBus queryBus;

    @BeforeEach
    protected void setUp() {
        queryBus = mock(QueryBus.class);
    }

    public void shouldAsk(Query query, Response response) {
        when(queryBus.ask(query)).thenReturn(response);
    }
}
