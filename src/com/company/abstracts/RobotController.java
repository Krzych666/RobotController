package com.company.abstracts;

public interface RobotController {
    void moveForward(RobotPosition robotPosition, RoomFloor roomFloor);

    void turnRight(RobotPosition robotPosition);

    void turnLeft(RobotPosition robotPosition);
}
