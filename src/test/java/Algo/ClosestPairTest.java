package Algo;

import Algo.Misc.ClosestPair;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ClosestPairTest {

    @Test
    public void test11() {
        ClosestPair closestPair = new ClosestPair();
        ClosestPair.Point result[] = closestPair.findClosestPair1(
                new ClosestPair.Point[] {
                        new ClosestPair.Point(2, 5),
                        new ClosestPair.Point(6, 2),
                        new ClosestPair.Point(3, 3),
                        new ClosestPair.Point(5, 6),
                        new ClosestPair.Point(4, 4),
                });
        assertThat(Arrays.deepEquals(result,
                new ClosestPair.Point[] {
                        new ClosestPair.Point(3, 3),
                        new ClosestPair.Point(4, 4)
                })).isEqualTo(true);
    }


    @Test
    public void test21() {
        ClosestPair closestPair = new ClosestPair();
        ClosestPair.Point result[] = closestPair.findClosestPair2(
                new ClosestPair.Point[] {
                        new ClosestPair.Point(2, 1),
                        new ClosestPair.Point(2, 5),
                        new ClosestPair.Point(6, 2),
                        new ClosestPair.Point(3, 3),
                        new ClosestPair.Point(6, 8),
                        new ClosestPair.Point(5, 6),
                        new ClosestPair.Point(4, 4),
                });
        assertThat(Arrays.deepEquals(result,
                new ClosestPair.Point[] {
                        new ClosestPair.Point(3, 3),
                        new ClosestPair.Point(4, 4)
                })).isEqualTo(true);
    }
}
