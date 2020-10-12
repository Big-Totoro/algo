package Algo;

import Algo.Misc.MatrixMultiplication;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatrixMulTest {

    private static MatrixMultiplication matrixMultiplication;

    @BeforeClass
    public static void setup() {
        matrixMultiplication = new MatrixMultiplication();
    }

    @Test
    public void test1() {
        int[][] x = {{9, 3, 5}, {2, 0, 3}, {0, -1, 6}};
        int[][] y = {{1, -1, -1}, {-1, 4, 7}, {8, 1, -1}};

        assertThat(matrixMultiplication.multiply(x, y)).isDeepEqualTo(new int[][] {{46, 8, 7}, {26, 1, -5}, {-49, -2, 13}});
    }
}