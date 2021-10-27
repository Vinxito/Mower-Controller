package com.seat_code.controller.mower.application.find;

import com.seat_code.shared.domain.bus.query.Response;

import java.util.List;

public final class MowersResponse implements Response {
    private final List<MowerResponse> mowers;

    public MowersResponse(List<MowerResponse> mowers) {
        this.mowers = mowers;
    }

    public List<MowerResponse> mowers() {
        return mowers;
    }
}
