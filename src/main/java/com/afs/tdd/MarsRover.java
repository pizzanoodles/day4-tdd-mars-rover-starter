package com.afs.tdd;

import java.util.List;

public class MarsRover {

    private Location location;

    public MarsRover(Location location) {
        this.location = location;
    }

    public void executeMove(Direction direction) {
        if (direction == Direction.NORTH) {
            location.setY(location.getY() + 1);
        } else if (direction == Direction.SOUTH) {
            location.setY(location.getY() - 1);
        } else if (direction == Direction.WEST) {
            location.setX(location.getX() - 1);
        } else {
            location.setX(location.getX() + 1);
        }
    }

    public void executeTurnLeft(Direction direction) {
        final int x = location.getX();
        final int y = location.getY();
        if (direction == Direction.NORTH) {
            this.location = new Location(x, y, Direction.WEST);
        } else if (direction == Direction.SOUTH) {
            this.location = new Location(x, y, Direction.EAST);
        } else if (direction == Direction.WEST) {
            this.location = new Location(x, y, Direction.SOUTH);
        } else {
            this.location = new Location(x, y, Direction.NORTH);
        }
    }

    public void executeTurnRight(Direction direction) {
        final int x = location.getX();
        final int y = location.getY();
        if (direction == Direction.NORTH) {
            this.location = new Location(x, y, Direction.EAST);
        } else if (direction == Direction.SOUTH) {
            this.location = new Location(x, y, Direction.WEST);
        } else if (direction == Direction.WEST) {
            this.location = new Location(x, y, Direction.NORTH);
        } else {
            this.location = new Location(x, y, Direction.SOUTH);
        }
    }

    public void executeCommand(Command givenCommand) {
        if (givenCommand == Command.MOVE) {
            executeMove(location.getDirection());
        } else if (givenCommand == Command.TURN_LEFT) {
            executeTurnLeft(location.getDirection());
        } else if (givenCommand == Command.TURN_RIGHT) {
            executeTurnRight(location.getDirection());
        }
    }

    public void executeBatchCommands(List<Command> givenCommands) {
        givenCommands.forEach(this::executeCommand);
    }

    public Location getCurrentLocation() {
        return location;
    }
}
