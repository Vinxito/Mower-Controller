package com.seat.mower.application.find;

import com.seat.shared.domain.bus.query.Response;

import java.util.List;

public final class MowersResponse implements Response {
    private final List<MowerResponse> items;

    public MowersResponse(List<MowerResponse> items) {
        this.items = items;
    }

    public List<MowerResponse> items() {
        return items;
    }
}
