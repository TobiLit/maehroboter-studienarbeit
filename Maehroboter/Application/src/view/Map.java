package view;

import core.Point;

import java.util.*;

/**
 * The Map class represents a grid-based map for a simulation, designed to manage and display
 * a visual representation of obstacles, a route, and target points.
 */
public class Map {
    private final int size;
    private final char[][] grid;

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";

    /**
     * Constructs a new Map instance with the specified size.
     * The grid is initialized as a square grid with all cells set to their default values.
     *
     * @param size the size of the grid for the Map, representing both its width and height.
     *             The value should be a positive integer.
     */
    public Map(int size) {
        this.size = size;
        this.grid = new char[size][size];
    }

    /**
     * Updates the grid representation by resetting all cells to their default state,
     * and then marking specific cells based on the provided obstacles, route, and target.
     *
     * @param obstacles a set of points representing the positions of obstacles on the grid.
     *                  Each point in this set corresponds to a cell that will be marked as an obstacle.
     * @param route     a list of points representing a path on the grid. Each point in this list
     *                  corresponds to a cell that will be marked as part of the route.
     * @param target    a point representing the target position on the grid. The cell at this position
     *                  will be marked as the target.
     */
    public void update(Set<Point> obstacles, List<Point> route, Point target) {
        for (int column = 0; column < size; column++) {
            for (int row = 0; row < size; row++) {
                grid[column][row] = '.';
            }
        }
        for (Point point : obstacles) {
            grid[point.y][point.x] = 'X';
        }
        for (Point point : route) {
            grid[point.y][point.x] = '*';
        }
        grid[target.y][target.x] = 'Z';
    }

    /**
     * Prints the current state of the grid to the console. Each cell is displayed with a color
     * corresponding to its content:
     * - '*' (green): Part of the route.
     * - 'X' (red): Represents an obstacle.
     * - 'Z' (blue): The target point.
     * - Any other character is printed in its default color.
     * <p>
     * Each row of the grid is printed on a new line, and cells within the same row are separated by spaces.
     */
    public void print() {
        for (char[] row : grid) {
            for (char c : row) {
                if (c == '*') {
                    System.out.print(GREEN + c + RESET + " ");
                } else if (c == 'X') {
                    System.out.print(RED + c + RESET + " ");
                } else if (c == 'Z') {
                    System.out.print(BLUE + c + RESET + " ");
                } else {
                    System.out.print(c + " ");
                }
            }
            System.out.println();
        }
    }
}