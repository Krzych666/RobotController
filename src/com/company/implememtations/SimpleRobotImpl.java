package com.company.implememtations;

import com.company.abstracts.RobotController;
import com.company.abstracts.RobotPosition;
import com.company.abstracts.RoomFloor;
import com.company.abstracts.SimpleRobot;
import com.company.enums.NavigationCommand;

import java.util.List;

public class SimpleRobotImpl implements SimpleRobot {

    private RoomFloor roomFloor;
    private RobotPosition robotPosition;
    private RobotController robotController;

    public SimpleRobotImpl(RoomFloor roomFloor, RobotPosition robotPosition, RobotController robotController) {
        this.roomFloor = roomFloor;
        this.robotPosition = robotPosition;
        this.robotController = robotController;
    }

    @Override
    public void moveForward() {
        robotController.moveForward(robotPosition, roomFloor);
    }

    @Override
    public void turnRight() {
        robotController.turnRight(robotPosition);
    }

    @Override
    public void turnLeft() {
        robotController.turnLeft(robotPosition);
    }

    @Override
    public RoomFloor getRoomFloor() {
        return roomFloor;
    }

    @Override
    public void setRoomFloor(RoomFloor roomFloor) {
        this.roomFloor = roomFloor;
    }

    @Override
    public RobotPosition getRobotPosition() {
        return robotPosition;
    }

    @Override
    public void setRobotPosition(RobotPosition robotPosition) {
        this.robotPosition = robotPosition;
    }

    @Override
    public void reportRobotPosition() {
        System.out.println(robotPosition.generateReport());
    }

    @Override
    public RobotController getRobotController() {
        return robotController;
    }

    @Override
    public void setRobotController(RobotController robotController) {
        this.robotController = robotController;
    }

    @Override
    public void executeCommand(List<NavigationCommand> navigation) {
        navigation.forEach(this::executeSingleMovement);
    }


    private void executeSingleMovement(NavigationCommand navigationCommand) {
        switch (navigationCommand) {
            case F -> moveForward();
            case R -> turnRight();
            case L -> turnLeft();
        }
    }
}
