package com.company.abstracts;

import com.company.enums.NavigationCommand;

import java.util.List;

public interface SimpleRobot {

    void moveForward();

    void turnRight();

    void turnLeft();

    RoomFloor getRoomFloor();

    void setRoomFloor(RoomFloor roomFloor);

    RobotPosition getRobotPosition();

    void setRobotPosition(RobotPosition robotPosition);

    void reportRobotPosition();

    RobotController getRobotController();

    void setRobotController(RobotController robotController);

    void executeCommand(List<NavigationCommand> navigation);
}
