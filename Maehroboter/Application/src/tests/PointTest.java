package tests;

import core.Point;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    @Test
    public void testEquality() {
        Point a = new Point(1, 2);
        Point b = new Point(1, 2);
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void testInequality() {
        Point a = new Point(1, 2);
        Point b = new Point(2, 1);
        assertNotEquals(a, b);
    }
}
