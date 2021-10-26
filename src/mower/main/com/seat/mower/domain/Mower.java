package com.seat.mower.domain;

import com.seat.grass_plateau.domain.GrassPlateau;
import com.seat.shared.domain.AggregateRoot;

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

    public Mower move(GrassPlateau grassPlateau) {

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

       return validateGrassPlateauSize(xPosition, yPosition, grassPlateau);
    }

    private Mower validateGrassPlateauSize(MowerXPosition xPosition, MowerYPosition yPosition, GrassPlateau grassPlateau) {
        if (!(xPosition.value() >= 0 && xPosition.value() <= grassPlateau.positionX().value())){
            return new Mower(this.xPosition, yPosition, facing);
        }

        if (!(yPosition.value() >= 0 && yPosition.value() <= grassPlateau.positionY().value())){
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
