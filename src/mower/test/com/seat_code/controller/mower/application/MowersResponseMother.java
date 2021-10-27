package com.seat_code.controller.mower.application;

import com.seat_code.controller.mower.application.find.MowerResponse;
import com.seat_code.controller.mower.application.find.MowersResponse;
import com.seat_code.shared.domain.ListMother;

import java.util.Collections;
import java.util.List;

public final class MowersResponseMother {
    public static MowersResponse create(List<MowerResponse> items) {
        return new MowersResponse(items);
    }

    public static MowersResponse random() {
        return create(ListMother.random(MowerResponseMother::random));
    }

    public static MowersResponse times(int times) {
        return create(ListMother.create(times, MowerResponseMother::random));
    }

    public static MowersResponse empty() {
        return create(Collections.emptyList());
    }
}
