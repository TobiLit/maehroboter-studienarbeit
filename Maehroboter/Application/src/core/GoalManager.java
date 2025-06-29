package core;

import java.util.*;

/**
 * The GoalManager class is responsible for managing navigation towards a target point
 * within a 2D grid while avoiding obstacles. It offers functionality to calculate
 * a route from a starting point to a target point, adhering to specific constraints.
 */
public class GoalManager {
    private final Point target;

    /**
     * Constructs a GoalManager instance with a specified target point.
     *
     * @param target the target point to navigate towards, represented as a Point
     */
    public GoalManager(Point target) {
        this.target = target;
    }

    /**
     * Calculates a route through a 2D grid from a starting point to a target point,
     * avoiding specified obstacles. The method uses a breadth-first search algorithm
     * to ensure the shortest path is returned, if one exists.
     *
     * @param start     the starting point for the route, represented as a Point
     * @param obstacles a set of points representing obstacles that the route must avoid
     * @param gridSize  the size of the grid (assumed to be square) within which the route is calculated
     * @return a list of points representing the calculated route from the start to the target.
     * If no route is found, an empty list is returned
     */
    public List<Point> calculateRouteWithObstacles(Point start, Set<Point> obstacles, int gridSize) {
        Queue<List<Point>> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        List<Point> initial = new ArrayList<>();
        initial.add(start);
        queue.add(initial);
        visited.add(start);

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            List<Point> path = queue.poll();
            Point current = path.getLast();

            if (current.equals(target)) {
                return path;
            }

            for (int[] direction : directions) {
                int nx = current.x + direction[0];
                int ny = current.y + direction[1];
                Point neighbor = new Point(nx, ny);
                if (nx >= 0 && ny >= 0 && nx < gridSize && ny < gridSize &&
                        !visited.contains(neighbor) && !obstacles.contains(neighbor)) {
                    visited.add(neighbor);
                    List<Point> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.add(newPath);
                }
            }
        }
        return new ArrayList<>();
    }
}