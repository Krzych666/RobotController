package com.company.test;

import com.company.abstracts.RobotController;
import com.company.abstracts.RobotPosition;
import com.company.abstracts.RoomFloor;
import com.company.builders.RobotPositionBuilder;
import com.company.builders.RoomFloorBuilder;
import com.company.enums.Orientation;
import com.company.implememtations.SimpleRobotController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleRobotControllerTest {

    private RoomFloor roomFloor;
    private RobotPosition robotPosition;
    private RobotController robotController;

    @BeforeEach
    void setUp() {
        roomFloor = new RoomFloorBuilder().width(3).depth(3).build();
        robotPosition = new RobotPositionBuilder().xPosition(1).yPosition(1).build();
        robotController = new SimpleRobotController();

    }

    @Test
    void shouldMoveForwardNorth() {
        robotPosition.setOrientation(Orientation.N);
        robotController.moveForward(robotPosition, roomFloor);

        assertEquals(1, robotPosition.getXPosition());
        assertEquals(2, robotPosition.getYPosition());
        assertEquals(Orientation.N, robotPosition.getOrientation());
    }

    @Test
    void shouldMoveForwardSouth() {
        robotPosition.setOrientation(Orientation.S);
        robotController.moveForward(robotPosition, roomFloor);

        assertEquals(1, robotPosition.getXPosition());
        assertEquals(0, robotPosition.getYPosition());
        assertEquals(Orientation.S, robotPosition.getOrientation());
    }

    @Test
    void shouldMoveForwardWest() {
        robotPosition.setOrientation(Orientation.W);
        robotController.moveForward(robotPosition, roomFloor);

        assertEquals(0, robotPosition.getXPosition());
        assertEquals(1, robotPosition.getYPosition());
        assertEquals(Orientation.W, robotPosition.getOrientation());
    }

    @Test
    void shouldMoveForwardEast() {
        robotPosition.setOrientation(Orientation.E);
        robotController.moveForward(robotPosition, roomFloor);

        assertEquals(2, robotPosition.getXPosition());
        assertEquals(1, robotPosition.getYPosition());
        assertEquals(Orientation.E, robotPosition.getOrientation());
    }

    @Test
    void shouldNotMoveForwardNorthIfAtNorthBorder() {
        robotPosition.setYPosition(2);
        robotPosition.setOrientation(Orientation.N);
        robotController.moveForward(robotPosition, roomFloor);

        assertEquals(1, robotPosition.getXPosition());
        assertEquals(2, robotPosition.getYPosition());
        assertEquals(Orientation.N, robotPosition.getOrientation());
    }

    @Test
    void shouldNotMoveForwardSouthIfAtSouthBorder() {
        robotPosition.setYPosition(0);
        robotPosition.setOrientation(Orientation.S);
        robotController.moveForward(robotPosition, roomFloor);

        assertEquals(1, robotPosition.getXPosition());
        assertEquals(0, robotPosition.getYPosition());
        assertEquals(Orientation.S, robotPosition.getOrientation());
    }

    @Test
    void shouldNotMoveForwardWestIfAtWestBorder() {
        robotPosition.setXPosition(0);
        robotPosition.setOrientation(Orientation.W);
        robotController.moveForward(robotPosition, roomFloor);

        assertEquals(0, robotPosition.getXPosition());
        assertEquals(1, robotPosition.getYPosition());
        assertEquals(Orientation.W, robotPosition.getOrientation());
    }

    @Test
    void shouldNotMoveForwardEastIfAtEastBorder() {
        robotPosition.setXPosition(2);
        robotPosition.setOrientation(Orientation.E);
        robotController.moveForward(robotPosition, roomFloor);

        assertEquals(2, robotPosition.getXPosition());
        assertEquals(1, robotPosition.getYPosition());
        assertEquals(Orientation.E, robotPosition.getOrientation());
    }

    @Test
    void shouldTurnRightFromNorthToEast() {
        robotPosition.setOrientation(Orientation.N);
        robotController.turnRight(robotPosition);

        assertEquals(1, robotPosition.getXPosition());
        assertEquals(1, robotPosition.getYPosition());
        assertEquals(Orientation.E, robotPosition.getOrientation());
    }

    @Test
    void shouldTurnRightFromEastToSouth() {
        robotPosition.setOrientation(Orientation.E);
        robotController.turnRight(robotPosition);

        assertEquals(1, robotPosition.getXPosition());
        assertEquals(1, robotPosition.getYPosition());
        assertEquals(Orientation.S, robotPosition.getOrientation());
    }

    @Test
    void shouldTurnRightFromSouthToWest() {
        robotPosition.setOrientation(Orientation.S);
        robotController.turnRight(robotPosition);

        assertEquals(1, robotPosition.getXPosition());
        assertEquals(1, robotPosition.getYPosition());
        assertEquals(Orientation.W, robotPosition.getOrientation());
    }

    @Test
    void shouldTurnRightFromWestToNorth() {
        robotPosition.setOrientation(Orientation.W);
        robotController.turnRight(robotPosition);

        assertEquals(1, robotPosition.getXPosition());
        assertEquals(1, robotPosition.getYPosition());
        assertEquals(Orientation.N, robotPosition.getOrientation());
    }

    @Test
    void shouldTurnLeftFromNorthToWest() {
        robotPosition.setOrientation(Orientation.N);
        robotController.turnLeft(robotPosition);

        assertEquals(1, robotPosition.getXPosition());
        assertEquals(1, robotPosition.getYPosition());
        assertEquals(Orientation.W, robotPosition.getOrientation());
    }

    @Test
    void shouldTurnLeftFromWestToSouth() {
        robotPosition.setOrientation(Orientation.W);
        robotController.turnLeft(robotPosition);

        assertEquals(1, robotPosition.getXPosition());
        assertEquals(1, robotPosition.getYPosition());
        assertEquals(Orientation.S, robotPosition.getOrientation());
    }

    @Test
    void shouldTurnLeftFromSouthToEast() {
        robotPosition.setOrientation(Orientation.S);
        robotController.turnLeft(robotPosition);

        assertEquals(1, robotPosition.getXPosition());
        assertEquals(1, robotPosition.getYPosition());
        assertEquals(Orientation.E, robotPosition.getOrientation());
    }

    @Test
    void shouldTurnLeftFromEastToNorth() {
        robotPosition.setOrientation(Orientation.E);
        robotController.turnLeft(robotPosition);

        assertEquals(1, robotPosition.getXPosition());
        assertEquals(1, robotPosition.getYPosition());
        assertEquals(Orientation.N, robotPosition.getOrientation());
    }


}