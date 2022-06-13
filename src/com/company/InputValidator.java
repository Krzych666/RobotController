package com.company;

import com.company.abstracts.RobotPosition;
import com.company.abstracts.RoomFloor;
import com.company.builders.RobotPositionBuilder;
import com.company.builders.RoomFloorBuilder;
import com.company.enums.NavigationCommand;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputValidator {

    private static final Scanner inputScanner = new Scanner(System.in);

    private InputValidator() {
    }

    public static RoomFloor setUpRoomFromInput() {
        System.out.println("Enter room width and depth:");
        int width = inputScanner.nextInt();
        int depth = inputScanner.nextInt();

        width = validateAndCorrectRoomSize(width);
        depth = validateAndCorrectRoomSize(depth);

        return new RoomFloorBuilder()
                .width(width)
                .depth(depth)
                .build();
    }

    public static RobotPosition setUpRobotPositionFromInput(RoomFloor newRoomFloor) {
        System.out.println("Enter robot position: x, y and orientation (N/S/W/E):");
        int xPosition = inputScanner.nextInt();
        int yPosition = inputScanner.nextInt();
        String orientation = inputScanner.next().toUpperCase();

        xPosition = validateAndCorrectRobotPositionInRoom(xPosition, newRoomFloor.getWidth());
        yPosition = validateAndCorrectRobotPositionInRoom(yPosition, newRoomFloor.getDepth());
        orientation = validateAndCorrectOrientation(orientation);

        return new RobotPositionBuilder()
                .xPosition(xPosition)
                .yPosition(yPosition)
                .orientation(orientation)
                .build();
    }

    public static List<NavigationCommand> setUpNavigationFromInput() {
        System.out.println("Enter navigation orders (L/R/F):");
        String navigationSequence = inputScanner.next().toUpperCase();

        navigationSequence = validateAndCorrectNavigationSequence(navigationSequence);

        return Arrays.stream(navigationSequence.split("")).map(NavigationCommand::valueOf).toList();
    }

    private static int validateAndCorrectRoomSize(int size) {
        if (size < 1) {
            System.out.println("Room size " + size + " has to be greater than 0\n" +
                    "Enter new room size:");
            size = inputScanner.nextInt();
            size = validateAndCorrectRoomSize(size);
        }
        return size;
    }

    private static int validateAndCorrectRobotPositionInRoom(int position, int roomSize) {
        if (position > roomSize || position < 0) {
            System.out.println("Robot position " + position + " outside of room!\n" +
                    "Enter new position that is within (0," + roomSize + ")");
            position = inputScanner.nextInt();
            position = validateAndCorrectRobotPositionInRoom(position, roomSize);
        }
        return position;
    }

    private static String validateAndCorrectOrientation(String orientation) {
        if (!"N".equals(orientation) && !"S".equals(orientation) && !"W".equals(orientation) && !"E".equals(orientation)) {
            System.out.println("Unsupported robot orientation " + orientation + "!\n" +
                    "Enter new orientation from set: N/S/W/E");
            orientation = inputScanner.next().toUpperCase();
            orientation = validateAndCorrectOrientation(orientation);
        }
        return orientation;
    }

    private static String validateAndCorrectNavigationSequence(String navigationSequence) {
        String wrongOrders = navigationSequence.replace("L", "").replace("R", "").replace("F", "");
        if (wrongOrders.length() > 0) {
            System.out.println("Unsupported robot navigation orders " + wrongOrders + "!\n" +
                    "Enter new navigation orders from set: L/R/F");
            navigationSequence = inputScanner.next().toUpperCase();
            navigationSequence = validateAndCorrectNavigationSequence(navigationSequence);
        }
        return navigationSequence;
    }
}
