package core;

import java.util.*;

import view.Map;
import util.Logger;

/**
 * The SimulationEngine class simulates a multi-level grid-based game environment
 * where the objective is to navigate from a starting point to a target while avoiding obstacles.
 * It evaluates and records the simulation results over multiple levels.
 */
public class SimulationEngine {

    private final int gridSize;
    private final int levels;
    private final int obstacleCount;

    /**
     * Initializes a new instance of the SimulationEngine class with the specified grid size,
     * number of levels, and obstacle count.
     *
     * @param gridSize      the size of the grid for the simulation; the grid will be a square
     *                      with a length and width of gridSize.
     * @param levels        the number of levels to simulate. Each level involves navigating
     *                      from a starting point to a target within the grid.
     * @param obstacleCount the number of obstacles to randomly place in the grid for
     *                      each level, which the route must avoid.
     */
    public SimulationEngine(int gridSize, int levels, int obstacleCount) {
        this.gridSize = gridSize;
        this.levels = levels;
        this.obstacleCount = obstacleCount;
    }

    /**
     * Executes the simulation engine for a specified number of levels.
     * Each level involves navigating from a starting point to a target
     * on a grid with randomly placed obstacles.
     * <p>
     * The method performs the following sequence of operations for each level:
     * - Initializes the starting point and a randomly generated target point on the grid.
     * - Randomly generates a specified number of obstacle points on the grid, avoiding overlap
     * with the start and target points.
     * - Calculates a route from the starting point to the target point, avoiding obstacles,
     * using the GoalManager.
     * - Updates the grid representation with the obstacles, calculated route, and target point.
     * - Logs the simulation details for the current level, including the start point, target point,
     * obstacles, and computed route.
     * - Records success and step statistics if the target is successfully reached.
     * <p>
     * Finally, it outputs a summary of the simulation statistics after all levels have been completed.
     */
    public void run() {
        int totalSuccess = 0;
        int totalSteps = 0;
        Random rand = new Random();
        Map map = new Map(gridSize);

        for (int level = 1; level <= levels; level++) {
            Point startPoint;
            Point targetPoint;
            do {
                startPoint = new Point(rand.nextInt(gridSize), rand.nextInt(gridSize));
                targetPoint = new Point(rand.nextInt(gridSize), rand.nextInt(gridSize));
            } while (targetPoint.equals(startPoint));

            Set<Point> obstacles = new HashSet<>();
            while (obstacles.size() < obstacleCount) {
                Point obstaclePoint = new Point(rand.nextInt(gridSize), rand.nextInt(gridSize));
                if (!obstaclePoint.equals(startPoint) && !obstaclePoint.equals(targetPoint)) {
                    obstacles.add(obstaclePoint);
                }
            }

            GoalManager goalManager = new GoalManager(targetPoint);
            List<Point> route = goalManager.calculateRouteWithObstacles(startPoint, obstacles, gridSize);

            map.update(obstacles, route, targetPoint);
            Logger.logStats(level, startPoint, targetPoint, obstacles, route);
            System.out.println("Grid:");
            map.print();
            System.out.println();

            if (!route.isEmpty() && route.getLast().equals(targetPoint)) {
                totalSuccess++;
                totalSteps += route.size();
            }
        }
        System.out.println("========== SUMMARY ==========");
        System.out.println("Levels played: " + levels);
        System.out.println("Targets reached: " + totalSuccess);
        if (totalSuccess > 0) {
            System.out.printf("Average steps: %.2f\n", (double) totalSteps / totalSuccess);
        } else {
            System.out.println("Average steps: N/A");
        }
    }
}