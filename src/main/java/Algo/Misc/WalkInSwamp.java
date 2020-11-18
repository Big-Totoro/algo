package Algo.Misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The algo walks in swamp and try to find a way to the end of dangerous field.
 * The field is 2D array of integers with 0 and 1 values.
 * 0 is a dangerous swamp and 1 is a safe ground
 */
public class WalkInSwamp {

    /**
     * The class represents the points of the way as the pair of row and column.
     */
    public static class Point {
        int x;
        int y;

        public static Point valueOf(int x, int y) {
            Point point = new Point();
            point.x = x;
            point.y = y;
            return point;
        }

        public int X() {
            return x;
        }

        public int Y() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return String.format("[%d, %d]", x, y);
        }
    }

    public final int SWAMP = 0;
    public final int GROUND = 1;

    /**
     * Finds the safe way in the dangerous field.
     * @param field is the 2D array of integers with 0 and 1 values
     * @return the list of points representing the safe way or an empty list in case the safe way was not found.
     */
    public List<Point> findWay(int[][] field) {
        /**
         * Returns an empty list in case of we doesn't have the data
         */
        if (field.length == 0 && field[0].length == 0) {
            return List.of();
        }

        /**
         * The list stores the list of way points we will found
         */
        List<List<Point>> ways = new ArrayList<>();
        for (int row = 0; row < field.length; row++) {
            /**
             * Looping through the first column of the field and looking for the ground to start the way
             */
            if (field[row][0] == GROUND) {
                /**
                 * The list of way points and our first starting point in it.
                 */
                List<Point> points = new ArrayList<>();
                points.add(Point.valueOf(row, 0));
                ways.add(points);

                /**
                 * Let's go
                 */
                findWay(field, row, 0, points);
            };
        }

        /**
         * We will return only the ways that have the points from the start to the end of the field.
         */
        return ways.stream()
                .filter(l -> l.size() == field[0].length)
                .findFirst()
                .orElse(List.of());
    }

    private boolean findWay(int[][] field, int row, int col, List<Point> points) {
        /**
         * Checking, whether we have reached the other end of the field
         */
        if (col == field[0].length - 1) {
            return true;
        }

        boolean up = false;
        boolean down = false;
        boolean forward = false;

        /**
         * Checking, whether we can go up and forward.
         */
        if ((row != 0) && (field[row - 1][col + 1] != SWAMP)) {
            points.add(Point.valueOf(row - 1, col + 1));
            up = findWay(field, row - 1, col + 1, points);
        } else {
            up = false;
        }

        /**
         * Since we cannot go up and forward, whether we can go down and forward.
         */
        if (!up && (row < field.length - 1) && (field[row + 1][col + 1] != SWAMP)) {
            points.add(Point.valueOf(row + 1, col + 1));
            down = findWay(field, row + 1, col + 1, points);
        } else {
            down = false;
        }

        /**
         * In case of we cannot go up and down, can we go just forward? Is there a swamp going forward?
         */
        if (!up && !down && (field[row][col + 1] != SWAMP)) {
            points.add(Point.valueOf(row, col + 1));
            forward = findWay(field, row, col + 1, points);
        } else {
            forward = false;
        }

        return up || down || forward;
    }
}
