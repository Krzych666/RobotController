package com.company.implememtations;

import com.company.abstracts.RobotPosition;
import com.company.enums.Orientation;

public class RobotPositionImpl implements RobotPosition {

    private int xPosition;
    private int yPosition;
    private Orientation orientation;

    public RobotPositionImpl(int xPosition, int yPosition, Orientation orientation) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.orientation = orientation;
    }

    @Override
    public int getXPosition() {
        return xPosition;
    }

    @Override
    public void setXPosition(int newXPosition) {
        this.xPosition = newXPosition;
    }

    @Override
    public int getYPosition() {
        return yPosition;
    }

    @Override
    public void setYPosition(int newYPosition) {
        this.yPosition = newYPosition;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public void setOrientation(Orientation newOrientation) {
        this.orientation = newOrientation;
    }

    @Override
    public String generateReport() {
        return new StringBuilder("Report: ")
                .append(getXPosition()).append(" ")
                .append(getYPosition()).append(" ")
                .append(getOrientation()).toString();
    }
}
