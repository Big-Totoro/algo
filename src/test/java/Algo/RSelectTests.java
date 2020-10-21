package Algo;

import Algo.Misc.RSelect;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RSelectTests {
    @Test
    public void test11() {
        RSelect select = new RSelect();
        assertThat(select.select(new int[] {3, 8, 2, 5, 1, 4, 7, 6}, 3)).isEqualTo(4);
    }

    @Test
    public void test12() {
        RSelect select = new RSelect();
        assertThat(select.select(new int[] {10, 4, 5, 8, 6, 11, 26}, 2)).isEqualTo(6);
    }
}
