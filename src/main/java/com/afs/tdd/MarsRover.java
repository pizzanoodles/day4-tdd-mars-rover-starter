package com.afs.tdd;

import java.util.List;

public class MarsRover {

    private Location location;

    public MarsRover(Location location) {
        this.location = location;
    }

    public void executeCommand(Command givenCommand) {
        if (givenCommand == Command.MOVE) {
            if (location.getDirection() == Direction.NORTH) {
                location.setY(location.getY() + 1);
            } else if (location.getDirection() == Direction.SOUTH) {
                location.setY(location.getY() - 1);
            } else if (location.getDirection() == Direction.EAST) {
                location.setX(location.getX() + 1);
            } else if (location.getDirection() == Direction.WEST) {
                location.setX(location.getX() - 1);
            }
        } else if (givenCommand == Command.TURN_LEFT) {
            if (location.getDirection() == Direction.NORTH) {
                this.location = new Location(location.getX(), location.getY(), Direction.WEST);
            } else if (location.getDirection() == Direction.SOUTH) {
                this.location = new Location(location.getX(), location.getY(), Direction.EAST);
            } else if (location.getDirection() == Direction.WEST) {
                this.location = new Location(location.getX(), location.getY(), Direction.SOUTH);
            } else if (location.getDirection() == Direction.EAST) {
                this.location = new Location(location.getX(), location.getY(), Direction.NORTH);
            }
        } else if (givenCommand == Command.TURN_RIGHT) {
            if (location.getDirection() == Direction.NORTH) {
                this.location = new Location(location.getX(), location.getY(), Direction.EAST);
            } else if (location.getDirection() == Direction.SOUTH) {
                this.location = new Location(location.getX(), location.getY(), Direction.WEST);
            } else if (location.getDirection() == Direction.WEST) {
                this.location = new Location(location.getX(), location.getY(), Direction.NORTH);
            } else if (location.getDirection() == Direction.EAST) {
                this.location = new Location(location.getX(), location.getY(), Direction.SOUTH);
            }
        }
    }
    public void executeBatchCommands(List<Command> givenCommands) {
        givenCommands.forEach(this::executeCommand);
    }

    public Location getCurrentLocation() {
        return location;
    }
}
