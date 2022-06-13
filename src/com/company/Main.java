package com.company;

import com.company.abstracts.RobotController;
import com.company.abstracts.RobotPosition;
import com.company.abstracts.RoomFloor;
import com.company.abstracts.SimpleRobot;
import com.company.builders.SimpleRobotBuilder;
import com.company.enums.NavigationCommand;
import com.company.implememtations.SimpleRobotController;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        RoomFloor newRoomFloor = InputValidator.setUpRoomFromInput();
        RobotPosition robotPosition = InputValidator.setUpRobotPositionFromInput(newRoomFloor);
        RobotController robotController = new SimpleRobotController();

        SimpleRobot simpleRobot = new SimpleRobotBuilder().room(newRoomFloor).position(robotPosition).controller(robotController).build();

        List<NavigationCommand> navigation = InputValidator.setUpNavigationFromInput();
        simpleRobot.executeCommand(navigation);
        simpleRobot.reportRobotPosition();
    }


}
