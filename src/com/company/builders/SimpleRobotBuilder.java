package com.company.builders;

import com.company.abstracts.RobotController;
import com.company.abstracts.RobotPosition;
import com.company.abstracts.RoomFloor;
import com.company.abstracts.SimpleRobot;
import com.company.implememtations.SimpleRobotImpl;

public class SimpleRobotBuilder {

    private RoomFloor roomFloor;
    private RobotPosition robotPosition;
    private RobotController robotController;

    public SimpleRobotBuilder room(RoomFloor newRoomFloor) {
        this.roomFloor = newRoomFloor;
        return this;
    }

    public SimpleRobotBuilder position(RobotPosition robotPosition) {
        this.robotPosition = robotPosition;
        return this;
    }

    public SimpleRobotBuilder controller(RobotController robotController) {
        this.robotController = robotController;
        return this;
    }

    public SimpleRobot build() {
        return new SimpleRobotImpl(roomFloor, robotPosition, robotController);
    }

}
