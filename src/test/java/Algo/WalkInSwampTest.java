package Algo;

import Algo.Misc.WalkInSwamp;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WalkInSwampTest {
    @Test
    public void test11() {
        final int cols = 7;
        final int rows = 5;
        int[][] field = new int[rows][cols];
        field[0] = new int[] {0, 0, 0, 0, 1, 1, 1};
        field[1] = new int[] {1, 1, 0, 1, 0, 1, 0};
        field[2] = new int[] {0, 0, 1, 1, 0, 0, 1};
        field[3] = new int[] {1, 0 ,0 ,0 ,0, 1, 0};
        field[4] = new int[] {0, 1, 1, 1, 0, 0, 0};

        WalkInSwamp walkInSwamp = new WalkInSwamp();
        List<WalkInSwamp.Point> safeWay = walkInSwamp.findWay(field);
        assertThat(safeWay).isEqualTo(List.of(
                WalkInSwamp.Point.valueOf(1, 0),
                WalkInSwamp.Point.valueOf(1, 1),
                WalkInSwamp.Point.valueOf(2, 2),
                WalkInSwamp.Point.valueOf(1, 3),
                WalkInSwamp.Point.valueOf(0, 4),
                WalkInSwamp.Point.valueOf(1, 5),
                WalkInSwamp.Point.valueOf(0, 6)
        ));
    }

    @Test
    public void test12() {
        final int cols = 7;
        final int rows = 5;
        int[][] field = new int[rows][cols];
        field[0] = new int[] {0, 0, 0, 0, 1, 1, 1};
        field[1] = new int[] {1, 1, 0, 0, 0, 1, 0};
        field[2] = new int[] {0, 0, 1, 1, 0, 0, 1};
        field[3] = new int[] {1, 0 ,0 ,0 ,0, 1, 0};
        field[4] = new int[] {0, 1, 1, 1, 0, 0, 0};

        WalkInSwamp walkInSwamp = new WalkInSwamp();
        List<WalkInSwamp.Point> safeWay = walkInSwamp.findWay(field);
        assertThat(safeWay).isEqualTo(List.of());
    }

    @Test
    public void test13() {
        final int cols = 7;
        final int rows = 1;
        int[][] field = new int[rows][cols];
        field[0] = new int[] {0, 1, 1, 1, 0, 0, 0};

        WalkInSwamp walkInSwamp = new WalkInSwamp();
        List<WalkInSwamp.Point> safeWay = walkInSwamp.findWay(field);
        assertThat(safeWay).isEqualTo(List.of());
    }

    @Test
    public void test14() {
        final int cols = 7;
        final int rows = 5;
        int[][] field = new int[rows][cols];
        field[0] = new int[] {0, 0, 0, 0, 0, 0, 0};
        field[1] = new int[] {0, 0, 0, 1, 0, 0, 0};
        field[2] = new int[] {0, 0, 1, 0, 1, 0, 1};
        field[3] = new int[] {0, 1 ,0 ,0 ,0, 1, 0};
        field[4] = new int[] {1, 0, 0, 0, 0, 0, 1};

        WalkInSwamp walkInSwamp = new WalkInSwamp();
        List<WalkInSwamp.Point> safeWay = walkInSwamp.findWay(field);
        assertThat(safeWay).isEqualTo(List.of(
                WalkInSwamp.Point.valueOf(4, 0),
                WalkInSwamp.Point.valueOf(3, 1),
                WalkInSwamp.Point.valueOf(2, 2),
                WalkInSwamp.Point.valueOf(1, 3),
                WalkInSwamp.Point.valueOf(2, 4),
                WalkInSwamp.Point.valueOf(3, 5),
                WalkInSwamp.Point.valueOf(2, 6)
        ));
    }
}