package com.vinxito.shared.infrastructure;

import com.vinxito.shared.domain.bus.query.Query;
import com.vinxito.shared.domain.bus.query.QueryBus;
import com.vinxito.shared.domain.bus.query.Response;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
