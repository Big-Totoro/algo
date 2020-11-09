package Algo;

import Algo.Sorting.SelectorSort;
import Algo.Sorting.SortingAlgo;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelectionSortTests {

    @Test
    public void test11() {
        Integer[] array = {5, 4, 3, 2, 1};
        SortingAlgo<Integer> sortingAlgo = new SelectorSort<>();
        sortingAlgo.sort(array);
        assertThat(array).isEqualTo(new Integer[] {1, 2, 3, 4, 5});
    }
}
