package com.seat_code.controller.mower.application.find;

import com.seat_code.shared.domain.ListMother;

import java.util.List;

public final class MowersResponseMother {

    public static MowersResponse create(List<MowerResponse> Mowers) {
        return new MowersResponse(Mowers);
    }

    public static MowersResponse random() {
        return create(ListMother.random(MowerResponseMother::random));
    }
}
