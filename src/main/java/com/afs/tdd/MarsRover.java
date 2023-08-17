package com.afs.tdd;

import java.util.List;

public class MarsRover {

    private Location location;

    public MarsRover(Location location) {
        this.location = location;
    }

    private void executeMove(Direction direction) {
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

    private void executeTurnLeft(Direction direction) {
        final int x = location.getX();
        final int y = location.getY();
        if (direction == Direction.NORTH) {
            setDirectionToWest(x, y);
        } else if (direction == Direction.SOUTH) {
            setDirectionToEast(x, y);
        } else if (direction == Direction.WEST) {
            setDirectionToSouth(x, y);
        } else {
            setDirectionToNorth(x, y);
        }
    }

    private void executeTurnRight(Direction direction) {
        final int x = location.getX();
        final int y = location.getY();
        if (direction == Direction.NORTH) {
            setDirectionToEast(x, y);
        } else if (direction == Direction.SOUTH) {
            setDirectionToWest(x, y);
        } else if (direction == Direction.WEST) {
            setDirectionToNorth(x, y);
        } else {
            setDirectionToSouth(x, y);
        }
    }

    private void setDirectionToNorth(int x, int y) {
        this.location = new Location(x, y, Direction.NORTH);
    }

    private void setDirectionToSouth(int x, int y) {
        this.location = new Location(x, y, Direction.SOUTH);
    }

    private void setDirectionToWest(int x, int y) {
        this.location = new Location(x, y, Direction.WEST);
    }

    private void setDirectionToEast(int x, int y) {
        this.location = new Location(x, y, Direction.EAST);
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
