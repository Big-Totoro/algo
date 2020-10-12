package Algo.Misc;

import java.util.*;

public class ClosestPair {
    public static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
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
            return "(" + x + "," + y + ")";
        }

        public static double distance(Point p1, Point p2) {
            return Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2);
        }
    }

    private static class ClosestDist {
        private Point p1;
        private Point p2;
        private Double distance;

        public ClosestDist(Point p1, Point p2, Double distance) {
            this.p1 = p1;
            this.p2 = p2;
            this.distance = distance;
        }

        public Point getP1() {
            return p1;
        }

        public Point getP2() {
            return p2;
        }

        public Double getDistance() {
            return distance;
        }

        @Override
        public String toString() {
            return "{" + p1 + ", " + p2 + ", " + distance + '}';
        }
    }

    public Point[] findClosestPair1(Point[] points) {
        double dist = Double.MAX_VALUE;
        Point point1 = null;
        Point point2 = null;

        for (Point p1 : points) {
            for (Point p2 : points) {
                double d = Point.distance(p1, p2);
                if ((dist > d) && (d > 0)) {
                    point1 = p1;
                    point2 = p2;
                    dist = d;
                }
            }
        }

        return new Point[] {point1, point2};
    }

    public Point[] findClosestPair2(Point[] points) {
        if (points.length <= 1) {
            return points;
        }

        Point[] sortedByX = points.clone();
        Arrays.sort(sortedByX, Comparator.comparingInt(Point::getX));

        Point[] sortedByY = points.clone();
        Arrays.sort(sortedByY, Comparator.comparingInt(Point::getY));

        ClosestDist closestDist = findDistance(sortedByX, sortedByY);

        return new Point[] {closestDist.getP1(), closestDist.getP2()};
    }

    private ClosestDist findDistance(Point[] Px, Point[] Py) {
        if (Px.length <= 3) {
            return bruteForce(Px);
        }

        int mid = Px.length / 2;
        Point[] left = Arrays.copyOfRange(Px, 0, mid);
        Point[] right = Arrays.copyOfRange(Px, mid, Px.length);

        ClosestDist dl = findDistance(left, Py);
        ClosestDist dr = findDistance(right, Py);
        ClosestDist minDist = min(dl, dr);

        Point midX = left[left.length - 1];
        List<Point> Sy = new ArrayList<>();

        for (Point py : Py) {
            if ((py.getX() > midX.getX() - minDist.getDistance()) &&
                    (py.getX() < midX.getX() + minDist.getDistance())) {
                Sy.add(py);
            }
        }

        Double min = Double.MAX_VALUE;
        for (int i = 0; i < Sy.size(); ++i) {
            for (int j = i + 1; j < Math.min(7, Sy.size()); ++j) {
                Double d = Point.distance(Sy.get(i), Sy.get(j));
                if (min > d) {
                    min = d;
                    minDist = new ClosestDist(Sy.get(i), Sy.get(j), d);
                }
            }
        }

        return minDist;
    }

    private ClosestDist bruteForce(Point[] points) {
        Point p1 = null;
        Point p2 = null;
        Double maxDist = Double.MAX_VALUE;

        for (int i = 0; i < points.length; ++i) {
            for (int j = 0; j < points.length; ++j) {
                if (i != j) {
                    Double d = Point.distance(points[i], points[j]);
                    if (maxDist > d) {
                        maxDist = d;
                        p1 = points[i];
                        p2 = points[j];
                    }
                }
            }
        }

        return new ClosestDist(p1, p2, maxDist);
    }

    private ClosestDist min(ClosestDist left, ClosestDist right) {
        if (left.getDistance() < right.getDistance()) {
            return left;
        }
        return right;
    }
}
