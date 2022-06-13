package com.company.abstracts;

import com.company.enums.Orientation;

public interface RobotPosition {

    int getXPosition();

    void setXPosition(int newXPosition);

    int getYPosition();

    void setYPosition(int newYPosition);

    Orientation getOrientation();

    void setOrientation(Orientation newOrientation);

    String generateReport();
}
