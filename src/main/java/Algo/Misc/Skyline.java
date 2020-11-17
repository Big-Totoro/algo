package Algo.Misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Skyline {
    public static class Building {
        int x1;
        int x2;
        int h;

        public static Building valueOf(int x1, int x2, int h) {
            Building building = new Building();

            building.x1 = x1;
            building.x2 = x2;
            building.h = h;

            return building;
        }

        public int getX1() {
            return x1;
        }

        public int getX2() {
            return x2;
        }

        public int getH() {
            return h;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Building building = (Building) o;
            return x1 == building.x1 &&
                    x2 == building.x2 &&
                    h == building.h;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, x2, h);
        }

        @Override
        public String toString() {
            return "{" +
                    "x1=" + x1 +
                    ", x2=" + x2 +
                    ", h=" + h +
                    '}';
        }
    }

    public static class Pair {
        int x;
        int h;

        public int getX() {
            return x;
        }

        public int getH() {
            return h;
        }

        public static Pair valueOf(int x, int h) {
            Pair pair = new Pair();
            pair.x = x;
            pair.h = h;
            return pair;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    h == pair.h;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, h);
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", h=" + h +
                    '}';
        }
    }

    public List<Pair> computeSkyline(Building[] buildings) {
        if (buildings.length == 0) {
            return List.of();
        } else if (buildings.length == 1) {
            List<Pair> result = new ArrayList<>(2);
            result.add(Pair.valueOf(buildings[0].getX1(), buildings[0].h));
            result.add(Pair.valueOf(buildings[0].getX2(), 0));
            return result;
        }

        int mid = buildings.length / 2;
        Building[] l = Arrays.copyOfRange(buildings, 0, mid);
        Building[] r = Arrays.copyOfRange(buildings, mid, buildings.length);

        List<Pair> left = computeSkyline(l);
        List<Pair> right = computeSkyline(r);

        return merge(left, right);
    }

    private List<Pair> merge(List<Pair> left, List<Pair> right) {
        List<Pair> pairs = new ArrayList<>();

        int i = 0;
        int j = 0;
        int hLeft = 0;
        int hRight = 0;
        int x = 0;
        int maxH = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getX() < right.get(j).getX()) {
                x = left.get(i).getX();
                hLeft = left.get(i).getH();
                i++;
            } else if (left.get(i).getX() > right.get(j).getX()) {
                x = right.get(j).getX();
                hRight = right.get(j).getH();
                j++;
            } else {
                hLeft = left.get(i).getH();
                hRight = right.get(j).getH();
                x = left.get(i).getX();
                ++i;
                ++j;
            }

            if (maxH != Math.max(hLeft, hRight)) {
                maxH = Math.max(hLeft, hRight);
                if (pairs.size() > 0) {
                    if (pairs.get(pairs.size() - 1).getX() != x && pairs.get(pairs.size() - 1).getH() != maxH) {
                        pairs.add(Pair.valueOf(x, maxH));
                    }
                } else {
                    pairs.add(Pair.valueOf(x, maxH));
                }
            }
        }

        while (i < left.size()) {
            pairs.add(Pair.valueOf(left.get(i).getX(), left.get(i).getH()));
            i++;
        }

        while (j < right.size()) {
            pairs.add(Pair.valueOf(right.get(j).getX(), right.get(j).getH()));
            j++;
        }

        return pairs;
    }
}