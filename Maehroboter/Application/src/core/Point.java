package core;

import java.util.Objects;

/**
 * Represents a point in a 2D Cartesian coordinate system with integer x and y coordinates.
 * This class is immutable and provides appropriate implementations for equality checking,
 * hashing, and string representation.
 */
public class Point {

    /**
     * The x-coordinate of this point in a 2D Cartesian coordinate system.
     * Represents the horizontal position of the point.
     */
    public int x;

    /**
     * The y-coordinate of this point in a 2D Cartesian coordinate system.
     * Represents the vertical position of the point.
     */
    public int y;

    /**
     * Constructs a new {@code Point} instance representing a point in a 2D Cartesian coordinate system.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point other = (Point) o;
        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
