package Algo;

import Algo.Sorting.QuickSort;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortTests {
    @Test
    public void test11() {
        Integer[] array = {3, 8, 2, 5, 1, 4, 7, 6};
        QuickSort<Integer> quickSort = new QuickSort<>();
        quickSort.sort(array);
        assertThat(array).isEqualTo(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8});
    }
}
