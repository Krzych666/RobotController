package com.company.implememtations;

import com.company.abstracts.RobotController;
import com.company.abstracts.RobotPosition;
import com.company.abstracts.RoomFloor;
import com.company.enums.Orientation;

public class SimpleRobotController implements RobotController {

    @Override
    public void moveForward(RobotPosition robotPosition, RoomFloor roomFloor) {
        switch (robotPosition.getOrientation()) {
            case N -> robotPosition.setYPosition(robotPosition.getYPosition() < roomFloor.getDepth() - 1 ?
                    robotPosition.getYPosition() + 1 : robotPosition.getYPosition());
            case E -> robotPosition.setXPosition(robotPosition.getXPosition() < roomFloor.getWidth() - 1 ?
                    robotPosition.getXPosition() + 1 : robotPosition.getXPosition());
            case S -> robotPosition.setYPosition(robotPosition.getYPosition() > 0 ?
                    robotPosition.getYPosition() - 1 : 0);
            case W -> robotPosition.setXPosition(robotPosition.getXPosition() > 0 ?
                    robotPosition.getXPosition() - 1 : 0);
        }
    }

    @Override
    public void turnRight(RobotPosition robotPosition) {
        switch (robotPosition.getOrientation()) {
            case N -> robotPosition.setOrientation(Orientation.E);
            case E -> robotPosition.setOrientation(Orientation.S);
            case S -> robotPosition.setOrientation(Orientation.W);
            case W -> robotPosition.setOrientation(Orientation.N);
        }
    }

    @Override
    public void turnLeft(RobotPosition robotPosition) {
        switch (robotPosition.getOrientation()) {
            case N -> robotPosition.setOrientation(Orientation.W);
            case E -> robotPosition.setOrientation(Orientation.N);
            case S -> robotPosition.setOrientation(Orientation.E);
            case W -> robotPosition.setOrientation(Orientation.S);
        }
    }
}
