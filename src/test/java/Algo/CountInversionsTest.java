package Algo;

import Algo.Misc.CountInversions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountInversionsTest {

    @Test
    public void test1() {
        CountInversions countInversions = new CountInversions();
        Integer[] unsorted = {1, 3, 5, 2, 4, 6};

        assertThat(countInversions.countInversions(unsorted)).isEqualTo(3);
    }

    @Test
    public void test2() {
        CountInversions countInversions = new CountInversions();
        Integer[] unsorted = {2, 4, 3, 5, 1};

        assertThat(countInversions.countInversions(unsorted)).isEqualTo(5);
    }


    @Test
    public void test3() {
        CountInversions countInversions = new CountInversions();
        Integer[] unsorted = {2, 4, 3, 5, 1};

        assertThat(countInversions.countInversions(unsorted)).isEqualTo(5);
    }

    @Test
    public void test4() {
        CountInversions countInversions = new CountInversions();
        Integer[] unsorted = {1, 3, 2, 5, 4, 6};

        assertThat(countInversions.countInversions(unsorted)).isEqualTo(2);
    }
}
