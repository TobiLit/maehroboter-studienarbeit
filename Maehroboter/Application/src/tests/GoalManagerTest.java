package tests;

import core.GoalManager;
import core.Point;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GoalManagerTest {

    @Test
    public void testPathFound() {
        Point start = new Point(0, 0);
        Point target = new Point(4, 2);
        Set<Point> obstacles = new HashSet<>();
        GoalManager manager = new GoalManager(target);
        List<Point> route = manager.calculateRouteWithObstacles(start, obstacles, 5);

        assertFalse(route.isEmpty(), "Route should not be empty");
        assertEquals(target, route.getLast(), "Last point should be target");
    }

    @Test
    public void testNoPathWhenBlocked() {
        Point start = new Point(0, 0);
        Point target = new Point(1, 0);
        Set<Point> obstacles = new HashSet<>();
        obstacles.add(new Point(1, 0));
        GoalManager manager = new GoalManager(target);
        List<Point> route = manager.calculateRouteWithObstacles(start, obstacles, 4);

        assertTrue(route.isEmpty(), "Route should be empty when target is blocked");
    }
}