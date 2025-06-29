package util;

import core.Point;

import java.util.*;

/**
 * Utility class for logging details of the simulation, including routes,
 * statistics, and outcomes.
 */
public class Logger {
    public static void logRoute(List<Point> route) {
        System.out.println("Route:");
        for (Point point : route) {
            System.out.println("→ " + point);
        }
    }

    /**
     * Logs detailed information about the current simulation state, including
     * the level, start and target points, obstacles, and the computed route.
     * Outputs whether the target has been reached and the number of steps taken
     * to reach it, if applicable.
     *
     * @param level      the current simulation level.
     * @param start      the starting point for the route.
     * @param target     the target point that needs to be reached.
     * @param obstacles  the set of points representing obstacles in the grid.
     * @param route      the list of points representing the computed route.
     */
    public static void logStats(int level, Point start, Point target, Set<Point> obstacles, List<Point> route) {
        System.out.println("Level " + level);
        System.out.println("Start: " + start);
        System.out.println("Target: " + target);
        System.out.println("Obstacles: " + obstacles);
        logRoute(route);
        if (!route.isEmpty() && route.getLast().equals(target)) {
            System.out.println("✅ Target reached in " + route.size() + " steps.");
        } else {
            System.out.println("❌ No valid path to target.");
        }
    }
}