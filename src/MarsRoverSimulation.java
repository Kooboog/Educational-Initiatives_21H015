import java.util.ArrayList;
import java.util.List;

interface Command {
    void execute();
}

class MoveCommand implements Command {
    private Rover rover;

    public MoveCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.move();
    }
}

class TurnLeftCommand implements Command {
    private Rover rover;

    public TurnLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.turnLeft();
    }
}

class TurnRightCommand implements Command {
    private Rover rover;

    public TurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.turnRight();
    }
}

class Grid {
    private int width;
    private int height;
    private List<Obstacle> obstacles;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new ArrayList<>();
    }

    public void addObstacle(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    public boolean hasObstacle(int x, int y) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.isAtPosition(x, y)) {
                return true;
            }
        }
        return false;
    }

    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}

class Obstacle {
    private int x;
    private int y;

    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isAtPosition(int x, int y) {
        return this.x == x && this.y == y;
    }
}

enum Direction {
    N, E, S, W;

    public Direction turnLeft() {
        switch (this) {
            case N:
                return W;
            case W:
                return S;
            case S:
                return E;
            case E:
                return N;
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }

    public Direction turnRight() {
        switch (this) {
            case N:
                return E;
            case E:
                return S;
            case S:
                return W;
            case W:
                return N;
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }
}

class Rover {
    private int x;
    private int y;
    private Direction direction;
    private Grid grid;

    public Rover(int x, int y, Direction direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public void move() {
        int newX = x;
        int newY = y;

        switch (direction) {
            case N:
                newY++;
                break;
            case E:
                newX++;
                break;
            case S:
                newY--;
                break;
            case W:
                newX--;
                break;
        }

        if (grid.isWithinBounds(newX, newY) && !grid.hasObstacle(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public String getStatus() {
        return String.format("Rover is at (%d, %d) facing %s.", x, y, direction);
    }
}

public class MarsRoverSimulation {
    public static void main(String[] args) {
        Grid grid = new Grid(10, 10);
        grid.addObstacle(new Obstacle(2, 2));
        grid.addObstacle(new Obstacle(3, 5));

        Rover rover = new Rover(0, 0, Direction.N, grid);

        List<Command> commands = new ArrayList<>();
        commands.add(new MoveCommand(rover));
        commands.add(new MoveCommand(rover));
        commands.add(new TurnRightCommand(rover));
        commands.add(new MoveCommand(rover));
        commands.add(new TurnLeftCommand(rover));
        commands.add(new MoveCommand(rover));

        for (Command command : commands) {
            command.execute();
        }

        System.out.println(rover.getStatus());
    }
}
