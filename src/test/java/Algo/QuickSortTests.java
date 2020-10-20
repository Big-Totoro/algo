package Algo;

import Algo.Sorting.QuickSort;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTests {
    @Test
    public void test11() {
        int[] array = {3, 8, 2, 5, 1, 4, 7, 6};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        assertThat(array).isEqualTo(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
    }
}
