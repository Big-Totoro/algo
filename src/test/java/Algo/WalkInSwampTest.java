package Algo;

import Algo.Misc.WalkInSwamp;
import org.junit.Test;

import java.util.List;

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
        System.out.println(safeWay);
    }
}
