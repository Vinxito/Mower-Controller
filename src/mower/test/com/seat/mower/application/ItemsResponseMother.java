package com.seat.mower.application;

import com.seat.mower.application.find.MowerResponse;
import com.seat.mower.application.find.MowersResponse;
import com.seat.shared.domain.ListMother;

import java.util.Collections;
import java.util.List;

public final class ItemsResponseMother {
    public static MowersResponse create(List<MowerResponse> items) {
        return new MowersResponse(items);
    }

    public static MowersResponse random() {
        return create(ListMother.random(ItemResponseMother::random));
    }

    public static MowersResponse times(int times) {
        return create(ListMother.create(times, ItemResponseMother::random));
    }

    public static MowersResponse empty() {
        return create(Collections.emptyList());
    }
}
