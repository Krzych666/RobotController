package com.company.builders;

import com.company.abstracts.RobotPosition;
import com.company.enums.Orientation;
import com.company.implememtations.RobotPositionImpl;

public class RobotPositionBuilder {

    private int xPosition;
    private int yPosition;
    private Orientation orientation;

    public RobotPositionBuilder xPosition(int xPosition) {
        this.xPosition = xPosition;
        return this;
    }

    public RobotPositionBuilder yPosition(int yPosition) {
        this.yPosition = yPosition;
        return this;
    }

    public RobotPositionBuilder orientation(String orientation) {
        this.orientation = Orientation.valueOf(orientation);
        return this;
    }

    public RobotPosition build() {
        return new RobotPositionImpl(xPosition, yPosition, orientation);
    }
}
