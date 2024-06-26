package com.vinxito.controller.mower.domain;

import com.vinxito.controller.grass_plateau.domain.GrassPlateauXSize;
import com.vinxito.controller.grass_plateau.domain.GrassPlateauYSize;
import com.vinxito.shared.domain.AggregateRoot;

import java.util.Objects;

public final class Mower extends AggregateRoot {

    private final MowerXPosition xPosition;
    private final MowerYPosition yPosition;
    private final MowerCardinalPoint facing;

    public Mower(MowerXPosition xPosition, MowerYPosition yPosition, MowerCardinalPoint facing) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.facing = facing;
    }

    public static Mower create(MowerXPosition xPosition, MowerYPosition yPosition, MowerCardinalPoint facing) {
        return new Mower(xPosition, yPosition, facing);
    }

    public Mower turnLeft() {
        return new Mower(xPosition, yPosition, MowerCardinalPoint.moveLeft(facing.value()));
    }

    public Mower turnRight() {
        return new Mower(xPosition, yPosition, MowerCardinalPoint.moveRight(facing.value()));
    }

    public Mower move(GrassPlateauXSize xSize, GrassPlateauYSize ySize) {

        MowerXPosition xPosition = this.xPosition;
        MowerYPosition yPosition = this.yPosition;

        switch (facing.value()) {
            case "N":
                yPosition = MowerYPosition.moveUp(yPosition);
                break;
            case "E":
                xPosition = MowerXPosition.moveRight(xPosition);
                break;
            case "S":
                yPosition = MowerYPosition.moveDown(yPosition);
                break;
            case "W":
                xPosition = MowerXPosition.moveLeft(xPosition);
                break;
        }

        return validateGrassPlateauSize(xPosition, yPosition, xSize, ySize);
    }

    private Mower validateGrassPlateauSize(MowerXPosition xPosition, MowerYPosition yPosition, GrassPlateauXSize xSize, GrassPlateauYSize ySize) {
        if (!(xPosition.value() >= 0 && xPosition.value() <= xSize.value())) {
            return new Mower(this.xPosition, yPosition, facing);
        }

        if (!(yPosition.value() >= 0 && yPosition.value() <= ySize.value())) {
            return new Mower(xPosition, this.yPosition, facing);
        }

        return new Mower(xPosition, yPosition, facing);
    }

    public MowerXPosition xPosition() {
        return xPosition;
    }

    public MowerYPosition yPosition() {
        return yPosition;
    }

    public MowerCardinalPoint facing() {
        return facing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return xPosition.equals(mower.xPosition) && yPosition.equals(mower.yPosition) && facing == mower.facing;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xPosition, yPosition, facing);
    }
}
