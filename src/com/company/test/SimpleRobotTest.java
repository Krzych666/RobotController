package com.company.test;

import com.company.abstracts.RobotController;
import com.company.abstracts.RobotPosition;
import com.company.abstracts.RoomFloor;
import com.company.abstracts.SimpleRobot;
import com.company.builders.RobotPositionBuilder;
import com.company.builders.RoomFloorBuilder;
import com.company.builders.SimpleRobotBuilder;
import com.company.enums.NavigationCommand;
import com.company.enums.Orientation;
import com.company.implememtations.SimpleRobotController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.company.enums.NavigationCommand.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleRobotTest {

    private SimpleRobot simpleRobot;

    @BeforeEach
    void setUp() {
        RoomFloor roomFloor = new RoomFloorBuilder().width(3).depth(3).build();
        RobotPosition robotPosition = new RobotPositionBuilder().xPosition(0).yPosition(0).orientation("N").build();
        RobotController robotController = new SimpleRobotController();
        simpleRobot = new SimpleRobotBuilder().room(roomFloor).position(robotPosition).controller(robotController).build();
    }

    @Test
    void shouldExecuteAChainOfCommands() {
        List<NavigationCommand> commandList = List.of(F, F, F, R, F, R, F, R, R, R, R, L, L, L, L, F, L, F, L, F, F, F);

        simpleRobot.executeCommand(commandList);

        assertEquals(2, simpleRobot.getRobotPosition().getXPosition());
        assertEquals(2, simpleRobot.getRobotPosition().getYPosition());
        assertEquals(Orientation.N, simpleRobot.getRobotPosition().getOrientation());
    }

    @Test
    void shouldGenerateProperReport() {
        assertEquals("Report: 0 0 N", simpleRobot.getRobotPosition().generateReport());
    }

}