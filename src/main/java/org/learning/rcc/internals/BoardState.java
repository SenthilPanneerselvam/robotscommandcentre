package org.learning.rcc.internals;

import org.learning.rcc.models.Board;
import org.learning.rcc.models.Grid;
import org.learning.rcc.models.Robot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardState {

    private static final BoardState _instance = new BoardState();

    // gives the board for the program
    // gives the list of robots for the program
    // gives the location of a robot
    // has the collection of all locations occupied and robots

    private final Integer NUMBER_OF_ROBOTS = 5;
    private final Integer BOARD_LENGTH = 10;
    private final Integer BOARD_BREADTH = 10;

    private final List<Robot> robots = new ArrayList<>();
    private Board board= null;
    private final Map<Grid, Robot> gridRobotMapping = new HashMap<>();
    private static boolean initialized = false;

    private BoardState() {}

    public static BoardState getInstance() {
        if(!initialized)
            _instance.init();
        return _instance;
    }

    private synchronized void init() {
        initBoard(BOARD_LENGTH, BOARD_BREADTH);
        initRobots(NUMBER_OF_ROBOTS);
        initialized = true;
    }

    public void initRobots(int count) {
        robots.clear();
        for(int i=1;i<count;i++) {
            Robot robot = new Robot("R" + i);
            Grid grid = new Grid(0, i-1);
            robot.setGrid(grid);
            if(!putRobotInGrid(robot, grid)) {
                throw new RuntimeException(grid + " is already occupied");
            }
            robots.add(robot);
        }
    }

    public void initRobots(Grid... grids) {
        if(!isBoardInitialized()) {
            throw new RuntimeException("Board is not initialised / not initialised properly");
        }
        boolean validGrids = List.of(grids).stream().allMatch(board::isGridValid);
        if(!validGrids) {
            throw new RuntimeException("One / more Grids are not valid");
        }
        robots.clear();
        int i=1;
        for(Grid grid: grids) {
            Robot robot = new Robot("R" + i++);
            robot.setGrid(grid);
            if(!putRobotInGrid(robot, grid)) {
                throw new RuntimeException(grid + " is already occupied");
            }
            robots.add(robot);
        }
    }

    private boolean isBoardInitialized() {
        return board != null && board.getBreadth() == null && board.getLength() == null;
    }

    public void initBoard(Integer length, Integer breadth) {
        board = new Board(length, breadth);
    }

    public synchronized boolean putRobotInGrid(Robot robot, Grid grid) {
        boolean put = false;
        Robot existingRobot = gridRobotMapping.get(grid);
        if(existingRobot == null) {
            this.gridRobotMapping.put(grid, robot);
            put = true;
        }
        return put;
    }

    public synchronized void reset() {
        gridRobotMapping.clear();
        robots.clear();
        board = null;
    }

}
