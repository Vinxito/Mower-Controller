package com.vinxito.controller.mower.application.find;

import com.vinxito.shared.domain.bus.query.Response;

import java.util.List;
import java.util.Objects;

public final class MowersResponse implements Response {
    private final List<MowerResponse> mowers;

    public MowersResponse(List<MowerResponse> mowers) {
        this.mowers = mowers;
    }

    public List<MowerResponse> mowers() {
        return mowers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MowersResponse that = (MowersResponse) o;
        return mowers.equals(that.mowers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mowers);
    }
}
